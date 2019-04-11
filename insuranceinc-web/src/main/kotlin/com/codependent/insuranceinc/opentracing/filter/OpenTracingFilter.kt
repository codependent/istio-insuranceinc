package com.codependent.insuranceinc.opentracing.filter

import org.slf4j.LoggerFactory
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class OpenTracingFilter(private val openTracingHeaders: Set<String>) : WebFilter {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {

        return chain.filter(exchange)
                .subscriberContext { ctx ->
                    var updatedContext = ctx
                    exchange.request.headers.forEach {
                        if (openTracingHeaders.contains(it.key.toLowerCase())) {
                            logger.debug("Found OpenTracing Header - key {} - value {}", it.key, it.value[0])
                            updatedContext = updatedContext.put(it.key, it.value[0])
                        }
                    }
                    updatedContext
                }
    }
}
