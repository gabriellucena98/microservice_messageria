package io.github.gabriellucena98.mscreditappraiser.domain

import java.math.BigDecimal

data class CardIssuanceRequestData(
    val cardId: Long,
    val cpf: String,
    val address: String,
    val clientLimit: BigDecimal
)
