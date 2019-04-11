package com.codependent.insuranceinc.customerrating.opentracing.client

import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFunction
import reactor.core.CoreSubscriber
import reactor.core.publisher.Mono

class OpenTracingClientResponseMono(private val request: ClientRequest,
                                    private val next: ExchangeFunction,
                                    private val headersToPropagate: Set<String>) : Mono<ClientResponse>() {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun subscribe(subscriber: CoreSubscriber<in ClientResponse>) {
        val context = subscriber.currentContext()

        val requestBuilder = ClientRequest.from(request)
        requestBuilder.headers { httpHeaders ->
            headersToPropagate.forEach {
                if(context.hasKey(it)) {
                    logger.debug("Propagating header key {} - value{}", it, context.get<String>(it))
                    httpHeaders[it] = context.get<String>(it)
                }
            }
        }
        val mutatedRequest = requestBuilder.build()
        next.exchange(mutatedRequest).subscribe(subscriber)
    }


}
