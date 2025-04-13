package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.KnightArmor;
import org.project.object.weapons.Sword;


public class Knight extends Player {

    private int roundsPassed = 0;
    private static final int KICK_MANA_COST = 10;
    private static final int KICK_COOLDOWN = 3; // Each 3 rounds the kick can be used

    public Knight(String name) {
        super(name, 120, 30, new Sword(), new KnightArmor(), 120, 30);
    }

    @Override
    public void useAbility(Entity target) {
        if (roundsPassed < KICK_COOLDOWN) {
            System.out.println(getName() + " cannot use Kick Attack yet! " + (KICK_COOLDOWN - roundsPassed) + " turns left.");
            return;
        }

        if (getMp() >= KICK_MANA_COST) {
            fillMana(-KICK_MANA_COST);
            int kickDamage = 25;
            target.takeDamage(kickDamage);
            System.out.println(getName() + " performs a powerful kick, dealing " + kickDamage + " damage!");
            roundsPassed = 0;
        } else {
            System.out.println(getName() + " does not have enough mana to use Kick Attack!");
        }
    }


    public void nextTurn() {
        roundsPassed++;
    }
}