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
|---------|--------------|
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

## Static Imports

- whenever you use static clases, static variables or enumarations, you can import them and type less:

```java
import sttaic java.lang.System.out;

class WithStatic {
    public static void main(String [] args) {
        out.println("test");
    }
}
```

## Access control

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

## Stack and Heap

- Heap: objects and their instance variables are living in the heap
  - reference variables of objects live in the stack, the corresponding referenced objectes is still constructed in the heap and lives in the heap
- Stack: method calls and local variables live in the stack