package io.github.gabriellucena98.mscard.domain

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @Enumerated(EnumType.STRING) //salvando como String, se fosse Ordinal seria Mastercard = 0 e VISA = 1
    val cardFlag: CardFlag,
    val income: Long,
    val cardLimit: BigDecimal
)
