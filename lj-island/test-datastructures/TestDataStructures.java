import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.ArrayList;

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