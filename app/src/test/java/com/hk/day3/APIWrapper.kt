package com.hk.day3

// 在实际开发中我们的接口往往可能不止一个方法，可能会有多个方法，
// 但我们在实际使用代理模式的时候，我们往往不需要代理全部的方法，
// 可能 10 个方法里面只有 2 个方法 我们想代理用一下，其他都保持默认。
// 这种情况下，Kotlin 的 by 关键字就很有用了，你使用了一个 by 关键字，其他默认的8个方法你都不需要管了，只需要重写你想代理的2个方法就可以。
// 但是如果你用 Java的 代码来写，你需要将这 10 个方法都实现一遍，这种时候就很麻烦了。
// 代码反编译一下，你就明白了

class APIWrapper(private val api: API) : API by api {
    override fun c() {
        println("这个叫接口代理")
        api.c()
    }
}