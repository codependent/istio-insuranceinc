package com.codependent.insuranceinc.customerrating.web.route

import com.codependent.insuranceinc.customerrating.web.handler.CustomerRatingHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class CustomerRatingRoutes(private val customerRatingHandler: CustomerRatingHandler) {

    @Bean
    fun customerRatingRouter() = router {
        "/customerRatings".nest {
            GET("/{userId}", customerRatingHandler::getPolicies)
        }
    }

}
