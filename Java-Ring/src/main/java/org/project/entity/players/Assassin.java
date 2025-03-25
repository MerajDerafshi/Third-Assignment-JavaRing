package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.LeatherArmor;
import org.project.object.weapons.Dagger;

public class Assassin extends Player{

    boolean isInvisible;
    private static final int STEALTH_DURATION = 2;
    private int stealthRoundsLeft = 0;
    private static final int STEALTH_COST = 15;

    public Assassin(String name) {
        super(name, 90, 50, new Dagger(), new LeatherArmor(), 90, 50);
        this.isInvisible = false;
    }

    @Override
    public void useAbility(Entity target) {
        if (!isInvisible) {
            if (getMp() >= STEALTH_COST) {
                fillMana(-STEALTH_COST);
                isInvisible = true;
                stealthRoundsLeft = STEALTH_DURATION;
                System.out.println(getName() + " has entered stealth mode! Cannot be attacked for " + STEALTH_DURATION + " rounds.");
            } else {
                System.out.println(getName() + " does not have enough mana to enter stealth mode!");
            }
        } else {
            int backstabDamage = getWeapon().getDamage() * 2;
            target.takeDamage(backstabDamage);
            System.out.println(getName() + " performs a deadly backstab, dealing " + backstabDamage + " damage!");
            isInvisible = false;
            stealthRoundsLeft = 0;
            System.out.println(getName() + " is no longer invisible!");
        }
    }


    public void nextTurn() {
        if (isInvisible && stealthRoundsLeft > 0)
        {
            stealthRoundsLeft--;
            if (stealthRoundsLeft == 0)
            {
                isInvisible = false;
                System.out.println(getName() + " is no longer invisible!");
            }
        }
    }

    public void increaseAgility(int amount) {

        System.out.println(getName() + " increased agility by " + amount + "!");
    }



}