package org.project.object.weapons;

import org.project.entity.Entity;
import java.util.ArrayList;

//for wizard
public class Staff extends Weapon {
    private int abilityCharge;

    public Staff() {
        super("Staff", 20, 8);
        this.abilityCharge = 0;
    }

    @Override
    public void use(Entity target) {
        target.takeDamage(getDamage());
        System.out.println(getName() + " blasts " + target.getName() + " with magical energy for " + getDamage() + " damage!");
    }

    // Unique Ability: Arcane Burst (AOE attack)
    public void uniqueAbility(ArrayList<Entity> targets) {
        if (abilityCharge >= 4) {
            for (Entity target : targets) {
                target.takeDamage(getDamage() + 10); // Extra damage for the burst
                System.out.println(getName() + " unleashes an Arcane Burst, dealing " + (getDamage() + 10) + " damage to " + target.getName() + "!");
            }
            abilityCharge = 0; // Reset charge
        } else {
            System.out.println(getName() + " needs more charge to use Arcane Burst! (" + (4 - abilityCharge) + " turns left)");
        }
    }

    public void chargeAbility() {
        abilityCharge++;
    }
}