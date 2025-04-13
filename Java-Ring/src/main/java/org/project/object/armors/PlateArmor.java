package org.project.object.armors;

import org.project.entity.Entity;
import org.project .entity.enemies.Skeleton;

// for Skeleton
public class PlateArmor extends Armor {


    private static final int AGILITY_PENALTY = 5;

    public PlateArmor() {
        super("PlateArmor",50, 120);
    }

    public int getAgilityPenalty() {
        return AGILITY_PENALTY;
    }

    @Override
    public void takeDamage(int damage) {
        if (!isBroke()) {
            int reducedDamage = (int) (damage * 0.6); // 40% کاهش آسیب
            super.takeDamage(reducedDamage);
        }
    }

    @Override
    public void use(Entity target) {

    }
}