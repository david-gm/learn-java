package ex1superClassSimpleGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHelper {

    public static String getUserInput(String msg) {

        try {
            System.out.println(msg);

            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            String input = is.readLine();

            if (input.length() > 0)
                return input;
            else
                return null;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
