package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public abstract class Player implements Entity {
    protected String name;
    Weapon weapon;
    Armor armor;
    private int hp;
    private final int maxHP;
    private int mp;
    private final int maxMP;
    private boolean isDefending;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor, int maxHP, int maxMP) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.weapon = weapon;
        this.armor = armor;
        this.isDefending = false;
    }

    @Override
    public void attack(Entity target) {
        if (weapon != null) {
            target.takeDamage(weapon.getDamage());
            System.out.println(name + " attacked " + target.getName() + " with " + weapon.getName());
        } else {
            System.out.println(name + " has no weapon to attack!");
        }
    }

    @Override
    public void defend() {
        if (armor != null) {
            isDefending = true;
            System.out.println(name + " is defending! Armor defense increased.");
        } else {
            System.out.println(name + " tried to defend, but has no armor!");
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (this instanceof Assassin && ((Assassin) this).isInvisible) {
            System.out.println(name + " is in stealth mode and avoids the attack!");
            return;
        }

        int armorDefense = (armor != null) ? armor.getDefense() : 0;

        if (isDefending) {
            damage /= 2;
            isDefending = false;
            System.out.println(name + " successfully defended! Damage reduced.");
        }

        int finalDamage = damage - armorDefense;

        if (finalDamage <= 0) {
            System.out.println(name + " blocked the attack! No damage taken.");
            return;
        }

        hp = Math.max(0, hp - finalDamage);
        System.out.println(name + " took " + finalDamage + " damage! Remaining HP: " + hp);
    }


    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
        System.out.println(name + " healed for " + health + " HP!");
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
        System.out.println(name + " restored " + mana + " MP!");
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getMp() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public Armor getArmor() {
        return armor;
    }

    @Override
    public void equipWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println(name + " equipped a new weapon: " + newWeapon.getName());
    }

    @Override
    public void equipArmor(Armor newArmor) {
        if (newArmor != null) {
            this.armor = newArmor;
            System.out.println(name + " equipped new armor: " + newArmor.getName());
        } else {
            System.out.println(name + " tried to equip armor, but it was null!");
        }
    }

    @Override
    public boolean isDefending() {
        return isDefending;
    }

    public abstract void useAbility(Entity target);
}