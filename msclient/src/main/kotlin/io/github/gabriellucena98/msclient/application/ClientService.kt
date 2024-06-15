package io.github.gabriellucena98.msclient.application

import io.github.gabriellucena98.msclient.domain.Client
import io.github.gabriellucena98.msclient.infra.repository.ClientRepository
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository
) {

    @Transactional
    fun save(client: Client) {
        clientRepository.save(client)
    }

    fun getByCpf(cpf: String): Client {
        val client = clientRepository.findByCpf(cpf)

        if (client != null) {
            return client
        } else {
            throw ClassNotFoundException("Not found client by cpf: $cpf")
        }
    }
}