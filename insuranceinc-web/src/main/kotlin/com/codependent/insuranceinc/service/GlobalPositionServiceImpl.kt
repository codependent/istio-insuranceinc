package com.codependent.insuranceinc.service

import com.codependent.insuranceinc.configuration.InsuranceincConfigurationProperties
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.core.publisher.onErrorReturn

@Service
class GlobalPositionServiceImpl(private val config: InsuranceincConfigurationProperties) : GlobalPositionService {

    private val webClient = WebClient.builder().build()

    override fun getGlobalPosition(userId: String): Mono<Map<*, *>> {

        return webClient.get().uri("${config.globalPositionUrl}/globalPosition/${userId}")
                .retrieve().bodyToMono(Map::class.java)
                .log()
                .onErrorReturn(emptyMap<Any,Any>())

    }
}
