package com.personal.designpatterns.domain.service.adapter

import com.personal.designpatterns.domain.service.withoutadapter.Round
import com.personal.designpatterns.domain.service.withoutadapter.RoundItem1
import com.personal.designpatterns.domain.service.withoutadapter.RoundItem2

class HoleFitService (private val roundItem1: RoundItem1, private val roundItem2: RoundItem2, private val squarePegAdapter: SquarePegAdapter) {

    fun itemFitWithRadius() {
        if(fitHole(roundItem1))
            println("round item 1 fitted")

        if(fitHole(roundItem2))
            println("round item 2 fitted")

        if(fitHole(squarePegAdapter))
            println("square item fitted")
    }

    private fun fitHole(round: Round) : Boolean {
        val hole = 10.0

        return hole >= round.getRadius()
    }
}