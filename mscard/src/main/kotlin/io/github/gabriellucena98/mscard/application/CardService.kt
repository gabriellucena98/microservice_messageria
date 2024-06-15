package io.github.gabriellucena98.mscard.application

import io.github.gabriellucena98.mscard.domain.Card
import io.github.gabriellucena98.mscard.infra.repository.CardRepository
import jakarta.transaction.Transactional
import java.math.BigDecimal
import org.springframework.stereotype.Service

@Service
class CardService(
    private val cardRepository: CardRepository
) {

    @Transactional
    fun save(card: Card): Card {
        return cardRepository.save(card)
    }

    fun getCardsLessThanOrEqualTo(income: Long): List<Card> {
        return cardRepository.findByIncomeLessThanEqual(income)
    }
}