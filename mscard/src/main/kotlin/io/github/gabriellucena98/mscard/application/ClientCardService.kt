package io.github.gabriellucena98.mscard.application

import io.github.gabriellucena98.mscard.domain.ClientCard
import io.github.gabriellucena98.mscard.infra.repository.ClientCardRepository
import org.springframework.stereotype.Service

@Service
class ClientCardService(
    private val clientCardRepository: ClientCardRepository
) {

    fun listCardsByCpf(cpf: String): List<ClientCard>? {
        return clientCardRepository.findByCpf(cpf)
    }
}