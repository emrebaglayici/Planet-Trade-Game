package project.planettrade;

import java.util.ArrayList;

public class Hangar {

    ArrayList<Spaceship> sList;


    public Hangar() {
        sList = new ArrayList<>();


        sList.add(Spaceship.createShip("StarStar", 60, 1000, 5, 200, 20, 30));
        sList.add(Spaceship.createShip("StarTuran", 80, 1200, 8, 200, 15, 50));
        sList.add(Spaceship.createShip("StarKeklik", 100, 1500, 9, 330, 15, 55));
        sList.add(Spaceship.createShip("StarBaykuş", 150, 1500, 9, 180, 10, 55));
        sList.add(Spaceship.createShip("StarFalcon", 80, 1200, 8, 3000, 12, 50));
        sList.add(Spaceship.createShip("StarBitShip", 130, 2000, 5, 2000, 16, 65));
        sList.add(Spaceship.createShip("StarRaven", 170, 2500, 3, 1400, 20, 75));
        sList.add(Spaceship.createShip("StarAtlas", 200, 3000, 2, 2200, 15, 84));
        sList.add(Spaceship.createShip("StarEtherium", 100, 1300, 1, 1330, 20, 45));
        sList.add(Spaceship.createShip("StarWolf", 120, 1230, 6, 1500, 18, 85));
        sList.add(Spaceship.createShip("StarCat", 130, 1400, 8, 1700, 22, 35));
        sList.add(Spaceship.createShip("StarLynx", 155, 1907, 7, 1800, 13, 55));
        sList.add(Spaceship.createShip("StarBear", 144, 1881, 3, 1900, 17, 65));
        sList.add(Spaceship.createShip("StarLion", 152, 1923, 1, 1100, 11, 66));


    }


    public void addShip(Spaceship spaceship) {
        sList.add(spaceship);
    }

}
