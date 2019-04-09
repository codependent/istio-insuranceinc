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
class HomeController {

    @GetMapping("/")
    fun home(swe: ServerWebExchange): Mono<String> {
        return swe.session.map {
            if(it.attributes["userId"] as String? != null) {
                "redirect:/globalPosition"
            } else {
                "redirect:/login"
            }
        }
    }

    @PostMapping("/login")
    fun doLogin(@ModelAttribute credentials: Credentials, swe: ServerWebExchange): Mono<String> {
        return swe.session.map {
            it.attributes["userId"] = credentials.userId
            "redirect:/globalPosition"
        }
    }

}
