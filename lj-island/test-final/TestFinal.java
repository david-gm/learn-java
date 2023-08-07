public class TestFinal {
    public static void main(String[] args) {
        TestFinal testFinal = new TestFinal();

        Value v = new Value();
        System.out.println(String.format("Value: %d", v.getVal()));

        testFinal.changeValue(v);

        System.out.println(String.format("Value: %d", v.getVal()));
    }

    void changeValue(final Value v) {
        v.setVal(23); // this works with final
        v = new Value(); // this is prevented
    }
}

class Value {
    private int val = 0;

    void setVal(int newVal) {
        this.val = newVal;
    }

    int getVal() { return this.val; }
}