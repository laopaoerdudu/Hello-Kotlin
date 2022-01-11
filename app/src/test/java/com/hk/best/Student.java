package com.hk.best;

public class Student {
    public String name;

    private Student() {
        throw new IllegalArgumentException("can not create.");
    }
}
