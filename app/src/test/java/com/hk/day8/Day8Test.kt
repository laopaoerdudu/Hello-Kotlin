package com.hk.day8

import org.junit.Test

class Day8Test {

//    @Test
//    fun test1() {
//        val s: String? = null
//        if (s.isNullOrEmpty()) println("is null or empty")
//    }
//
//    @Test
//    fun test2() {
//        val readonly = listOf(1, 2, 3)
//        if (readonly is MutableList) {
//            println("yes")
//            readonly.add(4)
//        }
//        println(readonly)
//    }

//    @Test
//    fun test4() {
//        Children("abc")
//    }
//
//    open class Parent(open val a: String) {
//        init {
//            println("Parent: $a")
//        }
//    }
//
//    class Children(override val a: String) : Parent(a) {
//        init {
//            println("Children: $a")
//        }
//    }
//
//    @Test
//    fun test5() {
//        val list = mutableListOf("one", "two")
//        val c1 = Container(list)
//        val c2 = c1.copy()
//        list += "oops"
//        println("c1: ${c1.list.joinToString()}")
//        println("c2: ${c2.list.joinToString()}")
//    }
//
//    data class Container(val list: MutableList<String>)
//
//    @Test
//    fun test6() {
//        var j = 0
//        println(j++)
//        println(++j)
//    }

//    @Test
//    fun test7() {
//        (1..4).forEach {
//            if (it == 2) return
//            print(it)
//        }
//    }
//
//    @Test
//    fun test8() {
//        (1..4).forEach(fun(it) {
//            if (it == 2) return
//            print(it)
//        })
//    }

    @Test
    fun test9() {
        val (name, items) = Boss("Kotlin", listOf(1, 2))
        println("Hello $name, $items")
    }

    data class Boss(
        val name: String,
        private val items: List<Int>
    ) : List<Int> by items

    @Test
    fun test10() {
        val x: Int? = 2
        val y = 3
        val sum = x ?: 0 + y
        println(sum)
    }
}