package com.personal.designpatterns.infrastructure.repository

import com.personal.designpatterns.domain.model.User
import org.springframework.stereotype.Component

@Component
interface UserRepository{
    fun findUser(userType : String) : User {
        return User(
            id = 1,
            userType = "type-1",
            name = "name-1",
            surname = "surname-1"
        )
    }
}