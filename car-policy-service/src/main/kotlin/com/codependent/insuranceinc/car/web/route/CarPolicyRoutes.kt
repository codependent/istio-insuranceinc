package com.codependent.insuranceinc.car.web.route

import com.codependent.insuranceinc.car.web.handler.CarPolicyHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class CarPolicyRoutes(private val carPolicyHandler: CarPolicyHandler) {

    @Bean
    fun carPolicyRouter() = router {
        "/policies".nest {
            GET("/{userId}", carPolicyHandler::getPolicies)
        }
    }

}
