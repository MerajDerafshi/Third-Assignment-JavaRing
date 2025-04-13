package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.armors.ScaleArmor;
import org.project.object.weapons.Claw;

import java.util.List;

public class Dragon extends Enemy{

    private boolean isDefending;

    public Dragon(String name) {
        super(name, 300, 150, new Claw(), new ScaleArmor(), 300, 150);
    }

    @Override
    public void useAbility(Entity target) {
        System.out.println(getName() + " uses its fiery breath, bypassing shields!");

        if (target.isDefending()) {
            target.takeDamage(50); // آسیب حتی اگر سپر داشته باشد
            System.out.println(target.getName() + " was defending, but still got hit!");
        } else {
            target.takeDamage(50);
        }
    }

    public void useAbility(List<Entity> targets) {
        System.out.println(getName() + " unleashes a powerful attack on all players!");

        for (Entity target : targets) {
            target.takeDamage(50);
            System.out.println(target.getName() + " was hit by the Dragon's breath!");
        }
    }

    @Override
    public String getName() {
        return "Dragon";
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