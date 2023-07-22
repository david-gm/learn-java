package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;


public class Collections {
    public static void main(String[] args) {
        testHashMap();
        testHashSet();

        testSort();
    }

    private static void testHashMap() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();// Creating HashMap
        map.put(1, "Mango"); // Put elements in Map
        map.put(2, "Apple");
        map.put(3, "Banana");
        map.put(4, "Grapes");

        System.out.println("----\nIterating Hashmap...");

        // Map.Entry is similar to C++ pair<>
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    private static void testHashSet() {
        HashSet<String> set = new HashSet<String>();
        set.add("D");
        set.add("B");
        set.add("E");
        set.add("A");

        System.out.println("----\nIterationgHashSet");
        for(var i : set) {
            System.out.println(i);
        }
    }

    private static void testSort() {

        System.out.println("----\nTest Sort");
        JukeBox jb = new JukeBox();
        jb.run();
    }

}


