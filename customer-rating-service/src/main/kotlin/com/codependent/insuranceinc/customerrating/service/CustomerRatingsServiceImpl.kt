package com.codependent.insuranceinc.customerrating.service

import com.codependent.insuranceinc.customerrating.dto.CustomerRating
import com.codependent.insuranceinc.customerrating.dto.Rating
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.time.Duration

@Service
class CustomerRatingsServiceImpl : CustomerRatingsService {

    private val forceFail: Boolean = Math.random() < 0.5
    private val logger = LoggerFactory.getLogger(javaClass)

    init {
        logger.info("Force Fail Value $forceFail")
    }

    private val customerRatings = mapOf(
            "1" to CustomerRating(Rating.PLATINUM),
            "2" to CustomerRating(Rating.SILVER),
            "3" to CustomerRating(Rating.TIN)
    )

    override fun getRating(userId: String) : Mono<CustomerRating> {
        return if(!forceFail) {
            val customerRating = customerRatings[userId]
            if (customerRating == null) {
                Mono.empty()
            } else {
                Mono.just(customerRating).delayElement(Duration.ofSeconds(3L))
            }
        } else {
            RuntimeException("Forced Failure").toMono()
        }
    }

}

