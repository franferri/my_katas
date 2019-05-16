package coup;

public abstract class Action {

    // Setup
    public boolean canThisActionBeChallenged() {
        return true;
    }

    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    // Action
    public void doAction(Game game) throws Exception {
        doActionInternal(game);
    }

    public abstract void doActionInternal(Game game) throws Exception;

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        doBlockActionInternal(game);
    }

    public void doBlockActionInternal(Game game) throws Exception {
        throw new Exception("method not overridden");
    }

    // Bluff
    public void doCallTheBluffOnAction(Game game) throws Exception {
        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }
        if (game.playerDoingTheAction.canHeDoTheAction(this)) {
            game.playerCallingTheBluff.looseCard();
        } else {
            doBlockActionInternal(game);
            game.playerDoingTheAction.looseCard();
        }
    }

    public void doCallTheBluffOnBlockAction(Game game) throws Exception {
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        if (game.playerBlockingTheAction.canHeBlockTheAction(this)) {
            game.playerCallingTheBluff.looseCard();
        } else {
            doActionInternal(game);
            game.playerBlockingTheAction.looseCard();
        }
    }

}
