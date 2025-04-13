
package org.project.location;

import org.project.entity.enemies.Enemy;

public class Location {
    private final String name;
    private final boolean isSafe;
    private final Enemy enemy;

    public Location(String name, boolean isSafe, Enemy enemy) {
        this.name = name;
        this.isSafe = isSafe;
        this.enemy = enemy;
    }

    public String getName() {
        return name;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public String toString() {
        return "Location: " + name + (isSafe ? " (Safe)" : " (Dangerous)");
    }
}
