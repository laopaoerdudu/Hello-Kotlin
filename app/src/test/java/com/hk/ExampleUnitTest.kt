package com.hk

import org.junit.Test
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val arrays = intArrayOf(1, 2, 3, 4, 5)

        assert("[1, 2, 3, 4, 5]" == arrays.contentToString())
    }

    @Test
    fun `test has asSequence operator`() {
        listOf(1, 2, 3, 4, 5)
            .asSequence()
            .filter {
                println("filter: $it")
                it > 3
            }.map {
                println("map: $it")
                "Top $it"
            }.forEach(::println)
    }

    @Test
    fun `test have no asSequence operator`() {
        listOf(1, 2, 3, 4, 5)
            .filter {
                println("filter: $it")
                it > 3
            }.map {
                println("map: $it")
                "Top $it"
            }.forEach(::println)
    }

    // asSequence() 只循环一次
    @Test
    fun `test has asSequence operator but have no forEach operator`() {
        listOf(1, 2, 3, 4, 5)
            .asSequence()
            .filter {
                println("filter: $it")
                it > 3
            }.map {
                println("map: $it")
                "Top $it"
            }
    }

    @Test
    fun `test have no asSequence operator and have no forEach operator`() {
        listOf(1, 2, 3, 4, 5)
            .filter {
                println("filter: $it")
                it > 3
            }.map {
                println("map: $it")
                "Top $it"
            }
    }

    @Test
    fun `test flatMap operator`() {
        val result = listOf(1, 2, 3)
            .flatMap {
                0 until it
            }
        // 1 -> (0 until 1) -> [0]
        // 2 -> (0 until 2) -> [0, 1]
        // 3 -> (0 until 3) -> [0, 1, 2]
        // 所以最后的结果就是这3个 list 相加 -> [0, 0, 1, 0, 1, 2]
        println("result: $result")
    }

    @Test
    fun `test map operator`() {
        val result = listOf(1, 2, 3)
            .map {
                0 until it
            }
        // [0..0, 0..1, 0..2]
        println("result: $result")
    }

    // 统计一个文件里除了空格字符以外，每个字符出现的次数（尽量只使用 lambda ）
    /**
     *  1. 读文件，然后把文件的内容转成 char 的数组
     *  2. 过滤数组，空格符直接忽略
     *  3.用 groupBy 来将整个数组重新分组（分组的结果是一个 map ）， key 就是出现的字符，value 就是出现的全部字符
     *  4.用 map 操作符 再将这个 map 拍平成一个 list，这个 list 的 内容形如：e 出现次数: 21
     *  5.用 let 操作符 将结果打印出来即可
     */
    @Test
    fun `test`() {
        File("/Users/david/study-code/Hello-Kotlin/src/test.kt")
            .readText()
            .toCharArray()
            .filterNot {
                it.isWhitespace()
            }.groupBy {
                it
            }.map {
                it.key + " 出现次数: " + it.value.size
            }.forEach(::println)
    }
}