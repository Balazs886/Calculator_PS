package main.cost;

import main.function.EarBottomCuttingFunction;

public class EarBottomCost {
    private Double earSheetQuantity;
    private Double bottomSheetQuantity;
    private Double earSheetPrice;
    private Double bottomSheetPrice;
    private EarBottomCuttingFunction earBottom;
    private int menu;
    private CostCalculatorFromSheet earCost;
    private CostCalculatorFromSheet bottomCost;


    public EarBottomCost(EarBottomCuttingFunction earBottom, Double earSheetPrice, Double bottomSheetPrice) {
        this.earBottom = earBottom;
        this.earSheetPrice = earSheetPrice;
        this.bottomSheetPrice = bottomSheetPrice;
        this.menu = earBottom.earBottomMenuChoice();
        this.earSheetQuantity = earBottom.getEarSheetQuantity();
        this.bottomSheetQuantity = earBottom.getBottomSheetQuantity();
        instance();
    }

    private void instance() {
        switch (menu) {
            case 1:
                earCost = new CostCalculatorFromSheet(earSheetQuantity, earSheetPrice);
                bottomCost = new CostCalculatorFromSheet(bottomSheetQuantity, bottomSheetPrice);
                break;
            case 2:
                earCost = new CostCalculatorFromSheet(earSheetQuantity, earSheetPrice);
                break;
            case 3:
                bottomCost = new CostCalculatorFromSheet(bottomSheetQuantity, bottomSheetPrice);
                break;
        }
    }

    @Override
    public String toString() {
        String msg = "";
        if (earCost != null) {
            msg += "Fül karton nettó költsége: " + earCost + "\n";
        }
        if (bottomCost != null) {
           msg += "Talp karton nettó költsége: " + bottomCost;
        }
        return msg;
    }
}
