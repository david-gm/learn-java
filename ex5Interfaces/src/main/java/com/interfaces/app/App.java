package com.interfaces.app;

import com.interfaces.app.animals.*;

public class App {
    private static void printHash(String prefix, Animal animal) {
        System.out.println(prefix + animal.getType() + ": " + animal.hashCode());
    }

    public static void main(String[] args) {

        AnimalList list = new AnimalList();
        Animal cat = new Cat();
        printHash("original ", cat);
        Animal dog = new Dog();
        printHash("original ", dog);
        
        list.addAnimal(cat);
        list.addAnimal(dog);

        cat = null;

        printHash("in list ", list.getAnimal(0));
        printHash("in list ", list.getAnimal(1));

        for(int i = 0; i < list.getLength(); ++i) {
            System.out.println(list.getAnimal(i).getType());
        }
    }
}