package rpg;

import java.util.ArrayList;
import java.util.List;

import rpg.attacks.ApplyBoostedDamage;
import rpg.attacks.ApplyDamage;
import rpg.attacks.ApplyReducedDamage;
import rpg.attacks.Attack;
import rpg.attacks.AvoidSelfDamaging;
import rpg.attacks.MeleeFighterAttackOutOfRange;
import rpg.attacks.NoHealingThroughDamage;
import rpg.attacks.RangeFighterAttackOutOfRange;

public class ChainOfAttacks {

    public static Attack getChainOfAttacks() {

        List<Attack> attacks = new ArrayList<>();
        attacks.add(new AvoidSelfDamaging());
        attacks.add(new NoHealingThroughDamage());
        attacks.add(new MeleeFighterAttackOutOfRange());
        attacks.add(new RangeFighterAttackOutOfRange());
        attacks.add(new ApplyReducedDamage());
        attacks.add(new ApplyBoostedDamage());
        attacks.add(new ApplyDamage());

        return createChain(attacks);

    }

    private static Attack createChain(List<Attack> attacks) {
        for (int i = 1; i < attacks.size(); i++) {
            attacks.get(i - 1).setNextLogger(attacks.get(i));
        }
        return attacks.get(0);
    }

}
