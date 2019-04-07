package com.codependent.insuranceinc.customerrating.service

import com.codependent.insuranceinc.customerrating.dto.CustomerRating
import reactor.core.publisher.Mono

interface CustomerRatingsService {

    fun getRating(userId: String) : Mono<CustomerRating>
}
