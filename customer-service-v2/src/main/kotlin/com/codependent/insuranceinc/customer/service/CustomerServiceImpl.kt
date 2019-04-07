package com.codependent.insuranceinc.customer.service

import com.codependent.insuranceinc.customer.dto.CustomerProfile
import com.codependent.insuranceinc.customerrating.dto.CustomerRating
import com.codependent.insuranceinc.globalposition.configuration.CustomerProfileConfigurationProperties
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Service
class CustomerServiceImpl(private val config: CustomerProfileConfigurationProperties) : CustomerService {

    private val webClient = WebClient.builder().build()

    private val customers = listOf(
            CustomerProfile("1", "Joe Smith", null),
            CustomerProfile("2", "John Doe", null),
            CustomerProfile("3", "Ann Mary", null)
            ).toFlux()

    override fun getProfile(userId: String): Mono<CustomerProfile> {

        val customerRatingMono: Mono<CustomerRating> = webClient.get().uri("${config.customerRatingUrl}/customerRatings/${userId}")
                .retrieve().bodyToMono(CustomerRating::class.java)
        val customerProfileMono = customers.filter { it.id == userId }.toMono()

        return Mono.zip(customerProfileMono, customerRatingMono) { cp, cr -> CustomerProfile(cp.id, cp.name, cr.rating.name)}
    }
}
