package com.codependent.insuranceinc.web

import com.codependent.insuranceinc.service.GlobalPositionService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.WebSession

@Controller
class GlobalPositionController(private val globalPositionService: GlobalPositionService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/globalPosition")
    fun globalPosition(webSession: WebSession, model: Model) {
        logger.debug("getGlobalPosition")
        val globalPosition = globalPositionService.getGlobalPosition(webSession.attributes["userId"] as String)
        model.addAttribute("globalPosition", globalPosition)
    }

}
