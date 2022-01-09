package com.hk.day1

import org.junit.Test

class Day1Test {

    @Test
    fun test() {
        // 交换两个变量
        var a = 1
        var b = 2
        a = b.also { b = a }
    }
}