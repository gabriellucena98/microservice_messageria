package io.github.gabriellucena98.mscreditappraiser.infra.client

import io.github.gabriellucena98.mscreditappraiser.domain.ClientData
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "msclient", path = "/clients")
interface ClientControllerClient {

    @GetMapping(params = ["cpf"])
    fun getByCpf(
        @RequestParam cpf: String
    ): ClientData
}