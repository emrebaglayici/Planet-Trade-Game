package project.planettrade;

import java.util.Random;

public enum PlanetName {
    Merkur(2, 5.3, 5.1),
    Venus(5, 2.3, 5.1),
    Dunya(6, 6.3, 5.1),
    Mars(12, 2.3, 5.1),
    Jupiter(10, 2.3, 5.1),
    Saturn(20, 1.3, 5.1),
    Uranus(25, 2.3, 5.1),
    Neptun(22, 2.3, 5.1);

    private final int location;
    private final double unitFuelPrice;
    private final double spaceshipParkingPrice;

    PlanetName(int location, double unitFuelPrice, double spaceshipParkingPrice) {
        this.location = location;
        this.unitFuelPrice = unitFuelPrice;
        this.spaceshipParkingPrice = spaceshipParkingPrice;
    }

    public static PlanetName randomGetPlanet() {

        Random random = new Random();
        int pick = random.nextInt(PlanetName.values().length);

        return PlanetName.values()[pick];
    }

    public int getLocation() {
        return location;
    }

    public double getUnitFuelPrice() {
        return unitFuelPrice;
    }

    public double getSpaceshipParkingPrice() {
        return spaceshipParkingPrice;
    }
}
