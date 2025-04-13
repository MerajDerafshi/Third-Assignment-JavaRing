package org.project;

import org.project.entity.players.*;
import org.project.entity.enemies.*;
import org.project.entity.players.Player;
import org.project.entity.enemies.Enemy;
import org.project.location.Location;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.println("Choose your character: 1. Knight  2. Assassin  3. Wizard");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your character name: ");
        String playerName = scanner.nextLine();
        Player player;

        switch (choice) {
            case 1:
                player = new Knight(playerName);
                break;
            case 2:
                player = new Assassin(playerName);
                break;
            case 3:
                player = new Wizard(playerName);
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Knight.");
                player = new Knight(playerName);
        }

        System.out.println("You chose: " + player.getClass().getSimpleName());

        startGame(player);
    }

    // Random enemy
    public static Enemy generateRandomEnemy() {
        Random random = new Random();
        int enemyType = random.nextInt(3); // مقدار تصادفی بین 0 تا 2
        switch (enemyType) {
            case 0:
                System.out.println("Your random enemy is Goblin");
                return new Goblin("Goblin");
            case 1:
                System.out.println("Your random enemy is Skeleton");
                return new Skeleton("Skeleton");
            case 2:
                System.out.println("Your random enemy is Dragon");
                return new Dragon("Dragon");
            default:
                System.out.println("Your random enemy is Goblin");
                return new Goblin("Goblin");
        }
    }

    // Random location
    //if the location is safe enemy can attack once but if it is dangerous enemy can attack twice
    public static Location generateRandomLocation() {
        Random random = new Random();
        int locationType = random.nextInt(2); // 0 is safe 1 is dangerous
        Location location;
        if (locationType == 0) {
            Enemy enemy = generateRandomEnemy();
            location = new Location("Village", true, enemy);  // Village is a safe location
        } else {

            Enemy enemy = generateRandomEnemy();
            location = new Location("Dungeon", false, enemy); // Dungeon is a dangerous location
        }

        return location;
    }

    public static void startGame(Player player) {
        Scanner scanner = new Scanner(System.in);

        while (player.isAlive()) {
            // new location
            Location location = generateRandomLocation();
            System.out.println("\nYou entered a " + location);

            Enemy enemy = location.getEnemy();



            // game loop
            while (player.isAlive() && (enemy != null && enemy.isAlive())) {
                System.out.println("\nChoose an action: 1. Attack  2. Use Ability  3. Defend  4. Run  5. Exit");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 4) { // change the enemy and location
                    System.out.println("You ran away! A new location appears...");
                    break;
                }

                switch (action) {
                    case 1:
                        System.out.println(player.getName() + " attacks with " + player.getWeapon().getName() + "!");
                        enemy.takeDamage(player.getWeapon().getDamage());

                        break;
                    case 2:
                        System.out.println(player.getName() + " uses their special ability!");
                        player.useAbility(enemy);
                        break;
                    case 3:
                        System.out.println(player.getName() + " is defending!");
                        player.defend();
                        break;
                    case 5:
                        //for Exit the game
                        System.out.println("EXIT");
                        return;
                    default:
                        System.out.println("Invalid choice! Defaulting to attack.");
                        enemy.takeDamage(player.getWeapon().getDamage());
                        break;
                }

                // next turn for cooldown
                if (player instanceof Assassin) {
                    ((Assassin) player).nextTurn();
                } else if (player instanceof Knight) {
                    ((Knight) player).nextTurn();
                }

                // enemies turn
                if ( enemy.isAlive()) {
                    System.out.println("\n" + enemy.getName() + "'s turn:");

                    // if the location is safe enemies can attack 1 time but if it isn't enemies can attack 2 times
                    int enemyAttackCount = location.isSafe() ? 1 : 2;
                    // this loop control the enemies attacks based on location safety
                    for (int i = 0; i < enemyAttackCount; i++) {
                        Random random = new Random();
                        int enemyAction = random.nextInt(3); // Random action for enemy attack
                        switch (enemyAction) {
                            case 0:
                                System.out.println(enemy.getName() + " attacks with " + enemy.getWeapon().getName() + "!");
                                player.takeDamage(enemy.getWeapon().getDamage());
                                break;
                            case 1:
                                System.out.println(enemy.getName() + " uses their special ability!");
                                enemy.useAbility(player);
                                break;
                            case 2:
                                System.out.println(enemy.getName() + " is defending!");
                                enemy.defend();
                                break;
                        }
                    }

                    // game over condition
                    if (!player.isAlive()) {
                        System.out.println("You have been defeated! Game Over.");
                        return;
                    }

                    if (!enemy.isAlive()) {
                        System.out.println("You defeated the " + enemy.getName() + "!");
                        return;
                    }
                }
            }
        }
    }
}