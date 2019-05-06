package coup;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    private int treasury;
    private Deck deck;

    private Player playerDoingAction;
    private Player targetPlayerForAssasination;
    private Player targetPlayerBlockAction;
    private Player playerCallingTheBluff;
    private Player lastPlayerDoingAnAction;

    public Game(Player... players) throws Exception {

        if (players.length < 2) {
            throw new Exception("Need more players");
        }

        if (players.length > 4) {
            throw new Exception("Only 4 players allowed");
        }

        this.deck = new Deck();
        treasury = 50;

        for (Player player : players) {

            this.players.add(player);

            addCoin(player);
            addCoin(player);

            dealCard(player);
            dealCard(player);
        }

    }

    public Deck deck() {
        return deck;
    }

    public int treasury() {
        return treasury;
    }

    public void takeCoinFromTreasury() {
        --treasury;
    }

    public void returnCoinToTreasury() {
        ++treasury;
    }

    public void addCoin(Player player) {
        player.addCoin();
        --treasury;
    }

    public void dealCard(Player player) {
        player.cards().add(deck.cards().remove(1));
    }

    public Player player(int player) {
        return players.get(--player);
    }

    // setActivePlayer
    public void setPlayerPlayingThisHand(int player) {
        playerDoingAction = player(player);
    }

    public Player playerPlayingHand() {
        return playerDoingAction;
    }

    public void setTargetPlayerForAssasination(int player) {
        targetPlayerForAssasination = player(player);
    }

    public void setPlayerBlocksAction(int player) {
        targetPlayerBlockAction = player(player);
    }

    public void setPlayerCallingTheBluffAndOnWho(int playerCallingTheBluff, int lastPlayerDoingAnAction) {
        this.playerCallingTheBluff = player(playerCallingTheBluff);
        this.lastPlayerDoingAnAction = player(lastPlayerDoingAnAction);
    }

    public void assasinatePlayer() {
        targetPlayerForAssasination.assassinate();
    }

    public void killPlayer(int player) {
        player(player).dies();
    }

    public Player whoIsTheWinner() {

        int playersAlive = players.size();
        Player winner = null;
        for (Player player : players) {

            if (player.isDead()) {
                --playersAlive;
            } else {
                winner = player;
            }

        }

        if (playersAlive == 1) {
            return winner;
        } else return null;

    }

    public void doAction(Action action) {
        action.doAction(this);
    }

    public void doBlockAction(Action action) {
        action.doBlockAction(this);
    }

    public void doCallTheBluff(Action actionBeingCalledToBeABluff) {

        // The player calling the bluff will loose 1 card if fails
        // The player who did the last action (and accused to be bluffing) has to have the card with the action
        // If he does, he reshuffle his card (because everyone knows it now) and the block is effective, we dont undo action
        // If he don't, he looses one card and the action will happen

        if (lastPlayerDoingAnAction.canHeBlockAction(actionBeingCalledToBeABluff)) {
            // If the actioner wins the bluff

            playerCallingTheBluff.looseCard();
            //lastPlayerDoingAnAction.shuffleCard(actionBeingCalledToBeABluff);
        } else {
            // If the actinoer looses the bluff
            lastPlayerDoingAnAction.looseCard();
            doAction(actionBeingCalledToBeABluff);
        }

    }


}
