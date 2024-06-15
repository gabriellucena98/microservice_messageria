package io.github.gabriellucena98.mscard.domain

import io.github.gabriellucena98.mscard.application.response.ClientCardResponse
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal

@Entity
data class ClientCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val cpf: String,
    @ManyToOne
    @JoinColumn(name = "card_id")
    val card: Card,
    val clientLimit: BigDecimal,
){
    fun toDTO(): ClientCardResponse {
        return ClientCardResponse(
            name = card.name,
            cardFlag = card.cardFlag.name,
            clientLimit = clientLimit
        )
    }
}
