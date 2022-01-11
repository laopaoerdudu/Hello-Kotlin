package com.hk.best.try2

import com.google.gson.Gson
import org.junit.Test

class TryTest {

    @Test
    fun test() {
        val gson = Gson()
        val person = gson.fromJson<Person>("{\"age\":\"12\"}", Person::class.java)
        // 正常情况下，一般构造子类对象，必然会先执行父类的构造方法。
        // 没有执行父类 People 构造方法，但对象构造出来了
        // 这里可以猜到，Person 对象的构建，并不是常规的构建对象，没有走构造方法。
        // 那么它是怎么做到的呢？
        //只能去 Gson 的源码中去找答案了。
        // 直接给结论吧：
        // 原因是我们 Person 没有提供默认的构造方法，Gson 在没有找到默认构造方法时，它就直接通过 Unsafe 的方法，绕过了构造方法，直接构建了一个对象。
        println(person)
    }

    @Test
    fun test1() {

    }
}