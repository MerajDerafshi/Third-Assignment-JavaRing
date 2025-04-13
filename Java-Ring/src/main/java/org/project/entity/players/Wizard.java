package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Robe;
import org.project.object.weapons.Staff;


public class Wizard extends Player {
    public Wizard(String name) {
        super(name, 80, 100, new Staff(), new Robe(), 80, 100);
    }

    @Override
    public void useAbility(Entity target) {
        int healAmount = 20;
        int damageAmount = 15;
        int manaCost = 20;

        if (getMp() >= manaCost) {
            heal(healAmount);
            target.takeDamage(damageAmount);
            fillMana(-manaCost);
            System.out.println(getName() + " casts a magical spell! Heals for " + healAmount + " HP and damages the enemy for " + damageAmount + " HP.");
        } else {
            System.out.println(getName() + " does not have enough mana to cast the spell!");
        }
    }


}