package com.hk.day5

import org.junit.Test

class Day5Test {

    @Test
    fun test1() {
        val aa = println("hello")
        println(aa)
    }

    @Test
    fun test2() {
        val a = { println("hello") }
        println(a)
    }

    @Test
    fun test3() {
        // Lambda 表达式类型为 ()-> Unit，而 Lambda 表达式后跟上 () 其实就是调用 invoke() 函数，表示函数类型的调用。
        // 那么，一个类型为 ()-> Unit 的函数类型调用后返回什么呢？自然是 Unit
        val whatAmI = {}()
        println(whatAmI)
    }
}