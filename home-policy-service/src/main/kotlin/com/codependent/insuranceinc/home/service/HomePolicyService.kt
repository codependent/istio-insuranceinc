package com.codependent.insuranceinc.home.service

import com.codependent.insuranceinc.home.dto.HomePolicy
import reactor.core.publisher.Flux

interface HomePolicyService {

    fun getPolicies(userId: String) : Flux<HomePolicy>
}
