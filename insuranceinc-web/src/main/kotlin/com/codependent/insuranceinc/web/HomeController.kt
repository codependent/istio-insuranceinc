package com.codependent.insuranceinc.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Controller
class HomeController {

    @GetMapping("/")
    fun home(swe: ServerWebExchange): Mono<String> {
        return swe.session.map {
            if (it.attributes["userId"] as String? != null) {
                "redirect:/globalPosition"
            } else {
                "redirect:/login"
            }
        }
    }

}
