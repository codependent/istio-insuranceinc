package com.codependent.insuranceinc.home.web.handler

import com.codependent.insuranceinc.home.dto.HomePolicy
import com.codependent.insuranceinc.home.service.HomePolicyService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class HomePolicyHandler(private val homePolicyService: HomePolicyService) {

    fun getPolicies(serverRequest: ServerRequest) =
            ok().body(homePolicyService.getPolicies(serverRequest.pathVariable("userId")), HomePolicy::class.java)
}
