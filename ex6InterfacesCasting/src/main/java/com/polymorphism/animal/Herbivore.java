package com.polymorphism.animal;

public class Herbivore  extends Animal {
    public Herbivore(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(String.format("%s [%s] eats plants", this.getName(), this.getType()));
    }
}