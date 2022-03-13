package edu.wctc.Rooms;

import edu.wctc.Interfaces.Interactable;
import edu.wctc.Player;

public class Tavern extends Room implements Interactable {

    boolean dwarfTalk = false;
    boolean goblinTaskFinished = false;

    public Tavern(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        if (goblinTaskFinished) {
            return "[The inside of the Tavern is surprisingly much cleaner on the inside than the outside. The dwarf stood behind the bar on his stool, admiring his new trophy.]";
        }

        return "[The inside of the Tavern is surprisingly much cleaner on the inside than the outside. A portly dwarf stands on a stool behind the bar, cleaning a glass.]";
    }

    @Override
    public String interact(Player interact) {

        boolean goblinCheck = interact.getInventory().contains("Goblin Claw");

        if (goblinCheck && !goblinTaskFinished) {
            interact.addToScore(30);
            interact.addToInventory("Dwarvish Beer");
            interact.removeItem("Goblin Claw");
            goblinTaskFinished = true;
            return "You approach the counter and speak to the dwarf. You show him the Goblin Claw and he thanks you for getting rid of the goblin, handing you a Dwarvish Beer.\nHe then places the goblin claw on the shelf in the back as a trophy.\n";
        } else if (goblinTaskFinished) {
            return "You approach the counter and attempt to speak to the dwarf.\nHe seems to preoccupied admiring his new trophy to talk. Seems like there's not much to do here.\n";
        }

        if (!goblinCheck && !dwarfTalk) {
            dwarfTalk = true;
            return "You approach the counter and speak to the dwarf.\nHe goes on at length about an antagonistic goblin that has been ambushing people in the alleyways near his tavern, discouraging customers.\n";
        } else if (!goblinCheck && dwarfTalk) {
            return "You approach the counter and speak to the dwarf.\nHe reminds you about that pesky goblin in the alleyway and mentions that he saw someone discard an Old Rusty Sword into a barrel in the city somewhere.\n";
        }

        return "There doesn't seem much to do here.\n";

    }

    public void resetRoom() {
        dwarfTalk = false;
        goblinTaskFinished = false;
    }


}
