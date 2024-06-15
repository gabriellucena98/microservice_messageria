package io.github.gabriellucena98.mscard.domain

import java.math.BigDecimal

data class CardIssuanceRequestData(
    val cardId: Long = -1,
    val cpf: String = "",
    val address: String = "",
    val clientLimit: BigDecimal = BigDecimal.valueOf(0)
)
