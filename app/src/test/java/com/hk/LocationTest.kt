package com.hk

import org.junit.Test

class LocationTest {

    @Test
    fun test() {
        val location = Location(520, 1314)
        val (x, y) = location
        println(x)
        println(y)

        val other = Location(1, 2)

        println(location - other)
        println(location + other)
        println(location == other)
        println(other in location)
    }

    @Test
    fun test1() {
        { print("Hello, ") } + { print("World") }
    }

    operator fun (() -> Unit).plus(f: () -> Unit) = run {
        this()
        f()
    }
}