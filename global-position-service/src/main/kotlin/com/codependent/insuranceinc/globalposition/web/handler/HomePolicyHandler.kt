package com.codependent.insuranceinc.globalposition.web.handler

import com.codependent.insuranceinc.globalposition.dto.GlobalPosition
import com.codependent.insuranceinc.globalposition.service.GlobalPositionService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class GlobalPositionHandler(private val globalPositionService: GlobalPositionService) {

    fun getGlobalPosition(serverRequest: ServerRequest) =
            ok().body(globalPositionService.getGlobalPosition(serverRequest.pathVariable("userId")), GlobalPosition::class.java)
}
