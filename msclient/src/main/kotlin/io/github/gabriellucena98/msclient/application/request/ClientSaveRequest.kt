package io.github.gabriellucena98.msclient.application.request

import io.github.gabriellucena98.msclient.domain.Client

data class ClientSaveRequest(
    val cpf: String,
    val name: String,
    val age: Long
) {
    fun toDomain(): Client {
        return Client(
            cpf = this.cpf,
            name = this.name,
            age = this.age
        )
    }
}