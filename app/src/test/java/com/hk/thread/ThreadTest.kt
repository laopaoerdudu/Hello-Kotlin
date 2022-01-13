package com.hk.thread

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.Thread.sleep
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.CyclicBarrier
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

// Requirement: "现有 Task1、Task2 等多个并行任务，如何等待全部任务执行完成后，开始执行 Task3 ?"

val task1: () -> String = {
    sleep(2000)
    "Hello".also { println("task1 finished: $it") }
}

val task2: () -> String = {
    sleep(2000)
    "World".also { println("task2 finished: $it") }
}

val task3: (String, String) -> String = { p1, p2 ->
    sleep(2000)
    "$p1 $p2".also { println("task3 finished: $it") }
}

class ThreadTest {

    @Test
    fun test1() {
        lateinit var s1: String
        lateinit var s2: String
        val t1 = Thread { s1 = task1() }
        val t2 = Thread { s2 = task2() }
        t1.start()
        t2.start()
        t1.join()
        t2.join()
        task3(s1, s2)
    }

    @Test
    fun test2() {
        lateinit var s1: String
        Thread {
            synchronized(Unit) {
                s1 = task1()
            }
        }.start()
        var s2: String = task2()

        synchronized(Unit) {
            task3(s1, s2)
        }
    }

    @Test
    fun test3() {
        lateinit var s1: String
        val lock = ReentrantLock()

        Thread {
            lock.lock()
            s1 = task1()
            lock.unlock()
        }.start()
        var s2: String = task2()

        lock.lock()
        task3(s1, s2)
        lock.unlock()
    }

    @Test
    fun test4() {
        lateinit var s1: String
        lateinit var s2: String
        val cd = CountDownLatch(2)
        Thread {
            s1 = task1()
            cd.countDown()
        }.start()
        Thread {
            s2 = task2()
            cd.countDown()
        }.start()
        cd.await()

        task3(s1, s2)
    }

    @Test
    fun test5() {
        runBlocking {
            val c1 = async(Dispatchers.IO) {
                task1()
            }

            val c2 = async(Dispatchers.IO) {
                task2()
            }

            task3(c1.await(), c2.await())
        }
    }
}