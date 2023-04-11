package main.function;

import static main.Main.scanner;

public class Menu {

    protected int userMenuInput(int min, int max) {
        Integer userInput = null;
        do {
            if (userInput != null) {
                System.out.println("Helytelen értéket adtál meg!");
            }
            userInput = scanner.nextInt();
        } while (userInput < min || userInput > max);
        return userInput;
    }
}
