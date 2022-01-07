package com.hk.day5

// 实际上 Kotlin 中的 lambda 就是一个匿名函数
val lambda: () -> Unit = {
    println("lambda 括号里面的函数最后一行就是这个函数的返回值")
}

val f5 = { p: Int -> p + 10 }
