package org.project.object.weapons;

import org.project.entity.Entity;
import java.util.Random;

//for Dragon
public class Claw extends Weapon {
    private static final int MAX_HITS = 3; // Claw can hit up to 3 times in one attack
    private Random random;

    public Claw() {
        super("Claw", 12, 4);
        this.random = new Random();
    }

    @Override
    public void use(Entity target) {
        int hits = random.nextInt(MAX_HITS) + 1; // Random hits between 1 and MAX_HITS
        int totalDamage = getDamage() * hits;
        target.takeDamage(totalDamage);
        System.out.println(getName() + " slashes " + target.getName() + " " + hits + " times, dealing a total of " + totalDamage + " damage!");
    }


}