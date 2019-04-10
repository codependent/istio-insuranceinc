package com.codependent.insuranceinc.car.opentracing

class OpenTracingHeadersHolder {

    val requestOpenTracingHeaders = ThreadLocal<MutableMap<String, String>?>()

}
