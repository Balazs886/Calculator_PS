package main.function;

import main.size.EarBottomCuttingPlan;
import main.size.PaperSheet;

public class EarBottomCuttingFunction extends Menu {
    private PaperSheet earCardboard;
    private PaperSheet bottomCardboard;
    private EarBottomCuttingPlan earCuttingPlan;
    private EarBottomCuttingPlan bottomCuttingPlan;
    private int earBottomMenuChoice = menuEarBottomInput();
    private Integer bagsQuantity;
    private String msg = "";

    public EarBottomCuttingFunction(Integer bagsQuantity) {
        this.bagsQuantity = bagsQuantity;
        menuEarBottomGiveDatas();
        menuEarBottomInstances();
    }

    public int earBottomMenuChoice() {
        return earBottomMenuChoice;
    }

    public void menuEarBottomInstances() {
        switch (earBottomMenuChoice) {
            case 1:
                instanceEar(bagsQuantity * 2);
                instanceBottom(bagsQuantity);
                break;
            case 2:
                instanceBottom(bagsQuantity);
                break;
            case 3:
                instanceEar(bagsQuantity * 2);
                break;
            default:
                System.out.println("Nem várt hiba történt.");
                break;
        }
    }

    private String instanceEar(int earQuantity) {
        earCuttingPlan = new EarBottomCuttingPlan(earCardboard, earQuantity);
        earCuttingPlan.calculator();
        msg += "Szükséges fülkarton: " + earCuttingPlan;
        return msg;
    }

    private String instanceBottom(int bottomQuantity) {
        bottomCuttingPlan = new EarBottomCuttingPlan(bottomCardboard, bottomQuantity);
        bottomCuttingPlan.calculator();
        msg += "\nSzükséges talpkarton: " + bottomCuttingPlan;
        return msg;
    }

    public Double getEarSheetQuantity() {
        return earCuttingPlan.calculator();
    }

    public Double getBottomSheetQuantity() {
        return bottomCuttingPlan.calculator();
    }

    public void menuEarBottomGiveDatas() {
        switch (earBottomMenuChoice) {
            case 1:
                earCardboard = new PaperSheet("Add meg a fülkarton adatait: ");
                System.out.println();
                bottomCardboard = new PaperSheet("Add meg a talpkarton adatait: ");
                break;
            case 2:
                bottomCardboard = new PaperSheet("Add meg a talpkarton adatait: ");
                break;
            case 3:
                earCardboard = new PaperSheet("Add meg a fülkarton adatait: ");
                break;
            default:
                System.out.println("Nem várt hiba történt.");
        }
    }

    public int menuEarBottomInput() {
        System.out.println("Mit szeretnél kalkulálni?\n" +
                "1. Talp és fül\n" +
                "2. Talp\n" +
                "3. Fül");
        return userMenuInput(1, 3);
    }

    @Override
    public String toString() {
        return msg;
    }
}


