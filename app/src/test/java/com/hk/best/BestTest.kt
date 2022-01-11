package com.hk.best

import org.junit.Test

class BestTest {

    @Test
    fun test() {
        try {
            val unsafeClass = Class.forName("sun.misc.Unsafe")

            val theUnsafeField = unsafeClass.getDeclaredField("theUnsafe").apply {
                isAccessible = true
            }
            val unsafe = theUnsafeField.get(null)

            val allocateInstanceMethod = unsafeClass.getMethod("allocateInstance", Class::class.java)
            val student = ((allocateInstanceMethod.invoke(unsafe, Student::class.java)) as Student).apply {
                name = "David"
            }
            println(student.name)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}