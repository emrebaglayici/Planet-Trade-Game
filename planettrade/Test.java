package project.planettrade;

import project.gameengine.TurnBasedGameEngine;

public class Test {
    public static void main(String[] args) {

        Game planetTradeGame=new Game(new Blackhole(new Supply()),new Hangar());
        TurnBasedGameEngine gameEngine=new TurnBasedGameEngine(planetTradeGame,new GameRender());

        gameEngine.addPlayer(new DummyPlayer("Berkay",5000));
        gameEngine.addPlayer(new DummyPlayer("Emre",5000));
        gameEngine.addPlayer(new DummyPlayer("Alperen",5000));

       gameEngine.playARound();


    }
}

