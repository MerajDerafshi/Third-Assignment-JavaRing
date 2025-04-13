package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.armors.LeatherArmor;
import org.project.object.weapons.Dagger;
import org.project.object.weapons.Weapon;

public class Goblin extends  Enemy{

    private boolean isDefending;

    public Goblin(String name) {
        super(name, 80, 30, new Dagger(), new LeatherArmor(), 80, 30);
    }

    @Override
    public void useAbility(Entity target) {
        System.out.println(getName() + " has no unique abilities.");
    }

    @Override
    public String getName() {
        return "Goblin";
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        if (weapon != null) {
            super.equipWeapon(weapon);
            System.out.println(getName() + " equipped a new weapon: " + weapon.getName());
        } else {
            System.out.println(getName() + " tried to equip a weapon, but it was null!");
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