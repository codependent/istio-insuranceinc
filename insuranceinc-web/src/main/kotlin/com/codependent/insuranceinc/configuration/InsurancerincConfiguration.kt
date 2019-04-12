package com.codependent.insuranceinc.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.server.adapter.ForwardedHeaderTransformer

@Configuration
class InsurancerincConfiguration {

    @Bean
    fun forwardedHeaderTransformer() : ForwardedHeaderTransformer {
        return ForwardedHeaderTransformer()
    }

}
