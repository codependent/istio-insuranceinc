package com.codependent.insuranceinc.home.opentracing.client

import io.netty.handler.codec.HeadersUtils
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFunction
import reactor.core.CoreSubscriber
import reactor.core.publisher.Mono

class OpenTracingClientResponseMono(private val request: ClientRequest,
                                    private val next: ExchangeFunction) : Mono<ClientResponse>() {

    override fun subscribe(subscriber: CoreSubscriber<in ClientResponse>) {
        val context = subscriber.currentContext()

        val requestBuilder = ClientRequest.from(request)
        requestBuilder.headers { httpHeaders ->
            println(context.get<String>("Host"))
            httpHeaders["Host"] = context.get("Host")
        }
        val mutatedRequest = requestBuilder.build()
        next.exchange(mutatedRequest).subscribe(subscriber)
    }


}
