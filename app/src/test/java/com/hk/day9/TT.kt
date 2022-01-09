package com.hk.day9

class TT {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            greeting({
                println("Before")
            }, {
                // 由于函数内联优化，两个函数类型参数均被内联，代码铺平后，
                // return 直接结束了 main 方法，导致 println("Finish Greeting") 未执行，
                println("After")
                return
            })
            println("Finish Greeting")
        }

        private inline fun greeting(before: () -> Unit, after: () -> Unit) {
            before()
            println("Hello")
            after()
        }
    }
}