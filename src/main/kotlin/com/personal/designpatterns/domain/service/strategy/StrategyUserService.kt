package com.personal.designpatterns.domain.service.strategy

import com.personal.designpatterns.domain.model.User
import com.personal.designpatterns.infrastructure.external.anotherservice.AnotherServiceClient
import com.personal.designpatterns.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class StrategyUserService(
    private val userRepository: UserRepository,
    private val type1UserStrategy: Type1UserStrategy,
    private val type2UserStrategy: Type2UserStrategy,
    private val type3UserStrategy: Type3UserStrategy,
    private val type4UserStrategy: Type4UserStrategy,

    ) {

    fun getUser(user: User): GetUserResponse? {
        val user = userRepository.findUser(user.userType)

        val userStrategies = mapOf(
            type1UserStrategy.getUserType() to type1UserStrategy,
            type2UserStrategy.getUserType() to type2UserStrategy,
            type3UserStrategy.getUserType() to type3UserStrategy,
            type4UserStrategy.getUserType() to type4UserStrategy
        )

        return userStrategies[user.userType]!!.getUser(user)
    }
}

data class GetUserResponse(
    val success: String,
    val userType: String
)

