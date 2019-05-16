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

    public void doActionInternal2(Game game) {

    }

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        doBlockActionInternal(game);
    }

    public void doBlockActionInternal(Game game) throws Exception {

    }

    // Bluff
    public void doCallTheBluffOnActionInternal(Game game) throws Exception {
        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }
        if (game.playerDoingTheAction.doesHaveTheCardToDoTheAction(this)) {
            game.playerCallingTheBluff.looseCard();
        } else {
            doBlockActionInternal(game);
            game.playerLoosesCard(game.playerDoingTheAction);
        }
    }

    public void doCallTheBluffOnBlockActionInternal(Game game) throws Exception {
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        if (game.playerBlockingTheAction.canHeBlockAction(this)) {
            game.playerLoosesCard(game.playerCallingTheBluff);
        } else {
            doActionInternal(game);
            game.playerLoosesCard(game.playerBlockingTheAction);
        }
    }

    public void doCallTheBluffOnBlockActionInternalOnAssassination(Game game) throws Exception {
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        if (game.playerBlockingTheAction.canHeBlockAction(this)) {
            game.playerLoosesCard(game.playerCallingTheBluff);
        } else {
            doActionInternal2(game);
            game.playerLoosesCard(game.playerBlockingTheAction);
        }
    }

}
