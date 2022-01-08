package com.hk.day4

import org.junit.Test

class Day4Test {

    @Test
    fun test() {
        // 还是那句话，扩展函数的本质是静态函数，定义了同名的方法
        // 你懂的！！！
        printSys(C())
        printSys(D())
    }
}