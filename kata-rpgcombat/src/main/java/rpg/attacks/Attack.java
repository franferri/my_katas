package rpg.attacks;

import rpg.GameData;

public abstract class Attack { // Link of the chain

    protected Attack nextAttack;
    private boolean abortChain = false;

    public void setNextLogger(Attack nextAttack) {
        this.nextAttack = nextAttack;
    }

    public void execute(GameData gameData) {
        attack(gameData);
        if (nextAttack != null && !abortChain) {
            nextAttack.execute(gameData);
        }
    }

    public void abortChain() {
        abortChain = true;
    }

    abstract protected void attack(GameData gameData);

}
