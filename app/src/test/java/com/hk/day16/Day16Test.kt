package com.hk.day16

import org.junit.Test
import java.util.*

class Day16Test {

    @Test
    fun test1() {
        // GIVEN
        val numbers = listOf(1, 1, 1)

        // WHEN
        val result = numbers.reduce { a: Int, b: Int -> a + b }

        // THEN
        assert(3 == result)
    }

    @Test
    fun test2() {
        // GIVEN
        val numbers = listOf(1, 1, 1)

        // WHEN
        val result = numbers.fold(StringBuilder()) {
                str: StringBuilder, i: Int -> str.append(i).append(" ")
        }

        // THEN
        assert("1 1 1 " == result.toString())
    }

    @Test
    fun test3() {
        // GIVEN
        val numbers = emptyList<Unit>()

        // WHEN
        val result = numbers.fold(StringBuilder()) {
                str: StringBuilder, i: Unit -> str.append(i).append(" ")
        }

        // THEN
        println("result -> $result")
    }

    @Test
    fun test4() {
        // GIVEN
        val firstElement = 3
        //class kotlin.sequences.ConstrainedOnceSequence
        val sequence = generateSequence(firstElement) {
            it + 2
        }

        // WHEN
        val result = sequence.take(5).toList()

        // THEN
        assert("[3, 5, 7, 9, 11]" == result.toTypedArray().contentToString())
    }

    @Test
    fun test5() {
        listOf("The","quick","brown").map {
            println("map $it")
            it
        }
    }

    @Test
    fun test6() {
        // 很遗憾什么都不会打印
        // Sequence 的操作分为 中间操作 和 末端操作
        // Sequence 的操作函数如果返回值的类型是 Sequence，那么这个操作就是一个中间操作。
        // 中间操作并不会触发数据的 发射 和 遍历。
        // 否则这个操作就是末端操作。
        // 只有对 Sequence 执行末端操作才会触发数据的 发射 和 遍历。
        // 我们也称这种数据流为冷流。
        listOf("The","quick","brown").asSequence().map {
            println("map $it")
            it
        }
    }
}