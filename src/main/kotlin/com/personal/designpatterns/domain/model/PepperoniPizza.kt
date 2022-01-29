package com.personal.designpatterns.domain.model

class PepperoniPizza : Pizza {

    override fun prepare() : String {
        return "pepperoni-prepared"
    }
    override fun bake() : String {
        return "pepperoni-baked"
    }
    override fun cut() : String {
        return "pepperoni-cutted"
    }
    override fun box() : String {
        return "pepperoni-boxed"
    }
}