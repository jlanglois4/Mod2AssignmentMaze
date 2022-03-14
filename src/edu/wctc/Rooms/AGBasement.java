package edu.wctc.Rooms;

import edu.wctc.Interfaces.Exitable;
import edu.wctc.Interfaces.Interactable;
import edu.wctc.Interfaces.Lootable;
import edu.wctc.Player;

import java.util.List;

public class AGBasement extends Room implements Interactable, Lootable, Exitable {

    boolean canExit = false;
    boolean potion = false;

    public AGBasement(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        if (canExit) {
            return "[A dimly lit, but well decorated basement filled with various monster related tomes and trophies.]\n[The Dwarvish officer seems content to enjoy his ale, barely paying attention to anything going on.]";
        }
        return "[A dimly lit, but well decorated basement filled with various monster related tomes and trophies.]\n[There are at least twenty other adventurer's in the room all staring at a rough and mean-looking dwarf wearing an Adventurer Guild Officer badge.]\n[The dwarf seems to be considering his options.]";
    }

    @Override
    public String interact(Player interact) {
        boolean hasBeer = interact.getInventory().contains("Dwarvish Beer");
        interact.removeItem("Dwarvish Beer");
        if (hasBeer) {
            canExit = true;
            interact.addToScore(15);
            return "The dwarf announces that he only needs five adventurer's to go take care of some bandits and picks them at random.\nLuckily, you wave a Dwarvish Beer in front of him.\nHe grins and picks you and four others. The room empties quickly as those not chosen grumble and leave.\n" +
                    "You can now exit with the others to go on your quest.\n";
        }
        if (canExit) {
            return "You attempt to speak with the dwarf, but he studiously ignores you and the others with you.\n";
        }
        return "It seems the dwarf is taking a long time to choose. Perhaps there was a way you could stand out amongst the crowd?\n";
    }

    @Override
    public String exit(Player exit) {
        if (canExit) {
            exit.addToScore(10);
            return "You leave the Guild in the company of four other Adventurer's to slay some bandits.\n";
        }
        return "You take a look around and get dejected at all the possible candidates and leave before you could be chosen to go.\n";
    }

    @Override
    public String loot(Player loot) {

        if (!potion){
            potion = true;
            loot.addToScore(15);
            loot.addToInventory("Healing potion");
            return "You pick up a healing potion.\n";
        }

        return "There is nothing to loot here.\n";

    }

    public void resetRoom() {
        canExit = false;
        potion = false;
    }
}
