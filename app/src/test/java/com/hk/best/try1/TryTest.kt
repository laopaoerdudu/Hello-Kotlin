package com.hk.best.try1

import com.google.gson.Gson
import org.junit.Test

class TryTest {

    @Test
    fun test() {
        val gson = Gson()
        val person = gson.fromJson("{\"age\":\"12\"}", Person::class.java)
        // 意外绕过了 Kotlin 的空类型检查
        println("person = $person")
    }
}