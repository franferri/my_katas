package rpg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rpg.characters.BaseCharacter;
import rpg.characters.MeleeFighter;
import rpg.characters.RangeFighter;

public class RPGCombatKata {

    // Iteration One ##########################################

    @Test
    public void BaseCharacterDiesOverCriticalHit() {
        BaseCharacter player = new BaseCharacter();
        player.receiveDamage(1001);
        assertEquals(0, player.health());
    }

    @Test
    public void BaseCharacterDiesOnCriticalHit() {
        BaseCharacter player = new BaseCharacter();
        player.receiveDamage(1000);
        assertEquals(0, player.health());
    }

    @Test
    public void diedBaseCharacterCannotBeHealed() {
        BaseCharacter player = new BaseCharacter();
        player.receiveDamage(1000);
        player.heal(1);
        assertEquals(0, player.health());
    }

    @Test
    public void BaseCharacterGetDamage() {
        BaseCharacter player = new BaseCharacter();
        player.receiveDamage(999);
        assertEquals(1, player.health());
    }

    @Test
    public void BaseCharacterGetHeal() {
        BaseCharacter player = new BaseCharacter();
        player.receiveDamage(1);
        player.heal(1);
        assertEquals(1000, player.health());
    }

    @Test
    public void healthyBaseCharacterCantBeHealed() {
        BaseCharacter player = new BaseCharacter();
        player.heal(1);
        assertEquals(1000, player.health());
    }

    @Test
    public void BaseCharacterAttackEnemy() {
        BaseCharacter player = new BaseCharacter();
        BaseCharacter enemy = new BaseCharacter();
        player.attack(100, enemy);
        assertEquals(900, enemy.health());
    }

    // Iteration Two ##########################################

    @Test
    public void BaseCharacterCannotAttackHimself() {
        BaseCharacter player = new BaseCharacter();
        player.attack(100, player);
        assertEquals(1000, player.health());
    }

    @Test
    public void BaseCharacterCannotHealEnemy() {
        BaseCharacter player = new BaseCharacter();
        BaseCharacter enemy = new BaseCharacter();

        player.attack(500, enemy);
        player.attack(-100, enemy);

        assertEquals(500, enemy.health());
    }

    @Test
    public void hitEnemy5LevelsAbovePlayer() {
        BaseCharacter player = new BaseCharacter();
        BaseCharacter enemy = new BaseCharacter(6);
        player.attack(1000, enemy);
        assertEquals(500, enemy.health());
    }

    @Test
    public void hitPlayer5LevelsAboveEnemy() {
        BaseCharacter player = new BaseCharacter(6);
        BaseCharacter enemy = new BaseCharacter();
        player.attack(500, enemy);
        assertEquals(250, enemy.health());
    }

    // Iteration Three ##########################################

    @Test
    public void attackRangeOfMeleeFighters() {
        BaseCharacter player = new MeleeFighter();
        assertEquals(2, player.range());
    }

    @Test
    public void attackMaxRangeOfRangeFighters() {
        BaseCharacter player = new RangeFighter();
        assertEquals(20, player.range());
    }

    @Test
    public void meleeFightersAttackInRange() {
        BaseCharacter player = new MeleeFighter();
        BaseCharacter enemy = new BaseCharacter();
        player.attack(100, enemy);
        assertEquals(2, player.range());
        assertEquals(900, enemy.health());
    }

    @Test
    public void meleeFightersAttackOutOfRange() {
        BaseCharacter player = new MeleeFighter();
        player.setRange(5);
        BaseCharacter enemy = new BaseCharacter();
        player.attack(100, enemy);
        assertEquals(5, player.range());
        assertEquals(1000, enemy.health());
    }

    @Test
    public void rangeFightersAttackInRange() {
        BaseCharacter player = new RangeFighter();
        BaseCharacter enemy = new BaseCharacter();
        player.attack(100, enemy);
        assertEquals(20, player.range());
        assertEquals(900, enemy.health());
    }

    @Test
    public void rangeFightersAttackOutOfRange() {
        BaseCharacter player = new RangeFighter();
        player.setRange(50);
        BaseCharacter enemy = new BaseCharacter();
        player.attack(100, enemy);
        assertEquals(50, player.range());
        assertEquals(1000, enemy.health());
    }

}
