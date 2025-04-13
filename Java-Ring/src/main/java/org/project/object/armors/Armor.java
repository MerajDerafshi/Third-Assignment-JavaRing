package org.project.object.armors;

import org.project.object.gameObject;

public abstract class Armor implements gameObject {
    private final String name;
    private int defense;
    private final int maxDefense;
    private int durability;
    private final int maxDurability;
    private boolean isBroke;

    public Armor(String name, int defense, int durability) {
        this.name = name;
        this.defense = this.maxDefense = defense;
        this.durability = this.maxDurability = durability;
        this.isBroke = false;
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    public void takeDamage(int damage) {
        if (!isBroke) {
            durability -= damage / 2;
            checkBreak();
        }
    }

    public int getDefense() {
        return defense;
    }

    public boolean isBroke() {
        return isBroke;
    }

    public String getName() {
        return name;
    }
}