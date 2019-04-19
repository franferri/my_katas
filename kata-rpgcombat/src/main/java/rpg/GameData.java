package rpg;

import rpg.characters.BaseCharacter;

public class GameData {

    private BaseCharacter player;
    private BaseCharacter enemy;
    private int damage;

    public GameData(BaseCharacter player, BaseCharacter enemy, int damage) {
        this.player = player;
        this.enemy = enemy;
        this.damage = damage;
    }

    public int damage() {
        return damage;
    }

    public BaseCharacter enemy() {
        return enemy;
    }

    public BaseCharacter player() {
        return player;
    }

}