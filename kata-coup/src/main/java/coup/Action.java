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

    public void doCallTheBluffOnBlockActionInternal(Game game) throws Exception {
        if (game.lastPlayerDoingAnAction.canHeBlockAction(this)) {
            game.playerCallingTheBluff.looseCard();
        } else {
            doActionInternal(game);
            game.lastPlayerDoingAnAction.looseCard();
        }
    }

    public void doCallTheBluffOnBlockActionInternalOnAssasination(Game game) throws Exception {
        if (game.lastPlayerDoingAnAction.canHeBlockAction(this)) {
            game.playerCallingTheBluff.looseCard();
        } else {
            doActionInternal2(game);
            game.lastPlayerDoingAnAction.looseCard();
        }
    }

    public void doCallTheBluffOnActionInternal(Game game) throws Exception {
        if (game.lastPlayerDoingAnAction.doesHaveTheCardToDoTheAction(this)) {
            game.playerCallingTheBluff.looseCard();
        } else {
            doBlockActionInternal(game);
            game.lastPlayerDoingAnAction.looseCard();
        }
    }

    public void doCallTheBluffOnTheAction(Game game) throws Exception {
        if (!canThisActionBeChallenged()) {
            throw new Exception("This action can't be challenged");
        }
        doCallTheBluffOnActionInternal(game);
    }

    public void doCallTheBluffOnTheBlockAction(Game game) throws Exception {
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }
        doCallTheBluffOnBlockActionInternal(game);
    }

    public void doCallTheBluffOnTheBlockActionOnStealing(Game game) throws Exception {
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }
        doCallTheBluffOnBlockActionInternal(game);
    }

    public void doCallTheBluffOnTheBlockActionOnAssasination(Game game) throws Exception {
        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }
        doCallTheBluffOnBlockActionInternalOnAssasination(game);
    }

    protected void returnCoinsToTreasury(Game game, int coins) throws Exception {
        if (game.playerPlayingHand().coins() < coins) {
            throw new Exception("Player don't have enough coins");
        }
        for (int i = 0; i < coins; i++) {
            game.playerPlayingHand().looseCoin();
            game.returnCoinToTreasury();
        }
    }

    protected void takeCoinsFromTreasury(Game game, int coins) throws Exception {
        if (game.treasury() < coins) {
            throw new Exception("Treasury don't have enough coins");
        }
        for (int i = 0; i < coins; i++) {
            game.takeCoinFromTreasury();
            game.playerPlayingHand().addCoin();
        }
    }

}
