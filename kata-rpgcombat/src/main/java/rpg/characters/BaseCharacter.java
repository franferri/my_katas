package rpg.characters;

import rpg.ChainOfAttacks;
import rpg.GameData;
import rpg.attacks.Attack;

public class BaseCharacter {

    private static final int MAX_HEALTH = 1000;
    private static final int DEAD = 0;
    private int health = MAX_HEALTH;
    private int level = 1;
    protected int range;

    public BaseCharacter() {}

    public BaseCharacter(int level) {
        this.level = level;
    }

    public int health() {
        return health;
    }

    public int level() {
        return level;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        if (isDead()) {
            health = DEAD;
        }
    }

    public void heal(int heal) {

        if (isDead()) return;

        health += heal;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }

    }

    private boolean isDead() {
        return health <= DEAD;
    }

    public void attack(int damage, BaseCharacter enemy) {

        GameData gameData = new GameData(this, enemy, damage);

        Attack attackChain = ChainOfAttacks.getChainOfAttacks();
        attackChain.execute(gameData);

    }

    public int range() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

}
