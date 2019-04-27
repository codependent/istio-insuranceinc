package com.codependent.insuranceinc.globalposition.service

import com.codependent.insuranceinc.globalposition.configuration.GlobalPositionConfigurationProperties
import com.codependent.insuranceinc.globalposition.dto.CarPolicy
import com.codependent.insuranceinc.globalposition.dto.CustomerProfile
import com.codependent.insuranceinc.globalposition.dto.GlobalPosition
import com.codependent.insuranceinc.globalposition.dto.HomePolicy
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class GlobalPositionServiceImpl(private val config: GlobalPositionConfigurationProperties, private val webClient: WebClient) : GlobalPositionService {

    override fun getGlobalPosition(userId: String): Mono<GlobalPosition> {

        val customerMono: Mono<CustomerProfile> = webClient.get().uri("${config.customerUrl}/profiles/$userId")
                .retrieve().bodyToMono(CustomerProfile::class.java)
                .onErrorReturn(CustomerProfile("-1", "", null))
        val carPoliciesMono: Mono<List<CarPolicy>> = webClient.get().uri("${config.carUrl}/policies/$userId")
                .retrieve().bodyToFlux(CarPolicy::class.java).collectList()
                .onErrorReturn(emptyList())
        val homePoliciesMono: Mono<List<HomePolicy>> = webClient.get().uri("${config.homeUrl}/policies/$userId")
                .retrieve().bodyToFlux(HomePolicy::class.java).collectList()
                .onErrorReturn(emptyList())

        return Mono.zip(customerMono, carPoliciesMono, homePoliciesMono).map { GlobalPosition(it.t1, it.t2, it.t3) }
    }
}
