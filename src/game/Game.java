package game;

import enemy.Archer;
import enemy.Barbarian;
import enemy.Dragon;
import enemy.Enemy;
import player.Player;

import java.util.Scanner;

public class Game {

    public static void startGame() {
        System.out.println("********************************************************************************");
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Enemy[] enemies = {new Barbarian(), new Archer(), new Dragon()};
        boolean gameOver = false;
        int turn = 0;
        System.out.println("Welcome to the Battle Arena!");
        System.out.println("Game has started");
        int ultiCount = 0;

        while (!gameOver) {
            System.out.println("-----------------------");
            System.out.println("\nPlayer Health: " + player.getHealth() + "❤️");
            System.out.println("-----------------------");
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null) {
                    System.out.println(("Enemy " + (i + 1) + " Health: " + enemies[i].getENEMY_HEALTH() + "❤️"));
                }
            }
            System.out.println("-----------------------");

            System.out.println("Choose which Enemy to attack: (1, 2, 3)");
            int choice = scanner.nextInt() - 1;
            if (enemies[choice] != null) {
                System.out.println("Select attack type: (1: Normal Attack, 2: Ultimate Attack)");
                int attackType = scanner.nextInt();
                if (attackType == 1) {
                    player.attack(enemies[choice]);
                    System.out.println("Barbarian " + (choice + 1) + " attacked!");
                } else if (attackType == 2) {
                    ultiCount++;
                    if (ultiCount > 3) {
                        player.attack(enemies[choice]);
                        System.out.println("Archer " + (choice + 1) + "attacked!");
                    } else {
                        player.attackUlti(enemies[choice]);
                        System.out.println("Archer " + (choice + 1) + "Ulti attacked!");
                    }
                } else {
                    System.out.println("Invalid attack type!");
                }

                // Check if the chosen enemy is dead
                if (enemies[choice].getENEMY_HEALTH() <= 0) {
                    System.out.println("Enemy " + (choice + 1) + " dead!");
                    enemies[choice] = null;
                }

            }

            // Check if all enemies are dead
            boolean allEnemiesDead = true;
            for (Enemy enemy : enemies) {
                if (enemy != null && enemy.getENEMY_HEALTH() > 0) {
                    allEnemiesDead = false;
                    break;
                }
            }
            if (allEnemiesDead) {
                System.out.println("Player Winner Winner Chicken Dinner!");
                break;
            }

            Enemy attackingEnemy;
            do {
                attackingEnemy = enemies[turn % enemies.length];
                turn++;
            } while (attackingEnemy == null);

            attackingEnemy.attack(player);
            System.out.println("Enemy " + (turn % enemies.length + 1) + " Attacked the player!");

            // Check if player is dead
            if (player.getHealth() <= 0) {
                System.out.println("Enemy Winnet!");
                gameOver = true;
            }
        }
        scanner.close();
    }
}
