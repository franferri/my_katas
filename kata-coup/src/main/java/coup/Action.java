package coup;

public abstract class Action {

    public abstract boolean canThisActionBeChallenged();

    public abstract boolean canThisBlockActionBeChallenged();

    public void doAction(Game game) throws Exception {
        doActionInternal(game);
    }

    public void doBlockAction(Game game) throws Exception {
        doBlockActionInternal(game);
    }

    public abstract void doActionInternal(Game game) throws Exception;

    public void doActionInternal2(Game game) {
    }

    public abstract void doBlockActionInternal(Game game) throws Exception;

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
