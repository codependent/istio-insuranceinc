package com.codependent.insuranceinc.home.service

import com.codependent.insuranceinc.home.dto.HomePolicy
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux

@Service
class HomePolicyServiceImpl : HomePolicyService {

    private val homePolicies = listOf(
            HomePolicy(1, "1", "Cuenca Street", 100.0F),
            HomePolicy(2, "1", "Huelva Street", 150.0F),
            HomePolicy(3, "1", "Madrid Street", 170.0F),
            HomePolicy(4, "2", "Lugo Street", 200.0F),
            HomePolicy(5, "2", "Sevilla Street", 300.0F),
            HomePolicy(6, "2", "Zaragoza Street", 400.0F),
            HomePolicy(7, "2", "Bilbao Street", 500.0F)
    ).toFlux()

    override fun getPolicies(userId: String): Flux<HomePolicy> = homePolicies.filter { it.userId == userId }

}
