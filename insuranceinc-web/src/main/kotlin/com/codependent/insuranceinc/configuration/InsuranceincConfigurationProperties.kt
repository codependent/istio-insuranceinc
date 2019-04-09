package com.codependent.insuranceinc.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("")
class InsuranceincConfigurationProperties {

    lateinit var globalPositionUrl: String

}
