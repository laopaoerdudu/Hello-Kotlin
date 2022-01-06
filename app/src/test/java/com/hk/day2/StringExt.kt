package com.hk.day2

fun String.doubleToString(): String {
    return this.toString() + "__" + this.toString()
}
