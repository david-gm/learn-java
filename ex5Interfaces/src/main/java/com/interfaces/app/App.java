package com.interfaces.app;

import com.interfaces.app.animals.*;

public class App {
    public static void main(String[] args) {

        AnimalList list = new AnimalList();
        Animal cat = new Cat();
        System.out.println("original cat: " + cat.hashCode());
        Animal dog = new Dog();
        System.out.println("original dog: " + dog.hashCode());
        
        list.addAnimal(cat);
        list.addAnimal(dog);

        cat = null;

        System.out.println("cat in list: " + list.getAnimal(0).hashCode());
        System.out.println("dog in list: " + list.getAnimal(1).hashCode());

        for(int i = 0; i < list.getLength(); ++i) {
            System.out.println(list.getAnimal(i).getType());
        }
    }
}