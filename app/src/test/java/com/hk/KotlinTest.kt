package com.hk

import org.junit.Test

class KotlinTest {

    @Test
    fun test1() {
        // hello()
        hello().invoke()
        //hello()()
    }

    @Test
    fun test2() {
        // 原始字符串 -> 不支持转义字符
        val world = "multiline world"
        println(
            """
           Hello
           \$world
        """.trimIndent()
        )
    }

    @Test
    fun test3() {
        printNumberSign(-2)
        print(", ")
        printNumberSign(0)
        print(", ")
        printNumberSign(2)
    }

    @Test
    fun test4() {
        // printNumberSign2 和 printNumberSign 等价，但是写法上看起来更清晰
        printNumberSign2(-2)
        print(", ")
        printNumberSign2(0)
        print(", ")
        printNumberSign2(2)
    }

    @Test
    fun test5() {
        printNumberSign3(-2)
        print(", ")
        printNumberSign3(0)
        print(", ")
        printNumberSign3(2)
    }

    @Test
    fun test6() {
        run()
    }

    @Test
    fun test7() {
        // 函数类型变量的两种调用方式：(variable)() 和 variable.invoke()
        run1()
    }

    @Test
    fun test8() {
//        val list = listOf(1, 2, 3)
//        println(list - 1)
//        println(list - listOf(1))

        val ones = listOf(1, 1, 1)
        println(ones - 1)
        println(ones - listOf(1))
    }

    @Test
    fun test9() {
        run2()
    }

    private fun run2() {
        val run: () -> Unit = {
            println("Run run run!")
        }

        Runnable { run() }.run()
    }

    private fun run1() {
//        val run: () -> Unit = {
//            println("Run run run!")
//        }
//
//        fun run() = println("Hello World")
//
//        Runnable { run.invoke() }.run()

        // 或者这样也可以
        val run: () -> Unit = {
            println("Run run run!")
        }

        fun run() = println("Hello World")

        Runnable { (run)() }.run()
    }

    private fun run() {
        val run: () -> Unit = {
            println("Run run run!")
        }

        // 新增一个 run 函数
        fun run() = println("Hello World")

        Runnable { run() }.run()
    }


    private fun printNumberSign(num: Int) {
        // Kotlin 中没有类似于 Java 的三目运算符，取而代之的是 if-else 表达式，
        // let 函数作用于它前面的对象
        if (num < 0) {
            "negative"
        } else if (num > 0) {
            "positive"
        } else {
            "zero"
        }.let { print(it) }
    }

    private fun printNumberSign2(num: Int) {
        if (num < 0) {
            "negative"
        } else {
            if (num > 0) {
                "positive"
            } else {
                "zero"
            }.let { print(it) }
        }
    }

    private fun printNumberSign3(num: Int) {
        (if (num < 0) {
            "negative"
        } else {
            if (num > 0) {
                "positive"
            } else {
                "zero"
            }
        }).let { print(it) }
    }

    private fun hello(): () -> Unit = {
        println("Hello, World")
    }

    @Test
    fun test10() {
        hello { println(this) }
    }

    private fun hello(block: String.() -> Unit) {
        "Hello1".block()
        block("Hello2")
    }

    @Test
    fun test11() {
       // foo { println(it) }
        foo({ print(it) })
    }

    private fun foo(one: L = {}, two: L = {}) {
        one("one")
        two("two")
    }
}

typealias L = (String) -> Unit