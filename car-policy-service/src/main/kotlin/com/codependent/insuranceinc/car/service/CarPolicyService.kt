package com.codependent.insuranceinc.car.service

import com.codependent.insuranceinc.car.dto.CarPolicy
import reactor.core.publisher.Flux

interface CarPolicyService {

    fun getPolicies(userId: String) : Flux<CarPolicy>
}
