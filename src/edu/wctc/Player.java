package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int score;

    private List<String> inventory = new ArrayList<>();

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public String getInventory() {
        String inventoryList = "";
        if (inventory.size() != 0) {
            for (int i = 0; i < inventory.size(); i++) {
                inventoryList += inventory.get(i) + ", ";
            }
            return inventoryList.substring(0, inventoryList.trim().length() - 1);
        }
        return "You have nothing in your inventory.";
    }

    public void removeItem(String item) {
        for (int i = 0; i < inventory.size(); i++){
            if (inventory.get(i) == item){
                inventory.remove(item);
            }
        }
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }

    public void resetInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            inventory.remove(i);
        }
    }
}
