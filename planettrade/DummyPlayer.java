package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import java.util.Random;

public class DummyPlayer extends BasePlayer implements Player {


    public DummyPlayer(String name, double currentMoney) {
        super(name, currentMoney);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Action play(GameContext context) {

        Random random = new Random();
        int temp = random.nextInt(6 - 1);


        if (this.getSpaceship() == null) {
            System.out.println("Suan " + getName() + " adlı oyuncunun uzay gemisi yok");
            return new PlayerAction(4);
        }

        if (temp==0)
            return new PlayerAction(5);


        else if (temp == 1) {
            return new PlayerAction(1);
        }
        if (temp == 2)
            if (this.getSpaceship().getCurrentCapacity() <= this.getSpaceship().getShipVolume() * 0.20 && temp == 1)
                return new PlayerAction(2);

        if (temp == 3)
            return new PlayerAction(3);


        return new PlayerAction(0);

    }

    @Override
    public void prepareForGame(GameContext context) {

    }
}



