package io.github.gabriellucena98.mscard

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
class MscardApplication

fun main(args: Array<String>) {
	runApplication<MscardApplication>(*args)
}
