package com.hk.day6

// 第一种方案
//open class A {
//    open fun a() {}
//}
//
//abstract class B : A() {
//    abstract override fun a()
//}
//
//open class C : B() {
//    override fun a() {
//        println("a impl")
//    }
//}

// ==========也可以这样================
//open class A {
//    open fun a() {}
//}
//
//abstract class B: A() {
//    abstract override fun a()
//}
//
//abstract class C: B()

// ============还可以这样===============
open class A {
    open fun a() {}
}

abstract class B : A() {
}

open class C : B()
