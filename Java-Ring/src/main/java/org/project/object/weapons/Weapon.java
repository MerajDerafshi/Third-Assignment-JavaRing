
package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.object.gameObject;

public abstract class Weapon implements gameObject {
    private final String name;
    private final int damage;
    private final int manaCost;

    public Weapon(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public abstract void use(Entity target);

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }
}
