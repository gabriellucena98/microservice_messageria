package io.github.gabriellucena98.msclient.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
    @Column(nullable = false)
    val cpf: String = "",
    @Column(nullable = false)
    val name: String = "",
    @Column(nullable = false)
    val age: Long = -1,
)