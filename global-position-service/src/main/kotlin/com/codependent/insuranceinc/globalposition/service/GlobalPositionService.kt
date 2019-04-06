package com.codependent.insuranceinc.globalposition.service

import com.codependent.insuranceinc.globalposition.dto.GlobalPosition
import reactor.core.publisher.Mono

interface GlobalPositionService {

    fun getGlobalPosition(userId: String) : Mono<GlobalPosition>
}
