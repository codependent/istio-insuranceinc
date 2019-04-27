package com.codependent.insuranceinc.customerrating.web.handler

import com.codependent.insuranceinc.customerrating.dto.CustomerRating
import com.codependent.insuranceinc.customerrating.service.CustomerRatingsService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.server.ResponseStatusException

@Component
class CustomerRatingHandler(private val customerRatingsService: CustomerRatingsService) {

    fun getPolicies(serverRequest: ServerRequest) =
            ok().body(customerRatingsService.getRating(serverRequest.pathVariable("userId"))
                    .onErrorMap { ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE) } , CustomerRating::class.java)

}
