package com.codependent.insuranceinc.home.web.route

import com.codependent.insuranceinc.home.web.handler.HomePolicyHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class HomePolicyRoutes(private val homePolicyHandler: HomePolicyHandler) {

    @Bean
    fun homePolicyRouter() = router {
        "/policies".nest {
            GET("/{userId}", homePolicyHandler::getPolicies)
        }
    }

}
