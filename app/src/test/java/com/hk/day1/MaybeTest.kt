package com.hk.day1

import org.junit.Test

class MaybeTest {

    @Test
    fun test() {
        val some = Maybe.Some(payload = "String of data")
        val none = Maybe.None(exception = Exception())
        println(some)
        println(none)
    }
}