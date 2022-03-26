package com.hk.day4

open class C {
    open fun foo() = "C #foo"
}

class D : C() {
    override fun foo() = "D #foo"
}

fun C.foo() = "C.foo"

fun D.foo() = "D.foo"

fun printSys(c: C) {
    println(c.foo())
}
