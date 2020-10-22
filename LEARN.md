# JAVA

## Arrays:

```java
// initialization:
Dog[] allPets;
allPets = new Dog[7];
allPets[0] = new Dog();
allPets[1] = new Dog();
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