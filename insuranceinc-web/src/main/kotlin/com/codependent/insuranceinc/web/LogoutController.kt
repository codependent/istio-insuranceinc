package com.codependent.insuranceinc.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Controller
class LogoutController {

    @GetMapping("/logout")
    fun logout(swe: ServerWebExchange): Mono<String> {
        return swe.session.map {
            it.invalidate()
            "redirect:/login"
        }
    }

}
