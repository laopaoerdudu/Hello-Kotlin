package com.hk.day9

import org.junit.Test

class Day9Test {

    @Test
    fun test1() {
        println("start")

        doA {
            return
        }

        println("end")
    }

    private inline fun doA(block: () -> Unit) {
        block()
    }

    @Test
    fun test2() {
        println("start")

        doB {
            // return // 添加 return 语句，Android Studio 会直接提示 return is not allowed here
            return@doB // 要么使用 return@label 的方式明确告诉它 return 到何处，要么就禁止使用 return。
        }

        println("end")
    }

    private inline fun doB(crossinline block: () -> Unit) {
        block()
    }
}