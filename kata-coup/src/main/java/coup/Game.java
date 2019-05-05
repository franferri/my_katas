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

    public Game playerPlayingHand(int player) {
        playerDoingAction = players.get(player);
        return this;
    }

    public void targetPlayer(int player) {
        targetPlayer = players.get(player);
    }

    public void targetPlayerBlocksAction() {
        targetPlayerBlockAction = targetPlayer;
    }

    public void targetPlayerCallsBluff() {
        targetPlayerCallsBluff = targetPlayer;
    }

    public void doAction(Action action) {

    }

}
