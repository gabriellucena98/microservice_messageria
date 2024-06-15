package io.github.gabriellucena98.mscreditappraiser

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableRabbit
class MscreditappraiserApplication

fun main(args: Array<String>) {
	runApplication<MscreditappraiserApplication>(*args)
}
