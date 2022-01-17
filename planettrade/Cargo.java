package project.planettrade;

import java.util.ArrayList;

public class Cargo {
    private ArrayList<Supply> cargoList;


    public Cargo() {
        cargoList = new ArrayList<>();
    }

    public void totalQuantity() {
        int total = 0;
        for (int i = 0; i < cargoList.size(); i++) {
            total += cargoList.get(i).getCurrentSupplyAmount();
        }

        System.out.println("Total quantitiy : " + total);
    }

    public Supply getItem(Supply supply) {
        for (int i = 0; i < cargoList.size(); i++) {
            if (cargoList.get(i).getName() == supply.getName()) {
                return supply;
            }
        }
        return null;
    }

    public boolean supplyExist(Supply supply) {
        for (int i = 0; i < cargoList.size(); i++) {
            if (cargoList.get(i).getName() == supply.getName()) {
                return true;
            }
        }
        return false;
    }


    public void addItem(Supply supply, int amount) {
        if (supplyExist(supply)) {
            for (int i = 0; i < cargoList.size(); i++) {
                if (cargoList.get(i).getName() == supply.getName()) {
                    cargoList.get(i).setCurrentSupplyAmount((int) (cargoList.get(i).getCurrentSupplyAmount() + amount));
                }
            }
        } else {

            Supply s1 = new Supply(supply.getName());
            s1.setCurrentSupplyAmount(amount);
            cargoList.add(s1);

        }

    }

    public void deleteSupply(Supply supply, int amount) {
        for (int i = 0; i < cargoList.size(); i++) {
            if (cargoList.get(i).getName() == supply.getName()) {
                cargoList.get(i).setCurrentSupplyAmount((int) (cargoList.get(i).getCurrentSupplyAmount() - amount));
            }
        }
    }


    public ArrayList<Supply> getCargoList() {
        if (cargoList == null) {
            System.out.println("Mevcut cargo yok!");
            return null;
        }
        return cargoList;
    }


}
