package com.codependent.insuranceinc.globalposition.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("opentracing")
class OpenTracingConfigurationProperties {

    lateinit var headers: Set<String>

}
