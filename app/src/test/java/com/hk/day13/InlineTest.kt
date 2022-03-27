package com.hk.day13

import org.junit.Test

class InlineTest {

    @Test
    fun test() {
        // 使用了 inline 修饰 doAction() 会直接跳出 getData()，因为在编译时已经被内联了
        // 所以返回是 1
        assert(1 == getData())
    }

    private fun getData(): Int {
        var product = 0
        for (i in 1 until 10) {
            doAction(product, i, { a, b ->
                a + b
            }, {
                if(it > 0) {
                    return it
                }
                product += it
            })
        }
        return product
    }

    /** 在使用 inline 修饰高阶函数后，就把代码内联到调用处了，就不会编译为 FunctionX 类，此举减少了运行时的对象创建开销。*/
    private inline fun doAction(var0: Int, var1: Int, operate: (Int, Int) -> Int, result: (Int) -> Unit) {
        val data = operate(var0, var1)
        result(data)
    }
}