package com.codependent.insuranceinc.web

import com.codependent.insuranceinc.dto.Credentials
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
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
    fun doLogin(@ModelAttribute credentials: Credentials, swe: ServerWebExchange): Mono<String> {
        return swe.session.flatMap {
            it.attributes["userId"] = credentials.userId
            "redirect:/globalPosition".toMono()
        }
    }

}
