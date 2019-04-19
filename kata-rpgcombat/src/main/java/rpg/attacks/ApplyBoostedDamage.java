package rpg.attacks;

import rpg.GameData;

public class ApplyBoostedDamage extends Attack {

    @Override
    protected void attack(GameData gameData) {
        if (gameData.player().level() - gameData.enemy().level() >= 5) {
            gameData.enemy().receiveDamage((int) (gameData.damage() + (gameData.damage() * 0.5)));
            abortChain();
        }

    }

}
