package com.personal.designpatterns.domain.model

class GreekPizza : Pizza {

    override fun prepare() : String {
        return "greek-prepared"
    }
    override fun bake() : String {
        return "greek-baked"
    }
    override fun cut() : String {
        return "greek-cutted"
    }
    override fun box() : String {
        return "greek-boxed"
    }
}