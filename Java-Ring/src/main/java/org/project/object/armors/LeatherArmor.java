package org.project.object.armors;

import org.project.entity.Entity;
import org.project.entity.players.Assassin;

//for Assassin and Goblin
public class LeatherArmor extends Armor {
    private final int agilityBonus;

    public LeatherArmor() {
        super("LeatherArmor",20, 50);
        this.agilityBonus = 10;
    }


    public void applyBonus(Assassin assassin) {
        assassin.increaseAgility(agilityBonus);
        System.out.println(assassin.getName() + " equipped Leather Armor and gained " + agilityBonus + " agility!");
    }

    @Override
    public void use(Entity target) {

    }
}