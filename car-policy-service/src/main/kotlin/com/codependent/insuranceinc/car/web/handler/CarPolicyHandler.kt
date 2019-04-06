package com.codependent.insuranceinc.car.web.handler

import com.codependent.insuranceinc.car.dto.CarPolicy
import com.codependent.insuranceinc.car.service.CarPolicyService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class CarPolicyHandler(private val carPolicyService: CarPolicyService) {

    fun getPolicies(serverRequest: ServerRequest) =
            ok().body(carPolicyService.getPolicies(serverRequest.pathVariable("userId")), CarPolicy::class.java)
}
