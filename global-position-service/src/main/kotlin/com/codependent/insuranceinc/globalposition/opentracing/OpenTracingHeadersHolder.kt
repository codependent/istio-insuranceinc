package com.codependent.insuranceinc.globalposition.opentracing

class OpenTracingHeadersHolder {

    val requestOpenTracingHeaders = ThreadLocal<MutableMap<String, String>?>()

}
