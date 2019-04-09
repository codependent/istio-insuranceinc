package com.codependent.insuranceinc.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Controller
class LoginController {

    @GetMapping("/login")
    fun login() {
    }

    @PostMapping("/login")
    fun doLogin(swe: ServerWebExchange): Mono<String> {
        return swe.formData.flatMap {
            swe.session.map { it.attributes["userId"] = it.attributes["userId"] }
            "globalPosition".toMono()
        }
    }

}
