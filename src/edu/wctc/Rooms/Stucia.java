package edu.wctc.Rooms;

import edu.wctc.Interfaces.Interactable;
import edu.wctc.Interfaces.Lootable;
import edu.wctc.Player;

public class Stucia extends Room implements Interactable, Lootable {

    boolean sword = false;
    boolean goblin = false;

    public Stucia(String name) {
        super(name);
    }

    @Override
   public String getDescription() {
        return "[A bustling city filled with many people from many different races.]\n[You can hear the ringing of bells coming from the Adventurer's Guild to the east, signalling work.]\n[To the north is a dirty-looking tavern with a rat on it's sign.]";
    }

    @Override
    public String interact(Player interact) {

        if(!sword && !goblin){
            interact.addToScore(-25);
            return "You wander around the city and into an alleyway. A goblin leaps out from behind a crate and beats you up.\n";
        }
        if(sword && !goblin){
            interact.addToScore(25);
            goblin = true;
            return "You wander around the city and into an alleyway.\nA goblin leaps out from behind a crate and you slay it with your Old Rusty Sword as it attempts to attack you.\n";
        }
        return "You wander around the city and find nothing of interest.\n";

    }

    @Override
    public String loot(Player loot) {
        if (!goblin){
            loot.addToScore(25);
            loot.addToInventory("Old Rusty Sword");
            sword = true;
            return "You look around for something of interest to pick up and come across an Old Rusty Sword inside a barrel.\n";
        }

        if (goblin){
            loot.addToScore(10);
            loot.addToInventory("Goblin Claw");
            return "You decide to take a claw from the goblin as proof of your deeds.\n";
        }

        return "There seems to be nothing worth picking up.\n";
    }

    public void resetRoom(){
        sword = false;
        goblin = false;
    }
}
