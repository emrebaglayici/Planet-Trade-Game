package project.planettrade;

public class Spaceship {
    private String name;
    private double sellPrice;
    private Cargo cargo;
    private int shipVolume;
    private int currentCapacity;
    private double speed;
    private double currentFuel;
    private double fuelCapacity;
    private double fuelUsage;
    private double secondHandBuyPrice;

    public  Spaceship(){

    }

    public static Spaceship createShip(String name, double sellPrice, int shipVolume, double speed, double fuelCapacity, double fuelUsage, double secondHandBuyPrice) {
        Spaceship ship = new Spaceship();

        ship.cargo = new Cargo();
        ship.name = name;
        ship.sellPrice = sellPrice;
        ship.shipVolume = shipVolume;
        ship.currentCapacity = shipVolume;
        ship.speed = speed;
        ship.fuelCapacity = fuelCapacity;
        ship.currentFuel = fuelCapacity;
        ship.fuelUsage = fuelUsage;
        ship.secondHandBuyPrice = secondHandBuyPrice;

        return ship;
    }

    public void addFuel(double fuel) {
        if ((currentFuel + fuel) <= fuelCapacity) {
            currentFuel += fuel;
        }
    }

    public void spendFuel(double amount) {

        currentFuel = currentFuel - amount;

    }


    @Override
    public String toString() {
        return name + " adlı gemi alındı..";
    }

    public void showItems() {
        System.out.println(name + " adlı oyuncunun sahip oldukları : ");
        for (int i = 0; i < cargo.getCargoList().size(); i++) {
            System.out.println(cargo.getCargoList().get(i));

        }

    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }


    public Cargo getCargo() {
        if (cargo.getCargoList() == null){
            System.out.println("Mevcut kargo yok!");
            return null;
        }
        return cargo;
    }

    public int getShipVolume() {
        return shipVolume;
    }

    public void setShipVolume(int shipVolume) {
        this.shipVolume = shipVolume;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public double getSecondHandBuyPrice() {
        return secondHandBuyPrice;
    }

    public void setSecondHandBuyPrice(double secondHandBuyPrice) {
        this.secondHandBuyPrice = secondHandBuyPrice;
    }
}
