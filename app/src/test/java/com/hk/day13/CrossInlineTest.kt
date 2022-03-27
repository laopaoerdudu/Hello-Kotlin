package com.hk.day13

import org.junit.Test

class CrossInlineTest {

    @Test
    fun test() {
        // WHEN
        val data = getData()

        // THEN
        assert(0 == data)
    }

    private fun getData(): Int {
        var product = 0
        for (i in 1 until 10) {
            doAction(product, i, { a, b ->
                a + b
            }, {
                if(it > 0) {
                    return@doAction
                }
                product += it
            })
        }
        println("Please go on!")
        return product
    }

    private inline fun doAction(var0: Int, var1: Int, operate: (Int, Int) -> Int, crossinline result: (Int) -> Unit) {
        val data = operate(var0, var1)
        result(data)
    }
}