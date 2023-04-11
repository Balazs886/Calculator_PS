package main.size;

import static main.Main.scanner;

public class PaperSheet {
    private double width;
    private double height;

    public PaperSheet(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public PaperSheet(String msg) {
        giveThisDatasOfThePaper(msg);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    protected void giveThisDatasOfThePaper(String msg) {
        System.out.println(msg);
        this.width = giveThisEdgeOfThePaper("szélességet");
        this.height = giveThisEdgeOfThePaper("magasságot");
    }

    private Double giveThisEdgeOfThePaper(String edgeMsg) {
        Double x = null;
        do {
            if (x == null) {
                System.out.print("Add meg a " + edgeMsg + " (cm): ");
            } else {
                System.out.println("Helytelen értéket adtál meg.");
            }
            x = scanner.nextDouble();
        } while (x < 0 || x > Double.MAX_VALUE);
        return x;
    }
}
