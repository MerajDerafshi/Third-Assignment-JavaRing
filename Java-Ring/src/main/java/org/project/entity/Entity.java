package org.project.entity;

import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public interface Entity {
    void attack(Entity target);

    void defend();

    void heal(int health);

    void fillMana(int mana);

    void takeDamage(int damage);

    int getHp();

    int getMaxHP();

    int getMp();

    int getMaxMP();

    boolean isAlive();

    void useAbility(Entity target);

    void equipWeapon(Weapon weapon);

    void equipArmor(Armor armor);

    String getName();

    Weapon getWeapon();

    Armor getArmor();

    boolean isDefending();
}