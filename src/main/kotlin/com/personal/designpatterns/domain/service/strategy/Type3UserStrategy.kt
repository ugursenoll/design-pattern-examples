package com.personal.designpatterns.domain.service.strategy

import com.personal.designpatterns.domain.model.User
import com.personal.designpatterns.infrastructure.external.anotherservice.AnotherServiceClient
import org.springframework.stereotype.Component

@Component
class Type3UserStrategy(private val anotherServiceClient: AnotherServiceClient) : GetUserStrategy {
    override fun getUser(user : User): GetUserResponse? {
        val serviceResponse = anotherServiceClient.anotherServiceEndpoint()
        if (serviceResponse.isNullOrEmpty()) {
            throw RuntimeException()
        }
        return GetUserResponse(
            success = "not success",
            userType = user.userType
        )
    }

    override fun getUserType(): String {
        return "type-3"
    }
}