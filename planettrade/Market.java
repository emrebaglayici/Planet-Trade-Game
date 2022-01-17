package project.planettrade;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Market {
    private String name;
    private ArrayList<Supply> itemList;

    public Market(String name) {
        this.name = name;
        itemList = new ArrayList<>();
        randomMarketCreator();

    }

    public void deleteSupply(Supply supply, int amount) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName() == supply.getName()) {
                itemList.get(i).setCurrentSupplyAmount((int) (itemList.get(i).getCurrentSupplyAmount() - amount));
            }
        }
    }

    public Optional<Supply> getItem(Supply supply)
    {
        Stream<Supply> stream = itemList.stream();

        return stream.filter((x) -> x.getName() == supply.getName()).findFirst();

    }

    public boolean supplyExist(Supply supply) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName() == supply.getName()) {
                return true;
            }
        }
        return false;
    }

    public void randomMarketCreator() {
        Random random = new Random();
        int temp = random.nextInt((Supply.maxId() + 1) - 2) + 2;

        for (int i = 0; i < temp; i++) {
            Supply s1 = Supply.randomSupply();
            if (!supplyExist(s1))
                itemList.add(s1);

        }
    }

    public int supplyAmount(Supply supply) {
        int amount = 0;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName() == supply.getName()) {
                amount = (int) itemList.get(i).getCurrentSupplyAmount();
            }
        }
        return amount;
    }

    public void addItem(Supply supply, int amount) {
        if (supplyExist(supply)) {
            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).getName() == supply.getName()) {
                    itemList.get(i).setCurrentSupplyAmount((int) (itemList.get(i).getCurrentSupplyAmount() + amount));
                }
            }
        } else {

            Supply s1 = new Supply(supply.getName());
            s1.setCurrentSupplyAmount(amount);
            itemList.add(s1);

        }

    }

    public void showItems() {
        System.out.println(name + " adlı oyuncunun sahip oldukları : ");

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }


    }


    public String getName() {
        return name;
    }

    public ArrayList<Supply> getItemList() {
        return itemList;
    }


    public String toString() {
        String st = this.name + "\n";

        for (Supply supply : itemList) {
            st += supply.toString() + "\n";

        }
        return st;
    }
}
