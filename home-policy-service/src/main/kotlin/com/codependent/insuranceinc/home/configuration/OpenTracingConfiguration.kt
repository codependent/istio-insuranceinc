package com.codependent.insuranceinc.home.configuration

import com.codependent.insuranceinc.home.opentracing.client.OpenTracingExchangeFilterFunction
import com.codependent.insuranceinc.home.opentracing.filter.OpenTracingFilter
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
    fun openTracingFilter(): WebFilter {
        return OpenTracingFilter()
    }

    @Bean
    fun openTracingExchangeFilterFunction(): OpenTracingExchangeFilterFunction {
        return OpenTracingExchangeFilterFunction()
    }
}
