package project.planettrade;

import org.jetbrains.annotations.NotNull;
import project.gameengine.TurnBasedGameEngine;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

import java.util.ArrayList;

public class GameInfo implements GameContext {
    public GameInfo() {
    }




    public void showPlayerInfo(@NotNull BasePlayer player) {
        System.out.println(player.toString());
    }


}
