package com.personal.designpatterns.domain.service.factory

import com.personal.designpatterns.domain.model.Pizza

class FactoryOrderPizzaService {

    fun orderPizza(type: String): Pizza {
        val istPizza = IstanbulPizzaStoreFactory()
        val ankPizza = AnkaraPizzaStoreFactory()

        var pizza = istPizza.createPizza(type)
        println(pizza.prepare())

        pizza = ankPizza.createPizza(type)
        println(pizza.prepare())

        return pizza
    }
}