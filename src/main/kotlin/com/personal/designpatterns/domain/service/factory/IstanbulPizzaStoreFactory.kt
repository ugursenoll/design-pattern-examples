package com.personal.designpatterns.domain.service.factory

import com.personal.designpatterns.domain.model.CheesePizza
import com.personal.designpatterns.domain.model.PepperoniPizza
import com.personal.designpatterns.domain.model.Pizza

class IstanbulPizzaStoreFactory {

    fun createPizza(type: String): Pizza {
        var pizza: Pizza? = null
        if (type == "cheese") {
            pizza = CheesePizza()
        } else if (type == "pepperoni") {
            pizza = PepperoniPizza()
        }

        return pizza!!
    }
}