package org.project.object.weapons;

import org.project.entity.Entity;
import java.util.ArrayList;

//for knight and Skeleton
public class Sword extends Weapon {
    private int abilityCharge;

    public Sword() {
        super("Sword", 25, 5);
        this.abilityCharge = 0;
    }

    @Override
    public void use(Entity target) {
        target.takeDamage(getDamage());
        System.out.println(getName() + " slashes " + target.getName() + " for " + getDamage() + " damage!");
    }

    public void uniqueAbility(ArrayList<Entity> targets) {
        abilityCharge += 2;
        for (Entity target : targets) {
            target.takeDamage(getDamage());
            System.out.println(getName() + " hits " + target.getName() + " for " + getDamage() + " damage!");
        }
    }
}