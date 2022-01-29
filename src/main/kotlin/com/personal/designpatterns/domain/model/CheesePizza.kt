package com.personal.designpatterns.domain.model

class CheesePizza : Pizza {

    override fun prepare() : String {
        return "cheese-prepared"
    }
    override fun bake() : String {
        return "cheese-baked"
    }
    override fun cut() : String {
        return "cheese-cutted"
    }
    override fun box() : String {
        return "cheese-boxed"
    }
}