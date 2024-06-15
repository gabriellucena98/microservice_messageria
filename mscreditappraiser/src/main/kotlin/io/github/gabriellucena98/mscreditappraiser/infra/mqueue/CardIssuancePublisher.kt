package io.github.gabriellucena98.mscreditappraiser.infra.mqueue

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.gabriellucena98.mscreditappraiser.config.MQConfig
import io.github.gabriellucena98.mscreditappraiser.domain.CardIssuanceRequestData
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class CardIssuancePublisher(
    private val rabbitTemplate: RabbitTemplate,
    private val mqConfig: MQConfig
) {

    fun requestCard(data: CardIssuanceRequestData) {
        val json = convertIntoJson(data)
        rabbitTemplate.convertAndSend(mqConfig.queueCardIssuance().name, json)
    }

    private fun convertIntoJson(data: CardIssuanceRequestData): String {
        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(data)
        return json
    }

}