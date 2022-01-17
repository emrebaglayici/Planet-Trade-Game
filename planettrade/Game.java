package project.planettrade;

import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements project.gameengine.base.Game {
    private int turn = 0;
    private List<Player> members = new ArrayList<>();


    public Game(Blackhole blackhole, Hangar hangar) {

    }

    public Game() {

    }


    public int getTurn() {
        return turn;
    }

    public List<Player> getMembers() {
        return members;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setMembers(List<Player> members) {
        this.members = members;
    }

    public void journey(BasePlayer player, Planet planet) {
        double fuelAmount = 0.0;

        fuelAmount = Math.abs(player.getCurrentPlanet().getLocation() - planet.getLocation()) * player.getSpaceship().getFuelUsage();

        if (fuelAmount <= player.getSpaceship().getCurrentFuel()) {
            player.setCurrentPlanet(planet);
            player.getSpaceship().spendFuel(fuelAmount);
            System.out.println("" + player + planet + " gezegenine yolculuk yaptı");

        } else {

            player.setCurrentMoney(player.getCurrentMoney() - player.getCurrentPlanet().getSpaceshipParkingPrice());
            System.out.println(player.getName() + " adlı oyuncu " + planet.getName() + " gezegenine seyahat ederken yakıtı bitti ve " + player.getCurrentPlanet().getSpaceshipParkingPrice() + " tutarında park ücreti ödedi");
        }
    }

    public void purchaseItem(BasePlayer player, Supply supply, int amount) {
        try {
            if ((player.getCurrentPlanet().getMarket().getItem(supply) == null)) {
                System.out.println("Market " + supply.getName() + " adlı ürüne sahip degil");
            } else if (player.getCurrentPlanet().getMarket().supplyAmount(supply) < amount) {
                System.out.println("Bu gezegende bu " + supply.getName() + " yeteri kadar yok.");
            } else if (player.getSpaceship().getCurrentCapacity() < amount * 20) {
                System.out.println("Geminin kapasitesi yeterli degil!");

            } else {
                player.getSpaceship().getCargo().addItem(supply, amount);
                player.getSpaceship().setCurrentCapacity(player.getSpaceship().getCurrentCapacity() - amount * 20);
                player.setCurrentMoney(player.getCurrentMoney() - (supply.getUnitSellPrice() * amount));
                player.getCurrentPlanet().getMarket().deleteSupply(supply, amount);
                System.out.println(amount + " adet " + supply.getName() + " alındı.");
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }

    }


    public void sellItem(BasePlayer player, Supply supply, int amount) {
        if (!(player.getSpaceship().getCargo().supplyExist(supply))) {
            System.out.println("Satılmak ıstenen " + supply.getName() + " bulunamadı!");
        } else if (player.getSpaceship().getCargo().getItem(supply).getCurrentSupplyAmount() < amount) {
            System.out.println("Satılmak istenen miktar kadar malımız yoktur");
        } else {
            player.getSpaceship().getCargo().deleteSupply(supply, amount);
            player.getSpaceship().setCurrentCapacity(player.getSpaceship().getCurrentCapacity() + amount * 20);
            player.setCurrentMoney(player.getCurrentMoney() + supply.getUnitBuyPrice() * amount);
            player.getCurrentPlanet().getMarket().addItem(supply, amount);

            System.out.println(amount + " adet " + supply.getName() + " satıldı.");

        }
    }

    public void buyFuel(BasePlayer player) {
        if (player.getSpaceship().getFuelCapacity() == player.getSpaceship().getCurrentFuel()) {
            System.out.println(player.getSpaceship().getName() + " adlı uzay gemisinin deposu doludur!");
        } else {
            double amount = 0.0;
            double money = 0.0;
            amount = player.getSpaceship().getFuelCapacity() - player.getSpaceship().getCurrentFuel();
            money = amount * (player.getCurrentPlanet().getUnitFuelPrice());
            player.getSpaceship().addFuel(amount);
            player.setCurrentMoney(player.getCurrentMoney() - money);
            System.out.println(player.getSpaceship().getName() + " adlı uzay gemisinin deposu " + amount + " miktarda dolduruldu");
        }
    }


    public void buySpaceShip(BasePlayer player, Hangar hangar) {
        Random random = new Random();
        int rnd = random.nextInt(hangar.sList.size());
        if (player.getSpaceship() != null)
            System.out.println("Artık bir uzay aracın mevcut !! \n");

        else {
            player.setSpaceship(hangar.sList.get(rnd));
            player.setCurrentMoney(player.getCurrentMoney() - hangar.sList.get(rnd).getSellPrice());
            return;
        }


    }


    @Override
    public boolean isOver() {
        BasePlayer player = getPlayerInfo();
        if (turn > 99) {
            System.out.println("OYUN BİTTİ");
            return true;
        } else {
            System.out.println(player.getName() + " adlı oyuncu " + (turn + 1) + ".TURA BAŞLADI");
            return false;
        }
    }

    @Override
    public void init(List<Player> players) {
        members = players;

    }


    @Override
    public GameContext getContext() {
        return null;
    }


    private BasePlayer getPlayerInfo() {

        return (BasePlayer) members.get(turn % members.size());
    }


    @Override
    public void update(Action action) {
        PlayerAction playerAction = checkAction(action);
        BasePlayer player = getPlayerInfo();
        Random random = new Random();

        switch (playerAction.getType()) {

            case Journey: {
                journey(player, new Planet());

                break;
            }
            case Buy: {

                purchaseItem(player, Supply.randomSupply(), random.nextInt(8) + 1);

                break;
            }
            case Sell: {

                sellItem(player, Supply.randomSupply(), random.nextInt(8) + 1);
                break;
            }
            case BuyFuel: {

                buyFuel(player);
                break;
            }
            case BuySpaceship: {

                buySpaceShip(player, new Hangar());
                break;
            }

            case NoAction:
                System.out.println("No Action");
                break;
        }
        turn++;

    }

    private PlayerAction checkAction(Action action) {
        if (action != null) {

            return (PlayerAction) action;
        }
        return null;

    }

    @Override
    public int minimumPlayerCount() {
        return 0;
    }

    @Override
    public int maximumPlayerCount() {
        return 10;
    }
}
