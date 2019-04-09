package com.codependent.insuranceinc.web

import com.codependent.insuranceinc.service.GlobalPositionService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.WebSession

@Controller
class GlobalPositionController(private val globalPositionService: GlobalPositionService) {

    @GetMapping("/globalPosition")
    fun globalPosition(webSession: WebSession, model: Model) {
        val globalPosition = globalPositionService.getGlobalPosition(webSession.attributes["userId"] as String)
                .log()
        model.addAttribute("globalPosition", globalPosition)
    }

}
