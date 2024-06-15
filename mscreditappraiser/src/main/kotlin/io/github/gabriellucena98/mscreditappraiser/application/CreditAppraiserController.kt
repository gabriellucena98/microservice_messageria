package io.github.gabriellucena98.mscreditappraiser.application

import io.github.gabriellucena98.mscreditappraiser.application.request.EvaluationData
import io.github.gabriellucena98.mscreditappraiser.domain.CardIssuanceRequestData
import io.github.gabriellucena98.mscreditappraiser.domain.CardsApproved
import io.github.gabriellucena98.mscreditappraiser.domain.ClientStatus
import io.github.gabriellucena98.mscreditappraiser.domain.ProtocolRequestCard
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/credit-appraiser")
class CreditAppraiserController(
    private val creditAppraiserService: CreditAppraiserService
) {

    @GetMapping("/status")
    fun apiStatus(): String {
        return "ok"
    }

    @GetMapping("/client-status", params = ["cpf"])
    @ResponseStatus(HttpStatus.OK)
    fun clientStatus(@RequestParam cpf: String): ClientStatus {
        return creditAppraiserService.getClientStatusByCpf(cpf)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun creditEvaluation(@RequestBody data: EvaluationData): List<CardsApproved> {
        return creditAppraiserService.creditEvaluation(data)
    }

    @PostMapping("/request-card")
    @ResponseStatus(HttpStatus.CREATED)
    fun requestCard(@RequestBody data: CardIssuanceRequestData): ProtocolRequestCard {
        return creditAppraiserService.requestCardIssuance(data)
    }
}