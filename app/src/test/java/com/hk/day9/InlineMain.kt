package com.hk.day9

// 编译源码看看
class InlineMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            greeting({
                println("Before")
            }, {
                println("After")
            })
        }

        private inline fun greeting(before: () -> Unit, after: () -> Unit) {
            before()
            println("Hello")
            after()
        }
    }
}