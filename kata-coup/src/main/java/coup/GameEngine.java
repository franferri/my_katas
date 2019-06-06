package coup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

    public final List<Player> players = new ArrayList<>();

    private int treasury;
    private Deck deck;

    public Player playerDoingTheAction;
    public Player playerBlockingTheAction;
    public Player playerCallingTheBluff;

    public Player targetPlayer;

    public GameEngine(Player... players)  {
        if (players.length < 2) {
            throw new RuntimeException("Need more onlinePlayers");
        }
        if (players.length > 6) {
            throw new RuntimeException("Only 6 onlinePlayers allowed");
        }

        Collections.addAll(this.players, players);

        treasury = 50;
        this.deck = new Deck();
        this.deck.shuffle();
    }

    public int treasury() {
        return treasury;
    }

    public Deck deck() {
        return deck;
    }

    public void startGame()  {
        for (Player player : players) {
            playerTakeCoinsFromTreasury(player, 2);
            dealCardsToThePlayer(player);
        }
    }

    public void playerReturnCoinsToTreasury(Player player, int coins)  {
        if (player.coins() < coins) {
            throw new RuntimeException("Player don't have enough coins");
        }
        for (int i = 0; i < coins; i++) {
            player.looseCoin();
            ++treasury;
        }
    }

    public void playerTakeCoinsFromTreasury(Player player, int coins)  {
        if (treasury < coins) {
            throw new RuntimeException("Treasury depleted");
        }
        for (int i = 0; i < coins; i++) {
            --treasury;
            player.gainCoin();
        }
    }

    public void playerTakesCoinsFromOtherPlayer(Player player_taking, Player player_losing, int coins)  {
        if (player_losing.coins() < coins) {
            throw new RuntimeException("Player is broke and we can't take more coins from it");
        }
        for (int i = 0; i < coins; i++) {
            player_losing.looseCoin();
            player_taking.gainCoin();
        }
    }

    public void dealCardsToThePlayer(Player player) {
        for (int i = 0; i < 2; i++) {
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

                if (nextPlayer > players.size()) {
                    nextPlayer = 1;
                }

            } else {
                currentPlayerPlaying = nextPlayer;
                return;
            }

        }

    }

    public int playersStillInTheGame() {
        int playersAlive = players.size();
        for (Player player : players) {
            if (player.isDead()) {
                --playersAlive;
            }
        }
        return playersAlive;
    }

    public void resetStatus() {
        playerBlockingTheAction = null;
        playerCallingTheBluff = null;
        targetPlayer = null;
    }

}
