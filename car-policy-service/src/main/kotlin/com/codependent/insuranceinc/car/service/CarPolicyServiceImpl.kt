package com.codependent.insuranceinc.car.service

import com.codependent.insuranceinc.car.dto.CarPolicy
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux

@Service
class CarPolicyServiceImpl : CarPolicyService {

    private val carPolicies = listOf(
            CarPolicy(1, "1", "1234QWE", 300.0F),
            CarPolicy(2, "1", "5555GGR", 400.0F),
            CarPolicy(3, "1", "1266YYH", 500.0F),
            CarPolicy(4, "2", "9999EFE", 600.0F),
            CarPolicy(5, "2", "5433UYH", 700.0F),
            CarPolicy(6, "2", "5551BNB", 800.0F),
            CarPolicy(7, "2", "9787AAA", 900.0F)
    ).toFlux()

    override fun getPolicies(userId: String): Flux<CarPolicy> = carPolicies.filter { it.userId == userId }

}
