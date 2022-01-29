package com.personal.designpatterns.domain.service.factory

import com.personal.designpatterns.domain.model.Pizza

abstract class PizzaStoreFactory {
    fun orderPizza(type: String?): Pizza {
        val pizza: Pizza = createPizza(type)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    abstract fun createPizza(type: String?): Pizza
}
