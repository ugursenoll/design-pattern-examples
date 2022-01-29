package com.personal.designpatterns.domain.service.factory

import com.personal.designpatterns.domain.model.CheesePizza
import com.personal.designpatterns.domain.model.GreekPizza
import com.personal.designpatterns.domain.model.PepperoniPizza
import com.personal.designpatterns.domain.model.Pizza

class AnkaraPizzaStoreFactory {

    fun createPizza(type: String): Pizza {
        var pizza: Pizza? = null
        if (type == "greek") {
            pizza = GreekPizza()
        } else if (type == "pepperoni") {
            pizza = PepperoniPizza()
        }

        return pizza!!
    }
}