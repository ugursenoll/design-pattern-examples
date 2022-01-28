package com.personal.designpatterns.domain.service.strategy

import com.personal.designpatterns.domain.model.User
import com.personal.designpatterns.infrastructure.external.anotherservice.AnotherServiceClient
import org.springframework.stereotype.Component

@Component
class Type1UserStrategy(private val anotherServiceClient: AnotherServiceClient) : GetUserStrategy {
    override  fun getUser(user: User): GetUserResponse? {
        val serviceResponse = anotherServiceClient.anotherServiceEndpoint()
        if (serviceResponse.isNullOrEmpty()) {
            throw RuntimeException()
        }
        return null
    }

    override  fun getUserType(): String {
        return "type-1"
    }
}