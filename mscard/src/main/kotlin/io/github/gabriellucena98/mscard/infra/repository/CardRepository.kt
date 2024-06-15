package io.github.gabriellucena98.mscard.infra.repository

import io.github.gabriellucena98.mscard.domain.Card
import java.math.BigDecimal
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<Card, Long> {

    fun findByIncomeLessThanEqual(newIncome: Long): List<Card>
}