package project.planettrade;

import java.util.Random;

public class Supply {
    private SupplyName name;
    private double currentSupplyAmount;
    private final int unitBuyPrice;
    private final int unitSellPrice;
    private final double decayRatio;

    Supply(SupplyName name) {
        this.name = name;
        this.currentSupplyAmount = 15.0;
        this.unitBuyPrice = name.getBuyPrice();
        this.unitSellPrice = name.getSellPrice();
        this.decayRatio = name.getDecayRatio();
    }

    Supply() {
        Supply s1 = randomSupply();
        this.name = s1.name;
        this.currentSupplyAmount = s1.currentSupplyAmount;
        this.unitSellPrice = s1.unitSellPrice;
        this.unitBuyPrice = s1.unitBuyPrice;
        this.decayRatio = s1.decayRatio;
    }


    public static Supply randomSupply() {
        Supply s1 = new Supply(SupplyName.Cilek);
        Random random = new Random();
        int temp = random.nextInt(maxId() + 1);
        int tAmount = random.nextInt(200 - 100) + 100;

        for (SupplyName at : SupplyName.values()) {
            if (at.getId() == temp) {
                s1.name = at;
                s1.currentSupplyAmount = tAmount;
            }
        }
        return s1;
    }


    public static int maxId() {
        int maxId = 0;
        for (SupplyName at : SupplyName.values()) {
            if (at.getId() > maxId) {
                maxId = at.getId();
            }
        }
        return maxId;
    }

    public int getUnitBuyPrice() {
        return unitBuyPrice;
    }

    public int getUnitSellPrice() {
        return unitSellPrice;
    }

    public SupplyName getName() {
        return name;
    }

    public void setName(SupplyName name) {
        this.name = name;
    }

    public double getCurrentSupplyAmount() {
        return currentSupplyAmount;
    }

    public void setCurrentSupplyAmount(int currentSupplyAmount) {
        this.currentSupplyAmount = currentSupplyAmount;
    }

    public String toString() {
        return "" + name + " " + currentSupplyAmount;
    }
}








