package com.polymorphism.app;

import java.util.ArrayList;

import com.polymorphism.animal.Animal;
import com.polymorphism.animal.Carnivore;
import com.polymorphism.animal.Herbivore;
import com.polymorphism.animal.IPet;

import com.polymorphism.animal.herb.Hedgehog;
import com.polymorphism.animal.herb.Mouse;

public class App {
    public static void main(String[] args) {

        ArrayList<Animal> list = new ArrayList<>();

        list.add(new Carnivore("Rudi"));
        list.add(new Herbivore("Sophie"));
        list.add(new Hedgehog("Claus"));
        list.add(new Mouse("Tom"));

        for (Animal a : list) {
            System.out.println(a.toString());
            a.eat();
            if (a instanceof IPet) {
                IPet b = (IPet) a;
                b.sing();
            }
        }
    }
}
