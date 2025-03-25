package org.project.object.consumables;

import org.project.entity.Entity;
import org.project.object.gameObject;

public abstract class Consumable implements gameObject {
    private final String name;
    private final int effectValue;

    public Consumable(String name, int effectValue) {
        this.name = name;
        this.effectValue = effectValue;
    }

    public abstract void use(Entity target);

    public String getName() {
        return name;
    }

    public int getEffectValue() {
        return effectValue;
    }
}