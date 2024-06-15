package io.github.gabriellucena98.mscreditappraiser.domain

data class ClientStatus(
    val client: ClientData,
    val cards: List<ClientCard>?,
)
