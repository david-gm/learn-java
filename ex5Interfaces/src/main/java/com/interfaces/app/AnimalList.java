package com.interfaces.app;

import com.interfaces.app.animals.Animal;

public class AnimalList
{
    private Animal[] animals = new Animal[5];
    private int numberOfAnimals = 0;

    public void addAnimal(Animal a) {
        animals[numberOfAnimals] = a;
        numberOfAnimals++;
    }

    public Animal getAnimal(int index) {
        if(index <= animals.length)
            return animals[index];
        return null;
    }

    public int getLength() { return numberOfAnimals; }
}