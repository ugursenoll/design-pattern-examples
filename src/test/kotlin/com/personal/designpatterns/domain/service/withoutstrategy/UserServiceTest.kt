package com.personal.designpatterns.domain.service.withoutstrategy

import com.personal.designpatterns.domain.model.User
import com.personal.designpatterns.domain.service.withoutstrategy.UserService
import com.personal.designpatterns.infrastructure.external.anotherservice.AnotherServiceClient
import com.personal.designpatterns.infrastructure.repository.UserRepository
import io.mockk.MockKAnnotations
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach

internal class UserServiceTest {

    @InjectMockKs
    private lateinit var userService: UserService

    @MockK
    private lateinit var anotherServiceClient: AnotherServiceClient

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

        every {
            anotherServiceClient.anotherServiceEndpoint()
        } returns "success"



        val response = userService.getUser(user)

        assertEquals("type-2", response!!.userType)
    }

}