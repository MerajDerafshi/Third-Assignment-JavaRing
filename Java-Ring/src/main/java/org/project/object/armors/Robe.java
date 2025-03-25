package org.project.object.armors;

import org.project.entity.Entity;
import org.project.entity.players.Wizard;

//for wizard
public class Robe extends Armor {
    private final int manaBonus;

    public Robe() {
        super("Robe",15, 40);
        this.manaBonus = 20;
    }


    public void applyBonus(Wizard wizard) {
        wizard.fillMana(manaBonus);
        System.out.println(wizard.getName() + " equipped a magical robe and gained " + manaBonus + " mana!");
    }

    @Override
    public void use(Entity target) {

    }
}