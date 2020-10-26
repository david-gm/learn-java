package com.polymorphism.app;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Animal[] animals = new Animal[3];

        animals[0] = new Animal();
        animals[1] = new Cat();
        animals[2] = new Tiger();

        for (Animal a : animals) {
            a.sleep();
        }

    }
}
