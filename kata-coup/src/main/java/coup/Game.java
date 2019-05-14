package coup;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    private int treasury;
    private Deck deck;

    private Player playerDoingAction;
    private Player targetPlayerForAssasination;
    public Player targetPlayerBlockAction;
    public Player playerCallingTheBluff;
    public Player lastPlayerDoingAnAction;

    public Game(Player... players) throws Exception {

        if (players.length < 2) {
            throw new Exception("Need more players");
        }

        if (players.length > 4) {
            throw new Exception("Only 4 players allowed");
        }

        treasury = 50;

        this.deck = new Deck();

        for (Player player : players) {

            this.players.add(player);

        }

    }

    public void startGame() {

        for (Player player : players) {

            player.addCoin();
            player.addCoin();

            takeCoinFromTreasury();
            takeCoinFromTreasury();

            dealCard(player);
            dealCard(player);
        }

        this.deck.shuffle();

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



    public void dealCard(Player player) {
        player.cards().add(deck.cards().remove(1));
    }

    public List<Player> players() {
        return players;
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

    public void setPlayerBlocksAction(int playerBlocking) {
        this.targetPlayerBlockAction = player(playerBlocking);
    }

    public void doPlayerCallingTheBluffOnTheAction(int playerCallingTheBluff, int lastPlayerDoingAnAction, Action action) throws Exception {
        this.playerCallingTheBluff = player(playerCallingTheBluff);
        this.lastPlayerDoingAnAction = player(lastPlayerDoingAnAction);
        action.doCallTheBluffOnTheAction(this);
    }

    public void doPlayerCallingTheBluffOnTheBlockAction(int playerCallingTheBluff, int lastPlayerDoingAnAction, Action action) throws Exception {
        this.playerCallingTheBluff = player(playerCallingTheBluff);
        this.lastPlayerDoingAnAction = player(lastPlayerDoingAnAction);
        action.doCallTheBluffOnTheBlockAction(this);
    }

    public void assassinatePlayer() {
        targetPlayerForAssasination.assassinate();
    }

    public void recoverPlayer() {
        targetPlayerForAssasination.recover();
    }

    public void killPlayer(int player) {
        player(player).dies();
    }

    public int whoIsTheWinner() {

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
            return players().indexOf(winner) + 1;
        } else return -1;

    }

    public void doAction(Action action) throws Exception {
        action.doAction(this);
    }

    public void doBlockAction(Action action) throws Exception {
        action.doBlockAction(this);
    }


}
