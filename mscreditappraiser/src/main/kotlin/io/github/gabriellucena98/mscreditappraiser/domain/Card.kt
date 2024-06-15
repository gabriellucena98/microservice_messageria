package io.github.gabriellucena98.mscreditappraiser.domain

import java.math.BigDecimal

data class Card(
    val id: Long,
    val name: String,
    val cardFlag: String,
    val cardLimit: BigDecimal
)
