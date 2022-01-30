package com.personal.designpatterns.domain.service.adapter

import com.personal.designpatterns.domain.service.withoutadapter.Round
import com.personal.designpatterns.domain.service.withoutadapter.SquareItem

class SquarePegAdapter( private val squarePeg: SquareItem) : Round {

    override fun getRadius(): Double {
        return squarePeg.getSquare()
    }
}