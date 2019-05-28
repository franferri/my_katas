package rpg.characters;

import rpg.attack.Attack;
import rpg.attack.GameData;
import rpg.attacks.*;

import java.util.ArrayList;
import java.util.List;

public class BaseCharacter {

    private static final int MAX_HEALTH = 1000;
    private static final int DEAD = 0;
    private int health = MAX_HEALTH;
    private int level = 1;
    protected int range;

    public BaseCharacter() {
    }

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

        Attack attackChain = getChainOfAttacks();
        attackChain.execute(gameData);

    }

    private static Attack getChainOfAttacks() {

        List<Attack> attacks = new ArrayList<>();
        attacks.add(new AvoidSelfDamaging());
        attacks.add(new NoHealingThroughDamage());
        attacks.add(new MeleeFighterAttackOutOfRange());
        attacks.add(new RangeFighterAttackOutOfRange());
        attacks.add(new ApplyReducedDamage());
        attacks.add(new ApplyBoostedDamage());
        attacks.add(new ApplyDamage());

        for (int i = 1; i < attacks.size(); i++) {
            attacks.get(i - 1).setNextLogger(attacks.get(i));
        }

        return attacks.get(0);

    }


    public int range() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

}
