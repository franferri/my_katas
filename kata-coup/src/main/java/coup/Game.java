package coup;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    private int treasury;
    private Deck deck;

    private Player playerDoingAction;
    private Player targetPlayer;
    private Player targetPlayerBlockAction;
    private Player targetPlayerCallsBluff;

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
    public Game setPlayerPlayingThisHand(int player) {
        playerDoingAction = player(player);
        return this;
    }
    public Player playerPlayingHand() {
        return playerDoingAction;
    }

    public void targetPlayer(int player) {
        targetPlayer = player(player);
    }

    public void targetPlayerBlocksAction() {
        targetPlayerBlockAction = targetPlayer;
    }

    public void targetPlayerCallsBluff() {
        targetPlayerCallsBluff = targetPlayer;
    }

    public void killPlayer (int player) {
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


}
