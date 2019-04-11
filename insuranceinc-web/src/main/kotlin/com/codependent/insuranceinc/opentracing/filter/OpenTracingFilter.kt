package com.codependent.insuranceinc.opentracing.filter

import org.slf4j.LoggerFactory
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class OpenTracingFilter : WebFilter {

    private val openTracingHeaders = setOf(
            "x-request-id",
            "x-b3-traceid",
            "x-b3-spanid",
            "x-b3-parentspanid",
            "x-b3-sampled",
            "x-b3-flags",
            "x-ot-span-context")

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
