package com.codependent.insuranceinc.globalposition.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("")
class GlobalPositionConfigurationProperties {

    lateinit var carUrl: String
    lateinit var homeUrl: String
    lateinit var customerUrl: String
}
