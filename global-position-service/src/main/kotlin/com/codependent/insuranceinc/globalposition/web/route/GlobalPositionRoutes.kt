package com.codependent.insuranceinc.globalposition.web.route

import com.codependent.insuranceinc.globalposition.web.handler.GlobalPositionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class GlobalPositionRoutes(private val globalPositionHandler: GlobalPositionHandler) {

    @Bean
    fun homePolicyRouter() = router {
        "/globalPosition".nest {
            GET("/{userId}", globalPositionHandler::getGlobalPosition)
        }
    }

}
