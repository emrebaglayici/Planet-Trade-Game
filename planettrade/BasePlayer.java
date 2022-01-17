package project.planettrade;

public abstract class BasePlayer {

    private String name;
    private double currentMoney;
    private Spaceship spaceship;
    private Planet currentPlanet;

    public BasePlayer(String name, double currentMoney) {
        this.name = name;
        this.currentMoney = currentMoney;
        this.spaceship = null;
        Planet planet = new Planet();
        this.currentPlanet = planet;
    }

    public String getName() {
        return name;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
        java.text.DecimalFormat twoPlaces = new java.text.DecimalFormat("0.00");
        System.out.println(name +  " adlı oyuncunun tutarı " +twoPlaces.format(currentMoney)+ " olarak güncellendi");
    }

    public Spaceship getSpaceship() {
        if (spaceship == null){
            return null;
        }
        return spaceship;
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
        System.out.println(name +  " adlı oyuncu "+ currentPlanet.getName() +" gezegenine seyahat etti");
    }

    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
        System.out.println(name +  " adlı oyuncu "+ spaceship.getName() +" uzay gemisini satın aldı");
    }

    @Override
    public String toString() {
        return "Player name: " + name + " current money: " + currentMoney + " current spaceship : " + spaceship + " current planet: " + currentPlanet;
    }
}
