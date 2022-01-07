package com.hk.day3

class APIWrapper(private val api: API) : API by api {
    override fun c() {
        println("这个叫接口代理")
        api.c()
    }
}