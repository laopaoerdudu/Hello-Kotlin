package com.hk.day3

import kotlin.properties.Delegates

// lazy 就是一个属性代理，代理的是 hostName 的 get() 方法
class Master(var name: String) {
    val hostName by lazy {
        name.split("")[1]
    }
}

//// 用 observable 来监听某个属性的变化
//class StateManager {
//    var state: Int by Delegates.observable(0) { _, oldValue, newValue ->
//        println("Observer state value changed from $oldValue to $newValue")
//    }
//}