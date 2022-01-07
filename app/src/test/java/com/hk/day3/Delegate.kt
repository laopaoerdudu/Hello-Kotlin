package com.hk.day3

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// 属性委托
class Delegate : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "delegate string"
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("delegate get value$value")
    }
}

// 这种写法实际上比我们自己重写 get 和 set 方法 逻辑上要清晰的多。
class Dto {
    var name: String by Delegate()
}


