package com.codependent.insuranceinc.customerrating.service

import com.codependent.insuranceinc.customerrating.dto.CustomerRating
import com.codependent.insuranceinc.customerrating.dto.Rating
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Service
class CustomerRatingsServiceImpl : CustomerRatingsService {

    private val customerRatings = mapOf(
            "1" to CustomerRating(Rating.PLATINUM),
            "2" to CustomerRating(Rating.SILVER),
            "3" to CustomerRating(Rating.TIN)
    )

    override fun getRating(userId: String) : Mono<CustomerRating> {
        val customerRating = customerRatings[userId]
        return if(customerRating == null) {
            Mono.empty()
        }else {
            Mono.just(customerRating)
        }
    }

}

