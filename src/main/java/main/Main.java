package main;

import main.cost.EarBottomCost;
import main.function.EarBottomCuttingFunction;
import main.function.QuantityFunction;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        welcome();
        QuantityFunction quantityMenu = new QuantityFunction();
        int quantity = quantityMenu.getQuantity();

        EarBottomCuttingFunction earBottom = new EarBottomCuttingFunction(quantity);

        System.out.println("\n----- Vágási terv -----");
        System.out.println(earBottom);

        System.out.println("\n----- Költségek -----");

        EarBottomCost earBottomCost = new EarBottomCost(earBottom, 150D, 90D);
        System.out.println(earBottomCost);

        scanner.close();
    }

    private static void welcome() {
        System.out.println("Üdvözöllek a talp - fül kalkulátor programban.");
    }
}
