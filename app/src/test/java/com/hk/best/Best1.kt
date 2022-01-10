package com.hk.best

import org.junit.Test

class Best1 {

    @Test
    fun test1() {
        val oldName = "hi DHL"
        val newName = "hi dhl"
        oldName.equals(newName, ignoreCase = true)
    }

    @Test
    fun test2() {
        doWithTry {
            1 / 0
        }
    }

    // 实现一个通用的异常捕获方法
    private inline fun <T, R> T.doWithTry(block: (T) -> R) {
        try {
            block(this)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    // filter -> 1,
    // map -> 1,
    // forEach -> 2,
    // filter -> 2,
    // filter -> 3,
    // map -> 3,
    // forEach -> 6,
    // kotlin.Unit
    @Test
    fun testSequence() {
        val data = (1..3).asSequence()
            .filter { println("filter -> $it, "); it % 2 == 1 }
            .map { println("map -> $it, "); it * 2 }
            .forEach { println("forEach -> $it, ") }
        println(data)
    }

    // filter -> 1,
    // filter -> 2,
    // filter -> 3,
    // map -> 1,
    // map -> 3,
    // forEach -> 2,
    // forEach -> 6,
    // kotlin.Unit
    @Test
    fun testIterable() {
        val data = (1..3).asIterable()
            .filter { println("filter -> $it, "); it % 2 == 1 }
            .map { println("map -> $it, "); it * 2 }
            .forEach { println("forEach -> $it, ") }
        println(data)
    }
}