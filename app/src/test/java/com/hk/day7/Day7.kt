package com.hk.day7

open class C

class D: C()

// Kotlin 扩展函数的本质是静态函数
fun C.foo() = "C.foo()"

fun D.foo() = "D.foo()"

fun printInfo(c: C) {

    // 由于参数类型为 C，所以代码中 c.foo() 对应的是 fun C.foo() = "c" 编译成的静态函数。
    // 虽然运行时传入的是 D()，但是依然会被强转成 C 然后执行 fun C.foo() = "c" 对应的静态方法
    println(c.foo())
}
