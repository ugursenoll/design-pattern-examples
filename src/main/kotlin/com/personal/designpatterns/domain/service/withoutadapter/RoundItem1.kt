package com.personal.designpatterns.domain.service.withoutadapter

class RoundItem1 : Round {
    override fun getRadius(): Double {
        return 3 * 10.0
    }
}