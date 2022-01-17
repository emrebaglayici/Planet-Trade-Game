package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

public class IntelligentPlayer extends BasePlayer implements Player {

    public IntelligentPlayer(String name, double currentMoney) {
        super(name, currentMoney);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Action play(GameContext context) {
        return null;
    }

    @Override
    public void prepareForGame(GameContext context) {

    }
}
