package rpg.attacks;

import rpg.attack.Attack;
import rpg.attack.GameData;

public class NoHealingThroughDamage extends Attack {

    @Override
    protected void attack(GameData gameData) {
        if (gameData.damage() <= 0) {
            abortChain();
        }
    }

}
