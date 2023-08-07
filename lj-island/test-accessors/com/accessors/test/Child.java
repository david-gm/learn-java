package com.accessors.test;

public class Child extends Parent {
    public void accessor() {
        protectedI = 1;
        System.out.println(protectedI);
    }
}
