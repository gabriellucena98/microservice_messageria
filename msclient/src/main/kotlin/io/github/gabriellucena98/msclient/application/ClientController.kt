package io.github.gabriellucena98.msclient.application

import io.github.gabriellucena98.msclient.application.request.ClientSaveRequest
import io.github.gabriellucena98.msclient.domain.Client
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clients")
class ClientController(
    private val clientService: ClientService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(
        @RequestBody request: ClientSaveRequest
    ) {
        val client = request.toDomain()
        clientService.save(client)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getByCpf(
        @RequestParam cpf: String
    ): Client {
        return clientService.getByCpf(cpf)
    }

}