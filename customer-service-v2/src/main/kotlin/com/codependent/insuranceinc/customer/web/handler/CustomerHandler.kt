package com.codependent.insuranceinc.customer.web.handler

import com.codependent.insuranceinc.customer.dto.CustomerProfile
import com.codependent.insuranceinc.customer.service.CustomerService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class CustomerHandler(private val customerService: CustomerService) {

    fun getPolicies(serverRequest: ServerRequest) =
            ok().body(customerService.getProfile(serverRequest.pathVariable("userId")), CustomerProfile::class.java)
}
