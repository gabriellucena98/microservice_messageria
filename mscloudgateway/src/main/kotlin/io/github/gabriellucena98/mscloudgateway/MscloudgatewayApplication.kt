package io.github.gabriellucena98.mscloudgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean


@SpringBootApplication
@EnableDiscoveryClient
class MscloudgatewayApplication

fun main(args: Array<String>) {
	runApplication<MscloudgatewayApplication>(*args)
	"TODO -> Colocar um rate limit para evitar DDOS"
	"TODO -> Id de transação para ser repassado para os outros serviços"
	"Olhar depois o spring cloud sleuth"
	"Depois de tudo olhar o Actuator"
	@Bean
	fun routes(builder: RouteLocatorBuilder): RouteLocator {
		return builder
			.routes()
				.route("msclient") {
					it.path("/clients/**")
						.uri("lb://msclient")
				}
				.route("mscard") {
					it.path("/cards/**")
						.uri("lb://mscard")
				}
				.route("mscreditappraiser") {
					it.path("/credit-appraiser/**")
						.uri("lb://mscreditappraiser")
				}
			.build()
	}
}
