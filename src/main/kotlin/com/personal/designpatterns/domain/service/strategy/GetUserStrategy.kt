package com.personal.designpatterns.domain.service.strategy

import com.personal.designpatterns.domain.model.User
import org.springframework.stereotype.Component

@Component
interface GetUserStrategy {
     fun getUser(user : User): GetUserResponse?
     fun getUserType(): String
}