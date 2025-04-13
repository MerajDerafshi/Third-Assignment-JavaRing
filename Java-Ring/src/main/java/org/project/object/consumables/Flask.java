package org.project.object.consumables;

import org.project.entity.Entity;

public class Flask extends Consumable {
    public Flask() {
        super("Health Flask", 50);
    }

    @Override
    public void use(Entity target) {
        if (target != null) {
            int healAmount = target.getMaxHP() / 10;
            target.heal(healAmount);
            System.out.println(target.getName() + " used a " + getName() + " and restored " + healAmount + " HP!");
        }
    }
}