package ex1superClassSimpleGame;

class SimpleSinkShipsTest {
    public static void main(String[] args) {
        System.out.println("Test:");

        SimpleSinkShips simple_sink = new SimpleSinkShips();

        int[] array = { 2, 3, 4 };
        simple_sink.setArray(array);

        boolean okay = true;
        okay &= simple_sink.checkInput(2) == true;
        simple_sink.proof(2);
        okay &= simple_sink.isSunk() == false;

        okay &= simple_sink.checkInput(3) == true;
        simple_sink.proof(3);
        okay &= simple_sink.isSunk() == false;

        okay &= simple_sink.checkInput(6) == true;
        simple_sink.proof(6);
        okay &= simple_sink.isSunk() == false;

        okay &= simple_sink.checkInput(4) == true;
        simple_sink.proof(4);
        okay &= simple_sink.isSunk() == true;

        String outcome = "failed";
        if (okay)
            outcome = "successful";

        System.out.println("\tTest " + outcome);
    }
}