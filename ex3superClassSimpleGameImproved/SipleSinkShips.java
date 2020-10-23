package ex3superClassSimpleGameImproved;

import java.util.Random;
import java.util.ArrayList;

class SimpleSinkShips {

    private ArrayList<Integer> places = new ArrayList<Integer>();
    private static int MAX_PLACES_SIZE = 3;
    private static int MAX_GUESS_NUM = 7;
    private static int MIN_GUESS_NUM = 1;

    public static void main(String[] args) {

        int numberTips = 0;
        SimpleSinkShips simpleSinkShips = new SimpleSinkShips();
        Random r = new Random();
        int randomInt = r.nextInt(7 - 3);
        simpleSinkShips.setRandomArray(randomInt);

        for(Integer i : simpleSinkShips.getArray())
            System.out.println(i);

        boolean gameEnded = false;

        while (!gameEnded) {
            
            String userInput = GameHelper.getUserInput("Enter new number to guess: ");
            Integer guessInt = Integer.parseInt(userInput);
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

    public void setRandomArray(Integer startOfArray) {
        for (int i = 0; i < MAX_PLACES_SIZE; i++)
            this.places.add(startOfArray + Integer.valueOf(i));
    }

    public void setArray(ArrayList<Integer> values) {
        this.places = values;
    }

    public ArrayList<Integer> getArray() {
        return this.places;
    }

    public boolean checkInput(int guessInt) {
        if (guessInt < MIN_GUESS_NUM || guessInt > MAX_GUESS_NUM) {
            System.out.println("Number has to be between " + MIN_GUESS_NUM + " and " + MAX_GUESS_NUM);
            return false;
        }
        return true;
    }

    public void proof(Integer guessInt) {
        if(this.places.contains(guessInt)) {
            this.places.remove(this.places.indexOf(guessInt));
            System.out.println("  You hit the ship");
        }
        else {
            System.out.println("  You missed");
        }
    }

    boolean isSunk() {
        return this.places.isEmpty();
    }
}
