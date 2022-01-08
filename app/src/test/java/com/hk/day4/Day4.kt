package com.hk.day4

open class C {
    open fun foo() = "cc"
}

class D : C() {
    override fun foo() = "dd"
}

fun C.foo() = "c"

fun D.foo() = "d"

fun printSys(c: C) {
    println(c.foo())
}
