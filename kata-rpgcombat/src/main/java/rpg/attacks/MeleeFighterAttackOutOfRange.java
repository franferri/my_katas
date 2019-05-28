package rpg.attacks;

import rpg.attack.Attack;
import rpg.attack.GameData;
import rpg.characters.MeleeFighter;

public class MeleeFighterAttackOutOfRange extends Attack {

    @Override
    protected void attack(GameData gameData) {
        if (gameData.player() instanceof MeleeFighter && gameData.player().range() > 2) {
            abortChain();
        }
    }

}
