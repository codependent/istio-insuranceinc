package com.codependent.insuranceinc.service

import com.codependent.insuranceinc.configuration.InsuranceincConfigurationProperties
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.core.publisher.onErrorReturn

@Service
class GlobalPositionServiceImpl(private val config: InsuranceincConfigurationProperties,
                                private val webClient: WebClient) : GlobalPositionService {

    private val logger = LoggerFactory.getLogger(javaClass)


    override fun getGlobalPosition(userId: String): Mono<Map<*, *>> {
        logger.debug("getGlobalPosition({})", userId)
        return webClient.get().uri("${config.globalPositionUrl}/globalPosition/${userId}")
                .retrieve().bodyToMono(Map::class.java)
                .log()
                .onErrorReturn(emptyMap<Any,Any>())

    }
}
