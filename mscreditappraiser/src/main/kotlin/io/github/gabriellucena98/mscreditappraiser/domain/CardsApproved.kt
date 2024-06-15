package io.github.gabriellucena98.mscreditappraiser.domain

import java.math.BigDecimal

data class CardsApproved(
    val card: String,
    val cardFlag: String,
    val approvedLimit: BigDecimal
)
