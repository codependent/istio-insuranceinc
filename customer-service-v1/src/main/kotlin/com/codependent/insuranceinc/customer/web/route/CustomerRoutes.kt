package com.codependent.insuranceinc.customer.web.route

import com.codependent.insuranceinc.customer.web.handler.CustomerHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class CustomerRoutes(private val customerHandler: CustomerHandler) {

    @Bean
    fun homePolicyRouter() = router {
        "/profiles".nest {
            GET("/{userId}", customerHandler::getPolicies)
        }
    }

}
