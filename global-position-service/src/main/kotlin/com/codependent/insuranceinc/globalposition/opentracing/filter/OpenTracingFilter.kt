package com.codependent.insuranceinc.globalposition.opentracing.filter

import com.codependent.insuranceinc.globalposition.opentracing.OpenTracingHeadersHolder
import org.slf4j.LoggerFactory
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class OpenTracingFilter(private val openTracingHeadersHolder: OpenTracingHeadersHolder) : WebFilter {

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

        exchange.request.headers.forEach {
            if (openTracingHeaders.contains(it.key.toLowerCase())) {
                logger.debug("Found OpenTracing Header - key {} - value {}", it.key, it.value)
                if(openTracingHeadersHolder.requestOpenTracingHeaders.get() == null) {
                    openTracingHeadersHolder.requestOpenTracingHeaders.set(mutableMapOf("a" to "a"))
                }
                openTracingHeadersHolder.requestOpenTracingHeaders.get()!![it.key] = it.value[0]
            }
        }
        val mono = chain.filter(exchange)
        logger.debug("Clearing requestOpenTracingHeaders")
        openTracingHeadersHolder.requestOpenTracingHeaders.get()?.clear()
        return mono
    }
}
