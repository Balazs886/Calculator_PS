package main.size;

import java.util.Formatter;

public class EarBottomCuttingPlan implements CuttingPlan {
    private PaperSheet sliceSheet = new PaperSheet(0, 0);
    private PaperSheet sourcePaper = new PaperSheet(100, 70);
    private Double sheetsQuantity = calculator();
    private String msg;
    private int quantity;
    private String logic;
    private Double variable1;
    private Double variable2;


    public EarBottomCuttingPlan(PaperSheet paperSheet, int quantity) {
        this.sliceSheet = paperSheet;
        this.quantity = quantity;
    }

    @Override
    public Double calculator() {
        variable1 = Math.floor(sourcePaper.getWidth() / sliceSheet.getWidth()) * Math.floor(sourcePaper.getHeight() / sliceSheet.getHeight());
        variable2 = Math.floor(sourcePaper.getWidth() / sliceSheet.getHeight()) * Math.floor(sourcePaper.getHeight() / sliceSheet.getWidth());

        logic = logicChooser();

        if (logic.equals("logic1")) {
            sheetsQuantity = quantity / variable1;
            msg = sourcePaper.getWidth() + " / " + sliceSheet.getWidth() + " | " + sourcePaper.getHeight() + " / " + sliceSheet.getHeight();
        } else {
            sheetsQuantity = quantity / variable2;
            msg = sourcePaper.getWidth() + " / " + sliceSheet.getHeight() + " | " + sourcePaper.getHeight() + " / " + sliceSheet.getWidth();
        }
        return sheetsQuantity;
    }

    private String logicChooser() {
        if (Math.ceil(variable1) >= Math.ceil(variable2)) {
            return "logic1";
        } else {
            return "logic2";
        }
    }

    private Double cuttedQuantity() {
        if (logic.equals("logic1")) {
           return Math.ceil(sheetsQuantity) * variable1;
        } else {
            return Math.ceil(sheetsQuantity) * variable2;
        }
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%.2f", sheetsQuantity);
        return Math.ceil(sheetsQuantity) + " (" + formatter + ")" + " | " + msg + " | Vágott mennyiség: " + cuttedQuantity() + " db";
    }
}
