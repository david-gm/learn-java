package com.polymorphism.animal.herb;

import com.polymorphism.animal.Herbivore;
import com.polymorphism.animal.IPet;

public class Mouse extends Herbivore implements IPet {
    public Mouse(String name) {
        super(name);
    }

    public void sing() {
        System.out.println(String.format("%s [%s] sings", this.getName(), this.getType()));
    }
}
