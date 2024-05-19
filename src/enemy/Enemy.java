package enemy;

import player.Player;

public class Enemy {
    protected int enemyHealth;
    protected int enemyDamage;

    // Default Constructor
    public Enemy() {
        this.enemyHealth = 100;
        this.enemyDamage = 10;
    }

    // Constructor with Health
    public Enemy(int enemyHealth) {
        this.enemyHealth = enemyHealth;
        this.enemyDamage = 10;
    }

    // Constructor with Health and Damage
    public Enemy(int enemyHealth, int enemyDamage) {
        this.enemyHealth = enemyHealth;
        this.enemyDamage = enemyDamage;
    }

    // Getter
    public int getENEMY_HEALTH() {
        return enemyHealth;
    }

    // Getter for Damage
    public int getEnemyDamage() {
        return enemyDamage;
    }

    // Take Damage Method
    public void takeDamage(int damage) {
        this.enemyHealth -= damage;
    }

    // Attack Method
    public void attack(Player player) {
        player.takeDamage(enemyDamage);
    }
}
