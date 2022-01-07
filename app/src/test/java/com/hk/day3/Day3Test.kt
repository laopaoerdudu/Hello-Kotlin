package com.hk.day3

import org.junit.Test

class Day3Test {

    @Test
    fun testMaster() {
        val master = Master("David")
        println("1: ${master.hostName}")
        println("2: ${master.hostName}")
        StateManager().state = 100
    }

    @Test
    fun testEnum1() {
        println(State.IDLE.next())
        println(State.BUSY.next())
        println(State.ERROR.next())
    }
}