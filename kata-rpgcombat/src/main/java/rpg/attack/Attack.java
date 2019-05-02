package rpg.attack;

public abstract class Attack {

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
