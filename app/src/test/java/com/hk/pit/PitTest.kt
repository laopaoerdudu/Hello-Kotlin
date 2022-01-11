package com.hk.pit

import org.junit.Test

class PitTest {

    @Test
    fun test() {
        val sample = Sample(0)
        val map = mutableMapOf<Sample, String>()
        map[sample] = "David"
        println("before -> ${map[sample]}")

        // 修改了对象的一些属性
        sample.id = 2

        // 拿不到 value 了
        println("after -> ${map[sample]}")

        // data class 覆写了 hashCode() 和 equals() 方法，并且内部使用所有字段参与两个方法的计算，
        // 所以如果任意一个字段发生变化，前后两个 hashCode() 将会发生变化，而 HashMap 的 get() 方法先通过哈希码进行散列，
        // 只有出现哈希冲突的时候才使用 equals() 进行计算。
        // 虽然存储在 Map 中的对象是同一个，但是因为前后的哈希值发生变化，所以前后散列的位置是不同的。
        // 因此修改了字段属性之后，再使用 get()  方法获取数据的时候，找到的坑位（position）不是之前的那个坑，所以就不会走到 eqauls() 的方法进行校验。
        println(map.keys.last() == sample)
    }
}