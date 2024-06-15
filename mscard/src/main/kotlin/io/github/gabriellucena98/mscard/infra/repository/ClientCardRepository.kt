package io.github.gabriellucena98.mscard.infra.repository

import io.github.gabriellucena98.mscard.domain.ClientCard
import org.springframework.data.jpa.repository.JpaRepository

interface ClientCardRepository: JpaRepository<ClientCard, Long> {

    fun findByCpf(cpf: String): List<ClientCard>?
}