package io.github.gabriellucena98.mscreditappraiser.domain

import java.math.BigDecimal

data class ClientCard(
    val name: String,
    val cardFlag: String,
    val clientLimit: BigDecimal,
)
