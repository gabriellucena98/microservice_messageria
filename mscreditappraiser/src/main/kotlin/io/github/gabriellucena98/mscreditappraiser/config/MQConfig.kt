package io.github.gabriellucena98.mscreditappraiser.config

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class MQConfig(
    @Value("\${mq.queues.card-issuance}")
    private val cardIssuance: String
) {

    fun queueCardIssuance(): Queue {
        return Queue(cardIssuance, true)
    }
}