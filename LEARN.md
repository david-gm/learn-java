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



# Classes and Objects:

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

# Casting

```java
int a = Integer.parseInt("25");
```