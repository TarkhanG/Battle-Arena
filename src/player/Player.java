package player;

import enemy.Enemy;

public class Player {
    private int playerDamagePower = 20;
    private int playerDamageUlti = 50;
    private int health = 100;

    // Constructors
    public Player() {
    }

    public Player(int health, int damagePower) {
        this.health = health;
    }

    // Getter
    public int getHealth() {
        return health;
    }

    public int getPlayerDamageUlti() {
        return playerDamageUlti;
    }

    public int getPlayerDamagePower() {
        return playerDamagePower;
    }

    // Take Damage Method
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    // Player Attack
    public void attack(Enemy enemy) {
        enemy.takeDamage(getPlayerDamagePower());
    }

    // Player Attack Ulti
    public void attackUlti(Enemy enemy) {
        enemy.takeDamage(getPlayerDamageUlti());
    }
}
