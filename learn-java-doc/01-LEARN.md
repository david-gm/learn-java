# JAVA

## Arrays

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

for (Dog dog : dogs) {
    System.out.println(dog.toString());
}
```

## Casting

```java
int a = Integer.parseInt("25");
```

## Classes and Objects

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

### Constructors

- if no constructor is explicitly declared, the compiler creates a default constructor (with no arguments)
- if at least one constructor is declared, the no default constructor is created by the compiler
- if possible, ALWAYS declare a default constructor if you declare a non-default constructor
- constructors can be overloaded; order and type of arguments matter (see example below)
- instance variabels get default value if no value is assigned (see above)

```java
public class Mushroom {
    public Mushroom() {}
    public Mushroom(int size) {}
    public Mushroom(boolean isPoisonous) {}
    public Mushroom(boolean isPoisonous, int size) {}
    public Mushroom(int size, boolean isPoisonous) {}
}
```

### Constructors and Superclasses

- all constructors of all possible super classes get called, before the own constructor gets called
  - this is also true for abstract classes; they cannot hold instance variables, non-the less they might execute some code in the constructor
- if `super()` needs to get called explicitly, it needs to be the first instruction in the constructor - otherwise the code does not compile
- if no `super()` is declared, the compiler inserts a `super()` itself

### Static members and methods

Static members are the same for each instance of the class. Their are used by each instance of the class and there exists only one instance of the variable in the program. The static variable is instanciated the first time the class is either instanciated or the classed is used by calling a static method.

```java
public class Cat {
    private static int amount = 0;

    public Cat() {
        amount ++;
    }
}
```

Static methods should only be called with their class name (not with an instance):

```java
public class A {
    public static void print(String msg) {
        System.out.println("printing: " + msg);
    }
}

// called in main
public class Main {
    public static void main() {
        A a = new A();
        a.print("abc"); // considered bad practice, at is is misleading, what the method is
        A.print("abc"); // common pratice
    }
}
```

### Final (constants)

A variable declared `final`cannot be changed after intialization.

```java
public static final double PI = 3.14159265;
```

`final` can be used to:

- a `final` method cannot be overwritten
- a `final` variable cannot be changed
- a `final` parameter cannot be changed
- a `final` class cannot be extended; no classes can inherit from this class

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

## Primitive Wrappers and Autoboxing

For each primitive type, a wrapper class is available:

| Type    | Wrapper Type |
| ------- | ------------ |
| boolean | Boolean      |
| char    | Character    |
| byte    | Byte         |
| short   | Short        |
| int     | Integer      |
| long    | Long         |
| float   | Float        |
| double  | Double       |

Wrapping a primitive type:

```java
int i = 288;
Integer iI = new Integer(i); // wrapping NOTE: deprecated conversion: slow
Integer iINew = Integer.valueOf(i); // wrapping
int i_new = iINew.intValue(); // unwrapping
```

**Autoboxing**: conversion from primitive type to Wrapper-Object is automatically applied.

For example, an `ArrayList` object can only be instanciated with actual References, not with primitive types (`ArrayList<int>` is not allowed):

```java
//ArrayList<int> abc = new ArrayList<int>(); // Not allowed!
ArrayList<Integer> abc = new ArrayList<Integer>();

abc.add(1); // int 1 is automatically converted to Integer (Autoboxing)
abc.add(2);
abc.add(3);

for (int iLoop : abc) { // Unboxing Integer to int
    System.out.println(String.format("in loop: %d", iLoop));
}
```

Other examples:

- method arguments: `void num(Integer i) {}`
- return values: `int num() { Integer x = new Integer(1); return x; }`
- operations on numbers: `Integer a = new Integer(3) + 2;`
- assignment: `x = 1; Double d = x;`

## Collections

- ArrayList is basically a C++ vector
- TreeSet is similar to a C++ set (order of insert is kept)
- HashMap is a C++ map
- LinkedList is for faster insert and deletion of elements in the middle of the collection
- HashSet is a C++ set

### Sort Collectibles

#### ArrayList

To sort an Array List: `Collectibles.sort(List list)` can be called.
Prerequisite:

- The class, which is in the `ArrayList<AnyClass>` needs to implement the `Compareable` interface and overrite the `compareTo` method

```java
class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String length;

    Song(String title, String artist, String rating, String length) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.length = length;
    }

    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }
```

- OR: we user the second method pattern of `Collectibles.sort`: `Collectibles.sort​(List<T> list, Comparator<? super T> c)`; we need to provide a comperator:

```java

ArrayList<Song> songsComperator = new ArrayList<Song>();
ArrayList<Song> songsComperatorLam = new ArrayList<Song>();
// add songs to array list
// ...

// sort with Comperators:
Collections.sort(songsComperator, Song.Comperators.ARTIST);
Collections.sort(songsComperatorLam, Song.ComparatorsLambda.TITLE);

public class Song {
    // ...

    public static class Comperators {
        public static final Comparator<Song> TITLE = new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.title.compareTo(o2.title);
            }
        };

        public static final Comparator<Song> ARTIST = new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.artist.compareTo(o2.artist);
            }
        };
    }

    // using Comparator inner classes and lambdas (Java 8)
    public static class ComparatorsLambda {
        public static final Comparator<Song> TITLE = (Song o1, Song o2) -> o1.title.compareTo(o2.title);
        public static final Comparator<Song> ARTIST = (Song o1, Song o2) -> o1.artist.compareTo(o2.artist);
    }
```

#### HashSet

The set requires the methods `boolean equals(Object other)` and `int hashCode()` to exist. They proof, if the members of two objects are equal, and if the object-refenrences point to the same object (hashCode comparison).

We need to override the hashCode method, otherwise, two Objects will never be "same", as they have a different HashCode.

General Contracts for hashCode() in Java

1. If two objects are equal by the equals() method then their hashcode returned by the hashCode() method must be the same.

2. Whenever the hashCode() method is invoked on the same object more than once within a single execution of the application, hashCode() must return the same integer provided no information or fields used in equals and hashcode is modified. This integer is not required to be the same during multiple executions of application though.

3. If two objects are not equaled by the equals() method it is not required that their hashcode must be different. Though it’s always good practice to return different hashCode for unequal object. Different hashCode for a distinct objects can improve the performance of hashmap or hashtable by reducing collision.

> Note: Things to remember while overriding hashcode in Java
>
> 1. Whenever you override the equals method, hashcode should be overridden to be in compliance with equals hashcode contract.
> 2. If you don't override hashCode() method properly your Object may not function correctly on hash-based collection e.g. HashMap, Hashtable or HashSet.

> Note: IntelliJ and Eclipse offer auto-generation for hashCode() and equals()

```java
ArrayList<Song> songs = new ArrayList<Song>();
// add songs to array list
// ...

// create HashSet from ArrayList:
HashSet<Song> songsSet = new HashSet<Song>();
songsSet.addAll(songs);

class Song {
    private String title;
    private String artist;
    private String rating;
    private String length;

    Song(String title, String artist, String rating, String length) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.length = length;
    }

    public boolean equals(Object song) {
        Song s = (Song) song;
        return s.getTitle().equals(title);
    }

    public int hashCode() {
        return title.hashCode();
    }
}
```

## Generics as method arguments

The problem:
using polymorphism with normal arrays throws an ArrayStoreException when inserting a Class that is not a sub-type of the refernece variable. This is only checked at runtime.

```java
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
        pets[0] = new Cat(); // raises java.lang.ArrayStoreException for array dogs (reference type is Dog[]!
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
```

The same example with ArrayList will not compile:

```java
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
```

So how to solve this? How to create a method `takePets()` that takes a Pet or their descendant classes?

_Solution:_ use Wildcards or `<T extends ParentClassOrInterface>`. `extend` can be applied to Classes and Interfaces here.

> Note: the Wildcard (or T extends X syntax) prevents the ArrayList to be altered, since we are not allowed to add Cats to a Dog ArrayList. But polymorphism for methods only accessing and not altering data works.

```java
public void takePet(ArrayList<? extends Pet> pets) {
   for(Pet p : pets)
           p.eat();
}
// or
public <T extends Pet> void takePet(ArrayList<T> pets) {
   for(Pet p : pets)
           p.eat();
}
```

## Static Imports

- whenever you use static classes, static variables or enumarations, you can import them and type less:

```java
import static java.lang.System.out;

class WithStatic {
    public static void main(String [] args) {
        out.println("test");
    }
}
```

## Access control

- final class: cannot be inherited from
- Order: `public -> protected -> default -> private`
- _public:_
  - a subclass inherits all public instance variables and methods
- _protected:_
  - subclasses can use, initiate, and use the protected class as a result, even if they are not in the same package.
- _default:_ (no access modifier) only classes in the same package can use the `class ABC`. Others cannot initiate, get the class as a result, or see the `default` class.
- _private:_
  - a subclass cannot access instance variables nor methods

| Access Modifier | within class | within package | outside package by subclass only | outside package |
| --------------- | ------------ | -------------- | -------------------------------- | --------------- |
| Private         | Y            | N              | N                                | N               |
| Default         | Y            | Y              | N                                | N               |
| Protected       | Y            | Y              | Y                                | N               |
| Public          | Y            | Y              | Y                                | Y               |

## JAR

- view content of a JAR file:

```shell
jar tf jar-file
```

- without MANIFEST.MF file, the complete classpath (`-cp`) to the main class has to be provided, e.g.

```shell
java -cp ex4Polymorphism-1.0-SNAPSHOT.jar com.polymorphism.app.App
```

## Stack and Heap

- Heap: objects and their instance variables are living in the heap
  - reference variables of objects live in the stack, the corresponding referenced objectes is still constructed in the heap and lives in the heap
- Stack: method calls and local variables live in the stack
