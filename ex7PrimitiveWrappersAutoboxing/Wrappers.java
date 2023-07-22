import java.util.ArrayList;

public class Wrappers {
    public static void main(String[] args) {
        int i = 288;
        System.out.println("int i: " + i);
        
        Integer iI = Integer.valueOf(i); // wrapping
        System.out.println("Integer iI: " + iI);
        
        int i_new = iI.intValue(); // unwrapping
        System.out.println("int i_new: " + i_new);

        //ArrayList<int> abc = new ArrayList<int>(); // Not allowed!
        ArrayList<Integer> abc = new ArrayList<Integer>();

        abc.add(1);
        abc.add(2);
        abc.add(3);

        for (var iLoop : abc) {
            System.out.println(String.format("in loop: %d [%s]", iLoop, iLoop.getClass().toString()));
        }

        for (int iLoop: abc) {
            System.out.println(String.format("[%s]", typeof(iLoop)));
            System.out.println(String.format("[%s]", ((Object)iLoop).getClass().toString())); // Autoboxing with cast int to Object -> Integer
        }
    }

    public static Class<Integer> typeof(final int val)
    {
        return Integer.TYPE;
    }
}