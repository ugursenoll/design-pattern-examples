package com.personal.designpatterns.domain.model

interface Pizza {

    fun prepare() : String
    fun bake() : String
    fun cut() : String
    fun box() : String
}