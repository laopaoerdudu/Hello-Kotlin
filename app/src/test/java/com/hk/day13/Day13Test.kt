package com.hk.day13

import org.junit.Test

class Day13Test {

    @Test
    fun test() {
        println("result: ${getData2()}")
    }

    // 创建一个高阶函数，使用了两个函数型参
    private fun doAction1(var0: Int, var1: Int, operate: (Int, Int) -> Int, result: (Int) -> Unit) {
        var result = operate(var0, var1)
        result(result)
    }

    // 在使用 inline 修饰高阶函数后，就把代码内联到调用处了，就不会编译为 FunctionX 类，此举减少了运行时的对象创建开销
    // 弊端就是代码被内联到调用处了，lambda 内部就可以使用 return 语句了，并且会直接作用于调用处函数。
    private inline fun doAction2(var0: Int, var1: Int, operate: (Int, Int) -> Int, result: (Int) -> Unit) {
        var result = operate(var0, var1)
        result(result)
    }

    inline fun doAction3(var0: Int, var1: Int, operate: (Int, Int) -> Int, crossinline result: (Int) -> Unit) {
        var result = operate(var0, var1)
        result(result)
    }

    inline fun doAction4(var0: Int, var1: Int, noinline operate: (Int, Int) -> Int, crossinline result: (Int) -> Unit) {
        var result = operate(var0, var1)
        result(result)
    }

    fun getData1(): Int {
        var product = 0
        for (i in 1 until 10) {
            doAction1(product, i, { a, b ->
                a + b
            }, {
                product += it
            })
        }
        return product
    }

    var product = 0

    private fun getData2(): Int {
        var product = 0
        for (i in 1 until 10) {
            doAction2(product, i, { a, b ->
                a + b
            }, {
                if(it > 0) {
                    // 使用了 inline 修饰 doAction2() 会直接跳出 getData2()，因为在编译时已经被内联到这里了，所以 return 就是直接在 getData2() 函数里 return 了。
                    return it
                }
                println("#57")
                product += it
                println("#59")
            })
        }
        println("#62")
        return product
    }

    private fun getData3(): Int {
        var product = 0
        for (i in 1 until 10) {
            doAction3(product, i, { a, b ->
                a + b
            }, {
                if(it > 0) {
                    return@doAction3
                }
                println("#75")
                product += it
                println("#77")
            })
        }
        println("#80")
        return product
    }

    private fun getData4(): Int {
        var product = 0
        for (i in 1 until 10) {
            doAction4(product, i, { a, b ->
                a + b
            }, {
                if(it > 0) {
                    return@doAction4
                }
                println("#75")
                product += it
                println("#77")
            })
        }
        println("#98")
        return product
    }
}