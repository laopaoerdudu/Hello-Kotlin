package com.hk.day15

import org.junit.Test

class Day15Test {

//    @Test
//    fun test1() {
//        val a = -0
//        val b = 0
//        assert(a == b)
//    }
//
//    @Test
//    fun test2() {
//        val a = -0f
//        val b = 0f
//        assert(a == b)
//        assert(!a.equals(b))
//    }

    @Test
    fun test3() {
        val user1 = User("David", 18)
        val user2 = User("David", 18)
        assert(user1 != user2)
        assert(user1 !== user2)
    }

//    @Test
//    fun test4() {
//        val person1 = Person("David", 18)
//        val person2 = Person("David", 18)
//        assert(person1 == person2)
//        assert(person1 !== person2)
//    }
}