package coup;

public abstract class Action {

    public abstract void doAction(Game game);

    public boolean canThisActionBeChallenged() {
        return true;
    }

    public abstract void doCallTheBluffOnTheBlockAction(Game game) throws Exception;

    public abstract void doBlockAction(Game game) throws Exception;

    public boolean canThisBlockActionBeChallenged() {
        return true;
    }

    public abstract void doCallTheBluffOnTheAction(Game game) throws Exception;

    public void doCallTheBluff(Game game) throws Exception {

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
            doAction(game);
        }

    }

}
