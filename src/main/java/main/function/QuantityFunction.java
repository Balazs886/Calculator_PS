package main.function;

import static main.Main.scanner;

public class QuantityFunction {

    private Integer quantity;

    public Integer getQuantity() {
        if (quantity == null) {
            quantity = giveTheQuantityOfTheBags();
        }
        return quantity;
    }

    private Integer giveTheQuantityOfTheBags() {
        Integer quantity = null;
        do {
            System.out.println("Kérlek add meg hány darab táskát kell szállítani.");
            if (quantity != null) {
                System.out.println("Hibás adatot adtál meg, kérlek figyelj!");
            }
            quantity = scanner.nextInt();
        } while (quantity < 1 || quantity > Integer.MAX_VALUE);
        return quantity;
    }
}
