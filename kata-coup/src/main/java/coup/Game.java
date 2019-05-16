package coup;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    private int treasury;
    private Deck deck;

    public Player playerDoingTheAction;
    public Player playerBlockingTheAction;
    public Player playerCallingTheBluff;

    public Player targetPlayerForAssassination;
    public Player targetPlayerForStealing;

    public Game(Player... players) throws Exception {

        if (players.length < 2) {
            throw new Exception("Need more players");
        }

        if (players.length > 4) {
            throw new Exception("Only 4 players allowed");
        }

        for (Player player : players) {
            this.players.add(player);
        }

        treasury = 50;

        this.deck = new Deck();

    }

    public int treasury() {
        return treasury;
    }

    public Deck deck() {
        return deck;
    }

    public void startGame() throws Exception {

        for (Player player : players) {

            playerTakeCoinsFromTreasury(player, 2);

            dealCard(player);
            dealCard(player);
        }

        this.deck.shuffle();

    }

    public void playerReturnCoinsToTreasury(Player player, int coins) throws Exception {
        if (player.coins() < coins) {
            throw new Exception("Player don't have enough coins");
        }
        for (int i = 0; i < coins; i++) {
            player.looseCoin();
            ++treasury;
        }
    }

    public void playerTakeCoinsFromTreasury(Player player, int coins) throws Exception {
        if (treasury < coins) {
            throw new Exception("Treasury depleted");
        }
        for (int i = 0; i < coins; i++) {
            --treasury;
            player.gainCoin();
        }
    }

    public void playerTakesCoinsFromOtherPlayer(Player player_taking, Player player_losing, int coins) throws Exception {
        for (int i = 0; i < coins; i++) {
            player_losing.looseCoin();
            player_taking.gainCoin();
        }
    }

    private void dealCard(Player player) {
        player.cards().add(deck.cards().remove(1));
    }

    public List<Player> players() {
        return players;
    }

    public Player player(int player) {
        return players.get(--player);
    }

    public void playerLoosesCard(Player player) {
        player.looseCard();
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

    public void recoverPlayer() {
        targetPlayerForAssassination.recover();
    }

}
