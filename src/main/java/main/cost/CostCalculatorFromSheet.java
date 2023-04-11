package main.cost;

import java.util.Formatter;

public class CostCalculatorFromSheet {
    private Double sheetQuantity;
    private final Double sheetPrice;

    public CostCalculatorFromSheet(Double sheetQuantity, Double sheetPrice) {
        this.sheetQuantity = sheetQuantity;
        this.sheetPrice = sheetPrice;
    }

    private Double getNetPrice() {
        return Math.ceil(sheetQuantity) * sheetPrice;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%.0f", getNetPrice());
        return formatter + " Ft";
    }
}
