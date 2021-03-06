package rpg.attacks;

import rpg.attack.Attack;
import rpg.attack.GameData;

public class ApplyReducedDamage extends Attack {

    @Override
    protected void attack(GameData gameData) {
        if (gameData.enemy().level() - gameData.player().level() >= 5) {
            gameData.enemy().receiveDamage(gameData.damage() / 2);
            abortChain();
        }
    }

}
