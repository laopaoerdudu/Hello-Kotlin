package com.hk.day3;

import org.junit.Test;

class PersonTest {

    @Test
    public void testPerson() {
        // 不加 @JvmOverloads，你试试
        Person person = new Person(10);
    }
}
