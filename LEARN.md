# JAVA

## Arrays:

simple array:
```java
// initialization:
Dog[] allPets;
allPets = new Dog[7];
allPets[0] = new Dog();
allPets[1] = new Dog();

// remove
allPets[1] = null;
// runtime error:
allPets[8] = new Dog();
```
ArrayList
```java
ArrayList<Dog> allPets = new ArrayList<Dog>();  // no need to set size

// NOTE: array list with capacity of 7; allPets.size() return 0 still!
ArrayList<Dog> allPets = new ArrayList<Dog>(7);
allPets.add(new Dog());
allPets.remove(1); // remove Dog at index 1
allPets.size();
```

## Casting

```java
int a = Integer.parseInt("25");
```

## Classes and Objects:

- all Objects inherit from the class Object:
    - hashCode()
    - equals()
    - toString()
    - getClass()
- all Objects are only accessible by their reference:
    ```java
    ABC new_abc = new ABC()
    ```
    new_abc is only reference to object
- in principle: method parameters are pass by value (only base data-types)
- Instance variables:
    - if not initialized, they get a default value assigned:
        - integers and chars: 0
        - floats: 0.0
        - booleans: false
        - references: null
- Comparing objects:
    - `==` compares basic data-types and memory adresses of objects
    - `.equals()` compares values of objects

- determine inheritance or membership:
  - is-a: a dog is a animal: inharitence
  - has-a: a car has a wheel: member

## Polymorphism:
```java
class Animal {
    public void sleep() {
        System.out.println("Animal sleeps");
    }
    public static void main(String[] args) {
        Animal[] animals = new Animal[2]; // creating array of reference for superclass only
        animals[0] = new Animal();
        animals[1] = new Cat();
        for (Animal a : animals) {
            a.sleep();  // polymorphism: the "lowest" method found of each object is called
        }
    }
}

class Cat extends Animal {
    public void sleep() {
        System.out.println("Cat sleeps");
    }
}
```
output:
```
Animal sleeps
Cat sleeps
```

## Abstraction 

### Classes

- cannot be instantiated

```java
abstract public class AbstractClass
{
}
```

### Methods

- if abstract methods are present, the class has to be abstract too
- you can mix non-abstract and abstract methods in an abstract class
- abstract methods have no body
- abstract methods have to be implemented in sub-classes

```java
public abstract void newMethod();
```

## Interfaces

- the interface is **public** by default
- all **methods** of an interface are **abstract** by default

```java
public interface MyInterface {
    public void newMethod();
    public void anotherMethod();
}
```

- interfaces need to be implemented:
```java
public class MyClass implements MyInterface {
    @Override
    public void newMethod() {

    };
    @Override
    public void anotherMethod() {

    };
}
```

## Access control:

- final class: cannot be inherited from
- Order: `public -> protected -> default -> private`
- *public:* 
  - a subclass inherits all public instance variables and methods
- *protected:*
  - subclasses can use, initiate, and use the protected class as a result, even if they are not in the same package.
- *default:* (no access modifier) only classes in the same package can use the `class ABC`. Others cannot initiate, get the class as a result, or see the `default` class.
- *private:*
  - a subclass cannot access instance variables nor methods

## JAR

- view content of a JAR file:
```shell
jar tf jar-file
```

- without MANIFEST.MF file, the complete classpath (`-cp`) to the main class has to be provided, e.g.
```shell
java -cp ex4Polymorphism-1.0-SNAPSHOT.jar com.polymorphism.app.App
```