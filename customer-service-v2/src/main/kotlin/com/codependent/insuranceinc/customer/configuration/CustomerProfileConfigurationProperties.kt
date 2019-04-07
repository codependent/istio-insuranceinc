package com.codependent.insuranceinc.globalposition.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("")
class CustomerProfileConfigurationProperties {

    lateinit var customerRatingUrl: String
}
