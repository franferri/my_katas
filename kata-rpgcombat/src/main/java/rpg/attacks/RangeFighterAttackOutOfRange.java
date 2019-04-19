package rpg.attacks;

import rpg.GameData;
import rpg.characters.RangeFighter;

public class RangeFighterAttackOutOfRange extends Attack {

    @Override
    protected void attack(GameData gameData) {
        if (gameData.player() instanceof RangeFighter && gameData.player().range() > 20) {
            abortChain();
        }
    }

}
