package coup;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    public List<Player> players = new ArrayList<>();

    private int treasury;
    private Deck deck;

    public Player playerDoingTheAction;
    public Player playerBlockingTheAction;
    public Player playerCallingTheBluff;

    public Player targetPlayer;

    public GameEngine(Player... players) throws Exception {
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
            dealCardsToThePlayer(player, 2);
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
        if (player_losing.coins() < coins) {
            throw new Exception("Player is broke and we can't take more coins from it");
        }
        for (int i = 0; i < coins; i++) {
            player_losing.looseCoin();
            player_taking.gainCoin();
        }
    }

    private void dealCardsToThePlayer(Player player, int cards) {
        for (int i = 0; i < cards; i++) {
            player.cards().add(deck.cards().remove(0));
        }
    }

    public Player player(int player) {
        return players.get(--player);
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
            return players.indexOf(winner) + 1;
        } else return -1;
    }

    public int currentPlayerPlaying = 0;

    public void calculatePlayerPlaying() {

        int nextPlayer = ++currentPlayerPlaying;

        if (nextPlayer > players.size()) {
            nextPlayer = 1;
        }

        for (int i = 0; i < players.size(); i++) {

            if (player(nextPlayer).isDead()) {
                ++nextPlayer;
            } else {
                currentPlayerPlaying = nextPlayer;
                return;
            }

        }

    }

    public void resetStatus() {
        playerBlockingTheAction = null;
        playerCallingTheBluff = null;
        targetPlayer = null;
    }

}
