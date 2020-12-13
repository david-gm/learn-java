package com.polymorphism.animal;

public class Carnivore extends Animal {
    public Carnivore(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(String.format("%s [%s] eats meat", this.getName(), this.getType()));
    }

}