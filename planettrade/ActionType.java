package project.planettrade;

public enum ActionType {
    Journey(0),
    Buy(1),
    Sell(2),
    BuyFuel(3),
    BuySpaceship(4),
    NoAction(5);


    private int actionID;

    ActionType(int actionID) {
        this.actionID = actionID;
    }
}
