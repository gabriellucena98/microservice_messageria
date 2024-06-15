package io.github.gabriellucena98.mscreditappraiser.domain

data class Client(
    val id: Long,
    val cpf: String,
    val name: String,
    val age: Long
)
