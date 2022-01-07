package com.hk.day3

sealed class Status(val age: Int = 10, val message: String = "David") {
    class Default(var _age: Int) : Status(_age)
    object Loading : Status()
    object Success : Status()
    object Failure : Status()
}
