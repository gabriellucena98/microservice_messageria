package io.github.gabriellucena98.mscard.application.response

import java.math.BigDecimal

data class ClientCardResponse(
    val name: String,
    val cardFlag: String,
    val clientLimit: BigDecimal
)
