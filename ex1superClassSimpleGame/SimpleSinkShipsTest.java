package ex1superClassSimpleGame;

import java.util.Random;

class SimpleSinkShipsTest {
    public static void main(String[] args) {
        System.out.println("Test:");

        SimpleSinkShips simple_sink = new SimpleSinkShips();

        int[] array = { 2, 3, 4 };
        simple_sink.setArray(array);

        boolean okay = true;
        simple_sink.proof("2");
        okay &= simple_sink.isSunk() == false;

        simple_sink.proof("3");
        okay &= simple_sink.isSunk() == false;

        simple_sink.proof("6");
        okay &= simple_sink.isSunk() == false;

        simple_sink.proof("4");
        okay &= simple_sink.isSunk() == true;

        String outcome = "failed";
        if (okay)
            outcome = "successful";

        System.out.println("\tTest " + outcome);
    }
}

class SimpleSinkShips {

    private int places[] = new int[3];
    private int numberCorrectGuesses = 0;

    public static void main(String[] args) {

        int numberTips = 0;
        SimpleSinkShips simpleSinkShips = new SimpleSinkShips();
        Random r = new Random();
        int randomInt = r.nextInt(7 - 3);
        simpleSinkShips.setRandomArray(randomInt);

        boolean gameEnded = false;

        while (!gameEnded) {
            numberTips++;
            String userInput = GameHelper.getUserInput("Enter new number to guess: ");
            simpleSinkShips.proof(userInput);
            if(simpleSinkShips.isSunk()) {
                System.out.println("You sunk the ship");
                gameEnded = true;
            }           
        }

        System.out.print("Ship was located at: ");
        for(int i : simpleSinkShips.getArray()) {
            System.out.print(i + " ");
        }
        System.out.println("\nYour number of guesses: " + numberTips);
    }

    public void setRandomArray(int startOfArray) {
        for (int i = 0; i < this.places.length; i++)
            this.places[i] = startOfArray + i;
    }

    public void setArray(int[] values) {
        this.places = values;
    }

    public int[] getArray() { return this.places; }

    public void proof(String guess) {
        int guessInt = Integer.parseInt(guess);

        boolean found = false;
        for (int number : this.places) {
            if (number == guessInt) {
                found = true;
                System.out.println("  You hit the ship");
            }
        }

        if (found) {
            this.numberCorrectGuesses++;
        } else {
            System.out.println("  You missed");
        }
    }

    boolean isSunk() {
        if (this.numberCorrectGuesses == places.length)
            return true;
        else
            return false;
    }
}
