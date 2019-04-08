package com.codependent.insuranceinc.customer.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("")
class CustomerProfileConfigurationProperties {

    lateinit var customerRatingUrl: String
}
