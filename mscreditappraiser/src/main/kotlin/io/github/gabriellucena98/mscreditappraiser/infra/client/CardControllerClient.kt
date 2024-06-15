package io.github.gabriellucena98.mscreditappraiser.infra.client

import io.github.gabriellucena98.mscreditappraiser.domain.ClientCard
import io.github.gabriellucena98.mscreditappraiser.domain.Card
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "mscard", path = "/cards")
interface CardControllerClient {

    @GetMapping(params = ["cpf"])
    fun getCardsByCpf(
        @RequestParam cpf: String
    ): List<ClientCard>

    @GetMapping(params = ["income"])
    fun getCardsLessThanOrEqualTo(
        @RequestParam income: Long
    ): List<Card>
}