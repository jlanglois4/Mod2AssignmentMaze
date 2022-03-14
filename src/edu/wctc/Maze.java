package edu.wctc;

import edu.wctc.Interfaces.Exitable;
import edu.wctc.Interfaces.Interactable;
import edu.wctc.Interfaces.Lootable;
import edu.wctc.Rooms.*;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished = false;

    private Stucia stucia;
    private AdventurersGuild ag;
    private Tavern tavern;
    private AGBasement agBasement;

    public Maze(Player player){
        this.player = player;

        stucia = new Stucia("Stucia.");
        ag = new AdventurersGuild("the Adventurer Guild.");
        tavern = new Tavern("the Drunken Rat.");
        agBasement = new AGBasement("the Adventurer Guild's Basement.");


        // North
        stucia.setNorth(tavern);

        // South
        tavern.setSouth(stucia);

        // East
        stucia.setEast(ag);

        // West
        ag.setWest(stucia);

        // Up
        agBasement.setUp(ag);

        // Down
        ag.setDown(agBasement);
    }

    public String exitCurrentRoom(){
        if (currentRoom instanceof Exitable){
            Exitable exitable = (Exitable) currentRoom;
            isFinished = true;
            return exitable.exit(player);
        } else
            return "This room has no exit.";
    }

    public String getCurrentRoomName(){
        return currentRoom.getName();
    }

    public String getCurrentRoomDescription(){
        return currentRoom.getDescription();
    }

    public String interactWithCurrentRoom(){
        if (currentRoom instanceof Interactable){
            Interactable interactable = (Interactable) currentRoom;
            return interactable.interact(player);
        } else
            return "There is nothing of interest to interact with.";
    }

    public String getCurrentRoomExits(){
        return currentRoom.getExits();
    }

    public String lootCurrentRoom(){
        if (currentRoom instanceof Lootable){
            Lootable lootable = (Lootable) currentRoom;
            return lootable.loot(player);
        } else
            return "There is nothing of interest to loot.";
    }

    public boolean move(char move){
        if (currentRoom.isValidDirection(move)){
           currentRoom = currentRoom.getAdjoiningRoom(move);
           return true;
        }
        System.out.println(" but there is nothing that way.");
        return false;
    }

    public int getPlayerScore(){
        return player.getScore();
    }

    public String getPlayerInventory(){
        return player.getInventory();
    }

    public boolean isFinished(){
        return isFinished;
    }

    public void restartMaze(){
        player.resetInventory();
        player.resetScore();
        stucia.resetRoom();
        agBasement.resetRoom();
        tavern.resetRoom();
        currentRoom = stucia;
        isFinished = false;
    }

}