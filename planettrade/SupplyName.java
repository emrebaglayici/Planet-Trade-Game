package project.planettrade;

public enum SupplyName {
    Karpuz(1, 3, 8,0.2),
    Kavun(2, 6, 7,0.3),
    UzayErigi(3, 6, 7,0.5),
    UzayBirasi(4, 6, 7,0.2),
    Elma(5, 6, 7,0.7),
    Armut(6, 6, 7,0.9),
    Cilek(7, 6, 7,0.9),
    Ekmek(8, 6, 7,0.6),
    TulumPeynir(9, 6, 7,0.6),
    Raki(10, 6, 7,0.3),
    Haydari(11, 6, 7,0.5);

    private int id;
    private int buyPrice;
    private int sellPrice;
    private double decayRatio;

    SupplyName(int id, int buyPrice, int sellPrice, double decayRatio) {
        this.id = id;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.decayRatio = decayRatio;
    }

    public int getId() {
        return id;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public double getDecayRatio() {
        return decayRatio;
    }
}