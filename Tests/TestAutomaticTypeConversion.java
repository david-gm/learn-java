public class TestAutomaticTypeConversion {
    private static double calcMean(int... values) {
        int sum = 0;
        for(int v : values)
            sum += v;
        
        return (double)sum / values.length;
    }

    public static void main(String[] args) {
        System.out.println(calcMean(4,5,6,7,8,9));
    }
}