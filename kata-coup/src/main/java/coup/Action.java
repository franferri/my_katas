package coup;

public abstract class Action {

    public void doAction(Game game) throws Exception {

        doActionInternal(game);

    }

    public boolean canThisActionBeChallenged() {
        return true;
    }

    public abstract void doCallTheBluffOnTheBlockAction(Game game) throws Exception;

    public void doBlockAction(Game game) throws Exception {

        doBlockActionInternal(game);

    }

    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    public abstract void doCallTheBluffOnTheAction(Game game) throws Exception;

    public abstract void doActionInternal(Game game) throws Exception;

    public abstract void doBlockActionInternal(Game game) throws Exception;

    public void doCallTheBluffOnBlockAction(Game game) throws Exception {

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

    public void doCallTheBluffOnAction(Game game) throws Exception {

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

}
