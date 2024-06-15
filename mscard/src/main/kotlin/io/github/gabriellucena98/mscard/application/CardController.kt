package io.github.gabriellucena98.mscard.application

import io.github.gabriellucena98.mscard.application.request.CardSaveRequest
import io.github.gabriellucena98.mscard.application.response.ClientCardResponse
import io.github.gabriellucena98.mscard.domain.Card
import io.github.gabriellucena98.mscard.domain.ClientCard
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardController(
    private val cardService: CardService,
    private val clientCardService: ClientCardService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerCard(@RequestBody request: CardSaveRequest) {
        val card = request.toDomain()
        cardService.save(card)
    }

    @GetMapping(params = ["income"])
    @ResponseStatus(HttpStatus.OK)
    fun getCardsLessThanOrEqualTo(@RequestParam("income") income: Long): List<Card> {
        return cardService.getCardsLessThanOrEqualTo(income)
    }

    @GetMapping(params = ["cpf"])
    @ResponseStatus(HttpStatus.OK)
    fun getCardsByCpf(@RequestParam("cpf") cpf: String): List<ClientCardResponse>? {
        return clientCardService.listCardsByCpf(cpf)?.map { it.toDTO() }
    }

}