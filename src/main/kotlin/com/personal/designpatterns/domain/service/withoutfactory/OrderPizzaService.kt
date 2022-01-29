package com.personal.designpatterns.domain.service.withoutfactory

import com.personal.designpatterns.domain.model.CheesePizza
import com.personal.designpatterns.domain.model.GreekPizza
import com.personal.designpatterns.domain.model.PepperoniPizza
import com.personal.designpatterns.domain.model.Pizza
import org.springframework.stereotype.Service

@Service
class OrderPizzaService() {
    suspend fun orderPizza(type: String): Pizza {

        var pizza: Pizza? = null
        if (type == "cheese") {
            pizza = CheesePizza()
        } else if (type == "greek") {
            pizza = GreekPizza()
        } else if (type == "pepperoni") {
            pizza = PepperoniPizza()
        }
        pizza!!.prepare()
        pizza!!.bake()
        pizza!!.cut()
        pizza!!.box()

        return pizza
    }
}