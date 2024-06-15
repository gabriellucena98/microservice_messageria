package io.github.gabriellucena98.msclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class MsclientApplication

fun main(args: Array<String>) {
	runApplication<MsclientApplication>(*args)
}
