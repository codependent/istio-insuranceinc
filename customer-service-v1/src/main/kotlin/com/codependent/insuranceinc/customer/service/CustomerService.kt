package com.codependent.insuranceinc.customer.service

import com.codependent.insuranceinc.customer.dto.CustomerProfile
import reactor.core.publisher.Mono

interface CustomerService {

    fun getProfile(userId: String): Mono<CustomerProfile>
}
