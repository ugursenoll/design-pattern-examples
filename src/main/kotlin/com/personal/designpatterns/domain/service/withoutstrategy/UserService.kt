package com.personal.designpatterns.domain.service.withoutstrategy

import com.personal.designpatterns.domain.model.User
import com.personal.designpatterns.infrastructure.external.anotherservice.AnotherServiceClient
import com.personal.designpatterns.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val anotherServiceClient: AnotherServiceClient) {

    fun getUser(user: User): GetUserResponse? {
        val user = userRepository.findUser(user.userType)

        if (user.userType == "type-1") {
            val serviceResponse = anotherServiceClient.anotherServiceEndpoint()
            if (serviceResponse.isNullOrEmpty()) {
                throw RuntimeException()
            }
            return null
        }

        if (user.userType == "type-2") {
            val serviceResponse = anotherServiceClient.anotherServiceEndpoint()
            if (serviceResponse.isNullOrEmpty()) {
                throw RuntimeException()
            } else {
                return GetUserResponse(
                    success = serviceResponse,
                    userType = user.userType
                )
            }
        }

        if (user.userType == "type-3") {
            val serviceResponse = anotherServiceClient.anotherServiceEndpoint()
            if (serviceResponse.isNullOrEmpty()) {
                throw RuntimeException()
            }
            return GetUserResponse(
                success = "not success",
                userType = user.userType
            )
        }

        if (user.userType == "type-4") {
            return null
        }


        return null
    }
}

data class GetUserResponse(
    val success: String,
    val userType: String
)

