package com.codependent.insuranceinc.service

import reactor.core.publisher.Mono

interface GlobalPositionService {

    fun getGlobalPosition(userId: String): Mono<String>

}
