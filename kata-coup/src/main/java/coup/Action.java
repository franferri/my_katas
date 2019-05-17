package coup;


public abstract class Action {

    protected GameEngine gameEngine;
    private boolean isBlocked;

    public Action() {
    }

    public Action(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    // Setup
    public boolean canThisActionBeChallenged() {
        return true;
    }

    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    // Action
    public void doAction() throws Exception {
        doActionInternal();
        isBlocked = false;
    }

    public abstract void doActionInternal() throws Exception;

    // Block Action
    public void doBlockAction() throws Exception {
        doBlockActionInternal();
        isBlocked = true;
    }

    public void doBlockActionInternal() throws Exception {
        throw new Exception("method not overridden");
    }

    // Bluff
    public void doCallTheBluffOnAction() throws Exception {
        if (gameEngine.playerDoingTheAction == gameEngine.playerCallingTheBluff) {
            throw new Exception("Action bluff can't be called over himself");
        }
        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }
        if (gameEngine.playerDoingTheAction.canHeDoTheAction(this)) {
            gameEngine.playerCallingTheBluff.looseCard();
        } else {
            doBlockActionInternal();
            gameEngine.playerDoingTheAction.looseCard();
        }
    }

    public void doCallTheBluffOnBlockAction() throws Exception {
        if (gameEngine.playerBlockingTheAction == gameEngine.playerCallingTheBluff) {
            throw new Exception("BlockAction bluff can't be called over the player doing the BlockAction");
        }
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        if (gameEngine.playerBlockingTheAction.canHeBlockTheAction(this)) {
            gameEngine.playerCallingTheBluff.looseCard();
        } else {
            doActionInternal();
            gameEngine.playerBlockingTheAction.looseCard();
        }
    }

    public boolean isBlocked() {
        return isBlocked;
    }

}
