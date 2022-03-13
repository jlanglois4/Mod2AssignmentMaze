package edu.wctc.Rooms;

import edu.wctc.Interfaces.Interactable;
import edu.wctc.Player;

public class AdventurersGuild extends Room implements Interactable {


    public AdventurersGuild(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "[A bored looking elf attendant stands behind a counter near the front.]";
    }

    @Override
    public String interact(Player interact) {
        interact.addToScore(5);
        return "You speak to the attendant at the front counter and they inform you that there is a job available in the basement.\n";
    }




}
