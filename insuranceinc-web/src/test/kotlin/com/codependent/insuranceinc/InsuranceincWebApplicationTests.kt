package com.codependent.insuranceinc

import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.core.ParameterizedTypeReference
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange


@RunWith(SpringRunner::class)
@SpringBootTest
class InsuranceincWebApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    @Ignore
    fun moretests() {
        val restTemplate = Mockito.mock(RestTemplate::class.java)

        val httpRequestEntity = HttpEntity("someString")

        val mockResponse = ResponseEntity(listOf("1", ""), HttpStatus.ACCEPTED)
        Mockito.`when`(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.any(), ArgumentMatchers.any<ParameterizedTypeReference<List<String>>>())).thenReturn(mockResponse)
        val exchange = restTemplate.exchange<List<String>>("/someUrl/{someVal}", HttpMethod.GET, httpRequestEntity, "1")
        println(exchange)
    }

}
