package com.personal.designpatterns.infrastructure.external.anotherservice

import org.springframework.stereotype.Component

@Component
class AnotherServiceClient {

    fun anotherServiceEndpoint() : String {
        return "success";
    }

    fun anotherServiceEndpoint2() : String? {
        return null;
    }

    fun anotherServiceEndpoint3() : String {
        return "false";
    }
}