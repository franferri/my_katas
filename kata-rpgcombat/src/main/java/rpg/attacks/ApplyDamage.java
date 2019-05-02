package rpg.attacks;

import rpg.attack.Attack;
import rpg.attack.GameData;

public class ApplyDamage extends Attack {

    @Override
    protected void attack(GameData gameData) {
        gameData.enemy().receiveDamage(gameData.damage());
        abortChain();
    }

}
