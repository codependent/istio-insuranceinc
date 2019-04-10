package com.codependent.insuranceinc.globalposition.opentracing.client

import com.codependent.insuranceinc.globalposition.opentracing.OpenTracingHeadersHolder
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.ExchangeFunction
import reactor.core.publisher.Mono

class OpenTracingExchangeFilterFunction(private val openTracingHeadersHolder: OpenTracingHeadersHolder) : ExchangeFilterFunction{

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun filter(request: ClientRequest, next: ExchangeFunction): Mono<ClientResponse> {
        logger.debug("OpenTracingExchangeFilterFunction - filter()")
        val filtered = ClientRequest.from(request).headers { httpHeaders ->
            openTracingHeadersHolder.requestOpenTracingHeaders.get()?.forEach {
                logger.debug("OpenTracingExchangeFilterFunction adding header key {} - value {}", it.key, it.value)
                httpHeaders[it.key] = it.value
            }
        }.build()
        return next.exchange(filtered)
    }
}
