package io.github.gabriellucena98.mscard.application.request

import io.github.gabriellucena98.mscard.domain.Card
import io.github.gabriellucena98.mscard.domain.CardFlag
import java.math.BigDecimal

data class CardSaveRequest(
    val name: String,
    val cardFlag: CardFlag,
    val income: Long,
    val limit: BigDecimal
) {
    fun toDomain(): Card {
        return Card(
            -1,
            name,
            cardFlag,
            income,
            limit
        )
    }
}
