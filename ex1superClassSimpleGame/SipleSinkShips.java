package ex1superClassSimpleGame;

import java.util.Random;

class SimpleSinkShips {

    private int places[] = new int[3];
    private int numberCorrectGuesses = 0;
    private static int MAX_GUESS_NUM = 7;
    private static int MIN_GUESS_NUM = 1;

    public static void main(String[] args) {

        int numberTips = 0;
        SimpleSinkShips simpleSinkShips = new SimpleSinkShips();
        Random r = new Random();
        int randomInt = r.nextInt(7 - 3);
        simpleSinkShips.setRandomArray(randomInt);

        boolean gameEnded = false;

        while (!gameEnded) {
            
            String userInput = GameHelper.getUserInput("Enter new number to guess: ");
            int guessInt = Integer.parseInt(userInput);
            if (!simpleSinkShips.checkInput(guessInt))
                continue;
            
            numberTips++;
            simpleSinkShips.proof(guessInt);
            if (simpleSinkShips.isSunk()) {
                System.out.println("You sunk the ship");
                gameEnded = true;
            }
        }

        System.out.print("Ship was located at: ");
        for (int i : simpleSinkShips.getArray()) {
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

    public int[] getArray() {
        return this.places;
    }

    public boolean checkInput(int guessInt) {
        if (guessInt < MIN_GUESS_NUM || guessInt > MAX_GUESS_NUM) {
            System.out.println("Number has to be between " + MIN_GUESS_NUM + " and " + MAX_GUESS_NUM);
            return false;
        }
        return true;
    }

    public void proof(int guessInt) {
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
