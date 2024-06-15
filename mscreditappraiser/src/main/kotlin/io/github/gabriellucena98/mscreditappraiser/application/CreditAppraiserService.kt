package io.github.gabriellucena98.mscreditappraiser.application

import feign.FeignException.FeignClientException
import io.github.gabriellucena98.mscreditappraiser.application.ex.ClientDataNotFoundException
import io.github.gabriellucena98.mscreditappraiser.application.ex.ErrorRequestCardException
import io.github.gabriellucena98.mscreditappraiser.application.request.EvaluationData
import io.github.gabriellucena98.mscreditappraiser.domain.Card
import io.github.gabriellucena98.mscreditappraiser.domain.CardIssuanceRequestData
import io.github.gabriellucena98.mscreditappraiser.domain.CardsApproved
import io.github.gabriellucena98.mscreditappraiser.domain.ClientStatus
import io.github.gabriellucena98.mscreditappraiser.domain.ProtocolRequestCard
import io.github.gabriellucena98.mscreditappraiser.infra.client.CardControllerClient
import io.github.gabriellucena98.mscreditappraiser.infra.client.ClientControllerClient
import io.github.gabriellucena98.mscreditappraiser.infra.mqueue.CardIssuancePublisher
import java.math.BigDecimal
import java.util.*
import org.apache.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class CreditAppraiserService(
    private val clientControllerClient: ClientControllerClient,
    private val cardControllerClient: CardControllerClient,
    private val cardIssuancePublisher: CardIssuancePublisher
) {

    fun getClientStatusByCpf(cpf: String): ClientStatus {
        try {
            val clientData = clientControllerClient.getByCpf(cpf)
            val cardsResponse = cardControllerClient.getCardsByCpf(cpf)

            return ClientStatus(
                client = clientData,
                cards = cardsResponse
            )
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception(e.message!!)
        }
    }

    fun creditEvaluation(data: EvaluationData): List<CardsApproved> {
        try {
            val clientData = clientControllerClient.getByCpf(data.cpf)
            val clientCardsAvailable = cardControllerClient.getCardsLessThanOrEqualTo(data.income)

            return clientCardsAvailable.map { card ->
                val limit = card.cardLimit
                val age = BigDecimal.valueOf(clientData.age)
                val coefficient = age.divide(BigDecimal.valueOf(10))
                val calculatedLimit = coefficient.multiply(limit)

                CardsApproved(card = card.name, cardFlag = card.cardFlag, approvedLimit = calculatedLimit)
            }

        } catch (e: FeignClientException) {
            val status = e.status()
            if (HttpStatus.SC_NOT_FOUND == status) {
                throw ClientDataNotFoundException()
            }
            throw Exception(e.message!!)
        }
    }

    fun requestCardIssuance(data: CardIssuanceRequestData): ProtocolRequestCard {
        try {
            cardIssuancePublisher.requestCard(data)
            val protocol = UUID.randomUUID().toString()
            return ProtocolRequestCard(protocol)
        } catch (e: Exception) {
            throw ErrorRequestCardException(e.message)
        }
    }

}