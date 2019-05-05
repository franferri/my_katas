package coup;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();
    private int treasury;
    private Deck deck;

    public Game(Player... players) throws Exception {

        if (players.length < 2) {
            throw new Exception("Need more players");
        }

        if (players.length > 4) {
            throw new Exception("Only 4 players allowed");
        }

        this.deck = new Deck();

        for (Player player : players) {

            this.players.add(player);

            treasury += 10;

            addCoin(player);
            addCoin(player);

            dealCard(player);
            dealCard(player);
        }

    }

    public Deck deck() {
        return deck;
    }

    public List<Player> players() {
        return players;
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

}
