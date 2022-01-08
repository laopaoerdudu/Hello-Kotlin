package com.hk.day5

// 实际上 Kotlin 中的 lambda 就是一个匿名函数
val lambda: () -> Unit = {
    println("lambda 括号里面的函数最后一行就是这个函数的返回值")
}

val hhh: (Int) -> String = {
    it.toString()
}

val f5 = { p: Int -> p + 10 }

fun t1(params: (Int) -> String): String {
    return params(10)
}

fun testT1() {
    val name = ::t1
}

val increment = { i: Int -> i + 1 }
val bicrement = { i: Int -> i + 2 }
val double = { i: Int -> i * 2 }
val one = { 1 }

infix fun <T, R> (() -> T).then(another: (T) -> R): () -> R = { another(this()) }
operator fun <T, R1, R2> ((T) -> R1).plus(another: (T) -> R2) = { x: T -> this(x) to another(x) }

fun main(args: Array<String>) {
    val equilibrum = one then double then (increment + bicrement)
    print(equilibrum())
}

// (one then double) -> 2
// (increment + bicrement) -> (i+1) to (i+2)
// 2 then ((i+1), (i+2))