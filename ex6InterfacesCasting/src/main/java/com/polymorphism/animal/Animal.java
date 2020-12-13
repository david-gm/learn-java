package com.polymorphism.animal;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public void eat() {
        System.out.println(String.format("%s [%s] eats something", this.name, this.getType()));
    }

    protected String getType() {
        return this.getClass().getSimpleName();
    }
}