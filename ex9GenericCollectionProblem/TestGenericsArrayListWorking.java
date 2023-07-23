import java.util.ArrayList;

public class TestGenericsArrayListWorking {
    public static void main(String[] args) {
        new TestGenericsArrayListWorking().run();
    }

    public void run() {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());

        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(new Dog());
        pets.add(new Cat());
        takePets(dogs);
        takePets(pets);
    }
    // Note: T extends Pet prevents altering the ArrayList!
    public <T extends Pet> void takePets(ArrayList<T> pets) {
        for(Pet p : pets)
            p.eat();
        //pets.add(new Cat()); // fails to compile because we alter the list
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