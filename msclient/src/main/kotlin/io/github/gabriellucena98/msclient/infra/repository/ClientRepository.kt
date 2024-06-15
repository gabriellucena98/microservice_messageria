package io.github.gabriellucena98.msclient.infra.repository

import io.github.gabriellucena98.msclient.domain.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: JpaRepository<Client, Long> {

    fun findByCpf(cpf: String): Client?
}