package com.personal.designpatterns.domain.service.prototype

abstract class PrototypeShape() {
    var x: Int = 0
    var y: Int = 0
    lateinit var color: String

    abstract fun clone(): PrototypeShape?
}

class Circle : PrototypeShape() {
    override fun clone(): PrototypeShape? {
        return Circle()
    }
}