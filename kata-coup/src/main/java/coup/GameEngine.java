package coup;

import java.util.ArrayList;
import java.util.List;

public final class GameEngine {

    private static final int FIFTY = 50;
    private static final int SIX = 6;
    private static final int TWO = 2;

    private final List<Player> players = new ArrayList<>();

    private int treasury;
    private Deck deck;

    private Player playerDoingTheAction;
    private Player playerBlockingTheAction;
    private Player playerCallingTheBluff;

    private Player targetPlayer;

    public GameEngine() {
        treasury = FIFTY;
        this.deck = new Deck();
        this.deck.shuffle();
    }

    public int treasury() {
        return treasury;
    }

    public Deck deck() {
        return deck;
    }

    public void startGame() {

        if (getPlayers().size() < TWO) {
            throw new RuntimeException("Need more onlinePlayers");
        }
        if (getPlayers().size() > SIX) {
            throw new RuntimeException("Only 6 onlinePlayers allowed");
        }

        for (Player player : getPlayers()) {
            playerTakeCoinsFromTreasury(player, 2);
            dealCardsToThePlayer(player);
        }

    }

    public Player addPlayer(final String playerName) {
        Player player = new Player(playerName);
        this.getPlayers().add(player);
        return player;
    }

    public void playerReturnCoinsToTreasury(final Player player, final int coins) {
        if (player.coins() < coins) {
            throw new RuntimeException("Player don't have enough coins");
        }
        for (int i = 0; i < coins; i++) {
            player.looseCoin();
            ++treasury;
        }
    }

    public void playerTakeCoinsFromTreasury(final Player player, final int coins) {
        if (treasury < coins) {
            throw new RuntimeException("Treasury depleted");
        }
        for (int i = 0; i < coins; i++) {
            --treasury;
            player.gainCoin();
        }
    }

    public void playerTakesCoinsFromOtherPlayer(final Player playerTaking, final Player playerLosing, final int coins) {
        if (playerLosing.coins() < coins) {
            throw new RuntimeException("Player is broke and we can't take more coins from it");
        }
        for (int i = 0; i < coins; i++) {
            playerLosing.looseCoin();
            playerTaking.gainCoin();
        }
    }

    public void dealCardsToThePlayer(final Player player) {
        for (int i = 0; i < 2; i++) {
            player.influenceDeck().add(deck.deal());
        }
    }

    public Player player(final int player) {
        return getPlayers().get(player - 1);
    }

    public int whoIsTheWinner() {
        int playersAlive = getPlayers().size();
        Player winner = null;
        for (Player player : getPlayers()) {
            if (player.isDead()) {
                --playersAlive;
            } else {
                winner = player;
            }
        }

        if (playersAlive == 1) {
            return getPlayers().indexOf(winner) + 1;
        } else {
            return -1;
        }
    }

    private int currentPlayerPlaying = 0;

    public void calculatePlayerPlaying() {

        int nextPlayer = getCurrentPlayerPlaying() + 1;

        if (nextPlayer > getPlayers().size()) {
            nextPlayer = 1;
        }

        for (int i = 0; i < getPlayers().size(); i++) {

            if (player(nextPlayer).isDead()) {
                ++nextPlayer;

                if (nextPlayer > getPlayers().size()) {
                    nextPlayer = 1;
                }

            } else {
                setCurrentPlayerPlaying(nextPlayer);
                return;
            }

        }

    }

    public int playersStillInTheGame() {
        int playersAlive = getPlayers().size();
        for (Player player : getPlayers()) {
            if (player.isDead()) {
                --playersAlive;
            }
        }
        return playersAlive;
    }

    public void resetStatus() {
        setPlayerDoingTheAction(null);
        setPlayerBlockingTheAction(null);
        setPlayerCallingTheBluff(null);
        setTargetPlayer(null);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerDoingTheAction() {
        return playerDoingTheAction;
    }

    public void setPlayerDoingTheAction(final Player playerDoingTheAction) {
        this.playerDoingTheAction = playerDoingTheAction;
    }

    public Player getPlayerBlockingTheAction() {
        return playerBlockingTheAction;
    }

    public void setPlayerBlockingTheAction(final Player playerBlockingTheAction) {
        this.playerBlockingTheAction = playerBlockingTheAction;
    }

    public Player getPlayerCallingTheBluff() {
        return playerCallingTheBluff;
    }

    public void setPlayerCallingTheBluff(final Player playerCallingTheBluff) {
        this.playerCallingTheBluff = playerCallingTheBluff;
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    public void setTargetPlayer(final Player targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    public int getCurrentPlayerPlaying() {
        return currentPlayerPlaying;
    }

    public void setCurrentPlayerPlaying(final int currentPlayerPlaying) {
        this.currentPlayerPlaying = currentPlayerPlaying;
    }
}
