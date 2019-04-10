package com.codependent.insuranceinc.opentracing

class OpenTracingHeadersHolder {

    val requestOpenTracingHeaders = ThreadLocal<MutableMap<String, String>?>()

}
