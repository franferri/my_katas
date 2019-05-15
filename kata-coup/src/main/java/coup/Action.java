package coup;

public abstract class Action {

    public abstract boolean canThisActionBeChallenged() ;

    public abstract boolean canThisBlockActionBeChallenged();

    public void doAction(Game game) throws Exception {

        doActionInternal(game);

    }

    public void doBlockAction(Game game) throws Exception {

        doBlockActionInternal(game);

    }

    public abstract void doActionInternal(Game game) throws Exception;

    public void doActionInternal2(Game game ) {

    }

    public abstract void doBlockActionInternal(Game game) throws Exception;

    public void doCallTheBluffOnBlockActionInternal(Game game) throws Exception {

        // The player calling the bluff will loose 1 card if fails
        // The player who did the last action (and accused to be bluffing) has to have the card with the action
        // If he does, he reshuffle his card (because everyone knows it now) and the block is effective, we dont undo action
        // If he don't, he looses one card and the action will happen

        if (game.lastPlayerDoingAnAction.canHeBlockAction(this)) {
            // If the actioner wins the bluff

            game.playerCallingTheBluff.looseCard();
            //lastPlayerDoingAnAction.shuffleCard(actionBeingCalledToBeABluff);
        } else {
            // If the actioner looses the bluff
            game.lastPlayerDoingAnAction.looseCard();
            doActionInternal(game);
        }

    }

    public void doCallTheBluffOnBlockActionInternalOnStealing(Game game) throws Exception {

        // The player calling the bluff will loose 1 card if fails
        // The player who did the last action (and accused to be bluffing) has to have the card with the action
        // If he does, he reshuffle his card (because everyone knows it now) and the block is effective, we dont undo action
        // If he don't, he looses one card and the action will happen

        if (game.lastPlayerDoingAnAction.canHeBlockAction(this)) {
            // If the actioner wins the bluff

            game.playerCallingTheBluff.looseCard();
            //lastPlayerDoingAnAction.shuffleCard(actionBeingCalledToBeABluff);
        } else {
            // If the actioner looses the bluff
            game.lastPlayerDoingAnAction.looseCard();
            doActionInternal(game);
        }

    }



    public void doCallTheBluffOnBlockActionInternalOnAssasination(Game game) throws Exception {

        // The player calling the bluff will loose 1 card if fails
        // The player who did the last action (and accused to be bluffing) has to have the card with the action
        // If he does, he reshuffle his card (because everyone knows it now) and the block is effective, we dont undo action
        // If he don't, he looses one card and the action will happen

        if (game.lastPlayerDoingAnAction.canHeBlockAction(this)) {
            // If the actioner wins the bluff

            game.playerCallingTheBluff.looseCard();
            //lastPlayerDoingAnAction.shuffleCard(actionBeingCalledToBeABluff);
        } else {
            // If the actioner looses the bluff
            game.lastPlayerDoingAnAction.looseCard();
            doActionInternal2(game);
        }

    }



    public void doCallTheBluffOnActionInternal(Game game) throws Exception {

        // Is the action legit?

        if (game.lastPlayerDoingAnAction.doesHaveTheCardToDoTheAction(this)) {
            // If the actioner wins the bluff

            game.playerCallingTheBluff.looseCard();
            //lastPlayerDoingAnAction.shuffleCard(actionBeingCalledToBeABluff);
        } else {
            // If the actioner looses the bluff
            game.lastPlayerDoingAnAction.looseCard();
            doBlockActionInternal(game);
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

        doCallTheBluffOnBlockActionInternalOnStealing(game);

    }

    public void doCallTheBluffOnTheBlockActionOnAssasination(Game game) throws Exception {

        if (!canThisBlockActionBeChallenged()) {
            throw new Exception("This blockaction can't be challenged");
        }

        doCallTheBluffOnBlockActionInternalOnAssasination(game);

    }


    protected void returnCoinsToTreasury(Game game, int coins) throws Exception {

        if (game.playerPlayingHand().coins() < coins) {throw new Exception("Player don't have enough coins");}

        for (int i = 0; i < coins; i++) {
            game.playerPlayingHand().looseCoin();
            game.returnCoinToTreasury();
        }

    }

    protected void takeCoinsFromTreasury(Game game, int coins) throws Exception {

        if (game.treasury() < coins) {throw new Exception("Treasury don't have enough coins");}

        for (int i = 0; i < coins; i++) {
            game.takeCoinFromTreasury();
            game.playerPlayingHand().addCoin();
        }

    }

}
