package project.planettrade;
public class Planet {
    private final PlanetName name;
    private final double unitFuelPrice;
    private final double spaceshipParkingPrice;
    private Market market;
    private final int location;

    Planet(PlanetName name, double unitFuelPrice, double spaceshipParkingPrice) {
        this.name = name;
        this.unitFuelPrice = unitFuelPrice;
        this.spaceshipParkingPrice = spaceshipParkingPrice;
        market = MarketGenerator.createMarket("--Tekel--");
        this.location = name.getLocation();
    }

    Planet() {
        PlanetName object = PlanetName.randomGetPlanet();
        this.name = object;
        this.unitFuelPrice = object.getUnitFuelPrice();
        this.spaceshipParkingPrice = object.getSpaceshipParkingPrice();
        this.location = object.getLocation();
        market = MarketGenerator.createMarket(this.name +" Marketi");
    }
    Planet(PlanetName name) {

        this.name = name ;
        this.unitFuelPrice = name.getUnitFuelPrice();
        this.spaceshipParkingPrice = name.getSpaceshipParkingPrice();
        this.location = name.getLocation();
        market = MarketGenerator.createMarket(this.name +" Marketi");
    }


    public PlanetName getName() {
        return name;
    }

    public double getUnitFuelPrice() {
        return unitFuelPrice;
    }

    public double getSpaceshipParkingPrice() {
        return spaceshipParkingPrice;
    }

    public Market getMarket() {
        return market;
    }

    public int getLocation() {
        return location;
    }

    public String toString() {
        return "" + name;
    }
}
