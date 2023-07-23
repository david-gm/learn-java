
public class TestGenerics {
    public static void main(String[] args) {
        new TestGenerics().run();
    }

    public void run() {
        Pet[] pets = {new Dog(), new Cat(), new Dog()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        takePets(pets);
        takePets(dogs);
    }

    public void takePets(Pet[] pets) {
        for(Pet p : pets)
            p.eat();
        pets[0] = new Cat(); // raises java.lang.ArrayStoreException for array dogs!
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