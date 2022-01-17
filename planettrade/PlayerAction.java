package project.planettrade;
public class PlayerAction implements project.gameengine.base.Action {

    private int type;


    public PlayerAction(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String st = "";

        switch (type) {
            case 0:
                st = "Journey";
                break;

            case 1:
                st = "Buy";
                break;

            case 2:
                st = "Sell";
                break;

            case 3:
                st = "BuyFuel";
                break;

            case 4:
                st = "BuySpaceship";
                break;

            case 5:
                st = "NoAction";
                break;
        }


        return st;


    }

    ;

    public ActionType getType() {

        switch (type) {
            case 0:
                return ActionType.Journey;

            case 1:
                return ActionType.Buy;

            case 2:
                return ActionType.Sell;

            case 3:
                return ActionType.BuyFuel;

            case 4:
                return ActionType.BuySpaceship;

            case 5:
                return ActionType.NoAction;


        }

        return null;
    }
}
