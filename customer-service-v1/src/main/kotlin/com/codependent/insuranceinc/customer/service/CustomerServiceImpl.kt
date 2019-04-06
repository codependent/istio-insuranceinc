package com.codependent.insuranceinc.customer.service

import com.codependent.insuranceinc.customer.dto.CustomerProfile
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Service
class CustomerServiceImpl : CustomerService {

    private val customers = listOf(
            CustomerProfile("1", "Joe Smith"),
            CustomerProfile("2", "John Doe"),
            CustomerProfile("3", "Ann Mary")

            ).toFlux()

    override fun getProfile(userId: String): Mono<CustomerProfile> = customers.filter { it.id == userId }.toMono()

}
