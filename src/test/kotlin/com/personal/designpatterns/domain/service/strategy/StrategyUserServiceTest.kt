package com.personal.designpatterns.domain.service.strategy

import com.personal.designpatterns.domain.model.User
import com.personal.designpatterns.infrastructure.external.anotherservice.AnotherServiceClient
import com.personal.designpatterns.infrastructure.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class StrategyUserServiceTest {

    @InjectMockKs
    private lateinit var strategyUserService: StrategyUserService

    @MockK
    private lateinit var type1UserStrategy: Type1UserStrategy

    @MockK
    private lateinit var type2UserStrategy: Type2UserStrategy

    @MockK
    private lateinit var type3UserStrategy: Type3UserStrategy

    @MockK
    private lateinit var type4UserStrategy: Type4UserStrategy
    @MockK
    private lateinit var userRepository: UserRepository

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `should return user`() {

        val user = User(
            id = 1,
            userType = "type-2",
            name = "name",
            surname = "surname"
        )

        every {
            userRepository.findUser(user.userType)
        } returns user

        val getUserResponse = GetUserResponse(
            success = "true",
            userType = "type-2"
        )

        every {
            type1UserStrategy.getUserType()
        } returns "type-1"

        every {
            type2UserStrategy.getUserType()
        } returns "type-2"

        every {
            type3UserStrategy.getUserType()
        } returns "type-3"

        every {
            type4UserStrategy.getUserType()
        } returns "type-4"


        every {
            type2UserStrategy.getUser(user)
        } returns getUserResponse


        val response = strategyUserService.getUser(user)

        assertEquals("type-2", response!!.userType)
    }

}