package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public abstract class Enemy implements Entity {
    Weapon weapon;
    Armor armor;
    int hp;
    private final int maxHP;
    private int mp;
    private final int maxMP;
    private int defenseBoost;

    public Enemy(String name, int hp, int mp, Weapon weapon, Armor armor, int maxHP, int maxMP) {
        this.hp = hp;
        this.mp = mp;
        this.weapon = weapon;
        this.armor = armor;
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.defenseBoost = 0;
    }

    @Override
    public void takeDamage(int damage) {
        int armorDefense = (armor != null) ? armor.getDefense() : 0;
        int finalDamage = Math.max(0, damage - (armorDefense + defenseBoost));
        hp = Math.max(0, hp - finalDamage);
        System.out.println(getName() + " took " + finalDamage + " damage! Remaining HP: " + hp);
    }

    @Override
    public void attack(Entity target) {
        if (weapon != null) {
            target.takeDamage(weapon.getDamage());
            System.out.println(getName() + " attacked " + target.getName() + " with " + weapon.getName());
        } else {
            System.out.println(getName() + " tried to attack, but has no weapon!");
        }
    }

    @Override
    public void defend() {
        int defenseIncrease = 5;
        defenseBoost += defenseIncrease;
        System.out.println(getName() + " is defending! Armor defense increased by " + defenseIncrease);
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
        System.out.println(getName() + " healed for " + health + " HP!");
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
        System.out.println(getName() + " restored " + mana + " MP!");
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    @Override
    public Armor getArmor() {
        return armor;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        if (weapon != null) {
            this.weapon = weapon;
            System.out.println(getName() + " equipped a new weapon: " + weapon.getName());
        } else {
            System.out.println(getName() + " tried to equip weapon, but it was null!");
        }
    }

    @Override
    public void equipArmor(Armor armor) {
        if (armor != null) {
            this.armor = armor;
            System.out.println(getName() + " equipped new armor: " + armor.getName());
        } else {
            System.out.println(getName() + " tried to equip armor, but it was null!");
        }
    }



    public void resetDefenseBoost() {
        defenseBoost = 0;
        System.out.println(getName() + "'s defense boost has been reset.");
    }
    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public int getMp() {
        return this.mp;
    }
    @Override
    public Weapon getWeapon() {
        return weapon;
    }




    public abstract void useAbility(Entity target);
    public abstract String getName();

    int turn = 0;
    public int nextTurn() {
        return turn++;
    }
}