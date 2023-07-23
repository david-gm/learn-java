import java.util.ArrayList;

public class TestGenericsArrayList {
    public static void main(String[] args) {
        new TestGenericsArrayList().run();
    }

    public void run() {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        takePets(dogs);
    }

    public void takePets(ArrayList<Pet> pets) {
        for(Pet p : pets)
            p.eat();
        pets.add(new Cat()); // fails to compile
    }
}
abstract class Pet {
    void eat() {
        System.out.println("Pet eats");
    }
}
class Dog extends Pet {
    void bark() {}
}
class Cat extends Pet {
    void miau() {}
}