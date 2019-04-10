package com.codependent.insuranceinc.globalposition.configuration

import com.codependent.insuranceinc.globalposition.opentracing.OpenTracingHeadersHolder
import com.codependent.insuranceinc.globalposition.opentracing.client.OpenTracingExchangeFilterFunction
import com.codependent.insuranceinc.globalposition.opentracing.filter.OpenTracingFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.WebFilter

@Configuration
class OpenTracingConfiguration {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder().filter(openTracingExchangeFilterFunction()).build()
    }

    @Bean
    fun openTracingHeadersHolder(): OpenTracingHeadersHolder {
        return OpenTracingHeadersHolder()
    }

    @Bean
    fun openTracingFilter(): WebFilter {
        return OpenTracingFilter(openTracingHeadersHolder())
    }

    @Bean
    fun openTracingExchangeFilterFunction(): OpenTracingExchangeFilterFunction {
        return OpenTracingExchangeFilterFunction(openTracingHeadersHolder())
    }
}