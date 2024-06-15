package io.github.gabriellucena98.mscard.infra.mqueue

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.gabriellucena98.mscard.domain.CardIssuanceRequestData
import io.github.gabriellucena98.mscard.domain.ClientCard
import io.github.gabriellucena98.mscard.infra.repository.CardRepository
import io.github.gabriellucena98.mscard.infra.repository.ClientCardRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class CardIssuanceSubscriber(
    private val cardRepository: CardRepository,
    private val clientCardRepository: ClientCardRepository
) {

    @RabbitListener(queues = ["\${mq.queues.card-issuance}"])
    fun receiverIssuanceRequest(@Payload payload: String) {
        try {
            val mapper = ObjectMapper()
            val data = mapper.readValue(payload, CardIssuanceRequestData::class.java)

            val card = cardRepository.findById(data.cardId).orElseThrow()
            val clientCard = ClientCard(id = -1, cpf = data.cpf, card = card, clientLimit = data.clientLimit)

            clientCardRepository.save(clientCard)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}