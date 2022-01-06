package com.hk.day2

import org.junit.Test

class UserTest {

    @Test
    fun testUser() {
        val user1 = User("David", 18)
        val user2 = user1.copy()
        println(user1 == user2)
        println(user1 === user2)
    }
}