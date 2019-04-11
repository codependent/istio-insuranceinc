package com.codependent.insuranceinc.customerrating.opentracing.client

import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.ExchangeFunction
import reactor.core.publisher.Mono

class OpenTracingExchangeFilterFunction : ExchangeFilterFunction {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun filter(request: ClientRequest, next: ExchangeFunction): Mono<ClientResponse> {

        logger.debug("OpenTracingExchangeFilterFunction - filter()")
        return OpenTracingClientResponseMono(request, next)
    }
}
