package com.hk.day13

import org.junit.Test

class NormalTest {

    @Test
    fun test() {
        // WHEN
        val result = getData()
    }

    private fun getData(): Int {
        var product = 0
        for (i in 1 until 10) {
            doAction(product, i, { a, b ->
                a + b
            }, {
                product += it
            })
        }
        return product
    }

    // 创建一个高阶函数，使用了两个函数型参
    private fun doAction(var0: Int, var1: Int, operate: (Int, Int) -> Int, result: (Int) -> Unit) {
        val data = operate(var0, var1)
        result(data)
    }
}