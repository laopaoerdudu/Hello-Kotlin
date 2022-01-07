package com.hk.day3

enum class State : Runnable {
    IDLE, BUSY, ERROR;

    override fun run() {
        println("Every state run")
    }
}

// 取下一个枚举的值
fun State.next(): State {
    return State.values().let {
        val nextOrdinal = (ordinal + 1) % (it.size)
        it[nextOrdinal]
    }
}
