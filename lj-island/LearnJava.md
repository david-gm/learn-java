# Learn Java (Java ist auch eine Insel)

## Chapter 3 - Classes and Objects

### final keyword

Using the final keyword for parameters of methods prevents:
- assigning a new reference to the paremeter
- does not prevent altering of the state of the object. 

```java
public class TestFinal {
    // ...
    void changeValue(final Value v) {
        v.setVal(23); // this works with final
        v = new Value(); // this is prevented by the compiler
    }
}

class Value {
    private int val = 0;
    void setVal(int newVal) { this.val = newVal; }
    int getVal() { return this.val; }
}
```

## Chapter 6 - Writing own classes

### final keyword

Members of classes that are declared final can only be set within the objects constructor and never after:

```java
public class City {
    public final String name;
    public City( Sting name ) { this.name = name; }
    public String getName() { return name; }
    // this would not compile:
    // void setName( String name) { this.name = name; }
}
```

### Wither Methods

Changing final members of a class can be implemented by providing withers: return a new instance of a class with new members:

```java
public class City {
    public final String name;
    public final int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public City withName( String name ) {
        return new City(name, this.population);
    }

    public City withPopulation( int population ) {
        return new City(this.name, population);
    }
}
```
## Chapter 8 - Interfaces, Enumerations, sealed classes, records

### Interfaces

Interfaces can contain:
- abstract methods
- private and public concrete methods (called default methods)
- private and public static methods
- constants (static variables): public static final can be ommited!
- enumerations

> Note: modifications `abstract` and `public` for methods can be omitted, since by default methods in interfaces are abstract and public.

```java
interface Buyable {
    int MAX_PRICE = 10_000_000;
    double prices();
}
```

### Subinterfaces

```java
interface Readable {
    int howManyLetters();
}

interface Book extends Readable {
    int howManyPages();
}
```

### Extending interfaces with default methods

Problem: interfaces define a behaviour. If the interfaces changes when several classes implemented the interface, then all these classes would need to be changed. The solution is to use `default methods`.

- the declaration of a default method begins with the keyword `default`
- instead of a semi-colon after the method declaration, default methods have a {} at the end

Original interface:
```java
interface EventLifecycle {
    void start();
    void finish();
}
```
After extending the interface:
```java
interface EventLifecycle {
    void start();
    void finish();
    default void pause() {};
}
```
> Advantage: classes that implemented the interface don't have to implement the new default method, but can override if they want to.

## Enumerations

```java
public enum Country {
    GERMANY, UK, CHINA
}
```

## Records

A record declaration specifies in a header a description of its contents; the appropriate accessors, constructor, equals, hashCode, and toString methods are created automatically. A record's fields are final because the class is intended to serve as a simple "data carrier".

For example, here is a record class with two fields:

```java
record Rectangle(double length, double width) { }
```
- a cononical (all members have to be initialized by parameters) constructor is automatically created
- A record can have object methods and static methods.

## Functional programming and Lambda Expressions

> Definition: functional interfaces are interfaces, that only have one operation (abstract method).

Some of the functional interfaces provided by the Java Standard Library:
```java
interface Runnable { void run(); }
interface Supplier<T> { T get(); }
interface Consumer<T> { void accept(T t); }
interface Comperator<T> { int compare(T o1, T o2); }
interface ActionListener { void actionPerformed(ActionEvent e); }
```

The type of the lambda expression is inferred by type-interference.

## Datastructures

- Lists:
    - ArrayList: stores data in Array, can change size
    - LinkedList: each element is only linked to its next neighbours; used for fast insertion and extraction; bad for searching elements
- Sets:
    - HashSet: fast implementation, similar to `set<T>` in C++
    - TreeSet: sets in binary tree
    - LinkedHashSet
- Maps:
    - HashMap: fast implementation, similar to `map<T,U>` in C++
    - TreeMap: slower in accessing the data, but the key elements are always sorted

```java
public class TestDataStructures {
    public static void main(String[] args) {
        testCreateNewList();
        testCreateNewArrayList();

        testHashMap();
    }

    private static void testCreateNewList() {
        List<Integer> fixedList = List.of(1, 2, 3);
        // fixedList.add(23); // NOTE: forbidden
        System.out.println(String.format("fixedList type: %s", fixedList.getClass().getName()));
    }

    private static void testCreateNewArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

        list.add(25);
        for (Integer i : list)
            System.out.println(String.format("%d %s", i, i.getClass()));
    }

    private static void testHashMap() {
        HashMap<Number, String> map = new HashMap<>();
        map.put(5, "cinco");
        map.put(2, "dos");
        
        BiConsumer<Number, String> print = (key, val) -> System.out.println(String.format("%d %s", key, val));
        map.forEach(print);
    }
}
```