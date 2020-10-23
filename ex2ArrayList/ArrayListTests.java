package ex2ArrayList;

import java.util.ArrayList;

public class ArrayListTests {
    public static void main(String[] args) {
        System.out.println("Test Array List");

        ArrayList<Dog> dogs = new ArrayList<>(3);
        System.out.println("dogs length: " + dogs.size());

        dogs.add(new Dog("Hunno", "Golden Retriever"));
        dogs.add(new Dog("Oscar", "Australian Shepard"));

        System.out.println("dogs length: " + dogs.size());
        for (Dog dog : dogs) {
            System.out.println(dog.toString());
        }

        dogs.remove(0);
        System.out.println("dogs length: " + dogs.size());
    }
}

class Dog {
    private String name;
    private String dogBreed;

    public Dog(String name, String dogBreed) {
        this.name = name;
        this.dogBreed = dogBreed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    @Override
    public String toString() {
        return this.name + " " + this.dogBreed;
    }
}