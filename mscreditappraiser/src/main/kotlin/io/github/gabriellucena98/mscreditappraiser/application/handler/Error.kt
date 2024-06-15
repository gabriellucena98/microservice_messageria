package io.github.gabriellucena98.mscreditappraiser.application.handler

data class Error(
    val message: String,
    val http: Int,
    val code: String
)