package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.armors.PlateArmor;
import org.project.object.weapons.Sword;
import org.project.object.weapons.Weapon;

public class Skeleton extends Enemy {

    private boolean isDefending;
    private boolean isResurrected = false;  // Flag to check if the skeleton has been resurrected
    private static final int RESURRECTION_MANA_COST = 20; // Mana cost for resurrection


    // Constructor to initialize Skeleton object with specific values
    public Skeleton(String name) {
        super(name, 100, 50, new Sword(), new PlateArmor(), 100, 50);
    }

    @Override
    public void useAbility(Entity target) {
        if (this.hp <= 0 && !isResurrected) {
            if (getMp() >= RESURRECTION_MANA_COST) {
                fillMana(-RESURRECTION_MANA_COST);
                resurrect();
            } else {
                System.out.println(getName() + " does not have enough mana to resurrect!");
            }
        } else {
            System.out.println(getName() + " has no unique abilities to use right now.");
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        if (weapon != null) {
            super.equipWeapon(weapon);
            System.out.println(getName() + " equipped a new weapon: " + weapon.getName());
        }
    }

    @Override
    public void equipArmor(Armor armor) {
        if (armor != null) {
            super.equipArmor(armor);
            System.out.println(getName() + " equipped a new armor: " + armor.getName());
        }
    }

    @Override
    public String getName() {
        return "Skeleton";
    }



    private void resurrect() {
        if (!isResurrected) {
            this.hp = getMaxHP() / 2;
            isResurrected = true;
            System.out.println(getName() + " has resurrected with " + this.hp + " HP!");
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (!isAlive()) {
            System.out.println(getName() + " is already dead and can't take more damage.");
            return;
        }

        super.takeDamage(damage);

        if (getHp() <= 0 && !isResurrected) {
            useAbility(null);
        }
    }


    @Override
    public boolean isDefending() {
        return isDefending;
    }

    public void defend() {
        isDefending = true;
        System.out.println(getName() + " is now defending!");
    }

    public void stopDefending() {
        isDefending = false;
        System.out.println(getName() + " stopped defending!");
    }
}