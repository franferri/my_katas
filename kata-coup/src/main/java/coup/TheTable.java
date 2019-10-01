package coup;

import coup.coins.Coins;
import coup.coins.Treasury;
import coup.decks.CourtDeck;
import coup.decks.Deck;

import java.util.ArrayList;
import java.util.List;

public final class TheTable {

    private static final int MAX_PLAYERS = 6;
    private static final int MIN_PLAYERS = 2;

    private Treasury treasury;
    private CourtDeck courtDeck;

    private final List<Player> players = new ArrayList<>();

    private Player playerDoingTheAction;
    private Player playerBlockingTheAction;
    private Player playerCallingTheBluff;

    private Player targetPlayer;

    public TheTable() {
        treasury = new Treasury();

        courtDeck = new CourtDeck();
        courtDeck.shuffle();
    }

    public Coins treasury() {
        return treasury;
    }

    public Deck courtDeck() {
        return courtDeck;
    }

    public void startGame() {

        if (getPlayers().size() < MIN_PLAYERS) {
            throw new RuntimeException("Need more onlinePlayers");
        }
        if (getPlayers().size() > MAX_PLAYERS) {
            throw new RuntimeException("Only 6 onlinePlayers allowed");
        }

        for (Player player : getPlayers()) {
            playerTakeCoinsFromTreasury(player, 2);
            dealCardsToThePlayer(player);
        }

    }

    public Player addPlayer() {
        Player player = new Player();
        this.getPlayers().add(player);
        return player;
    }

    public void playerReturnCoinsToTreasury(final Player player, final int coins) {
        if (player.wallet().coins() < coins) {
            throw new RuntimeException("Player don't have enough coins");
        }
        for (int i = 0; i < coins; i++) {
            player.wallet().deal(1);
            treasury.receive(1);
        }
    }

    public void playerTakeCoinsFromTreasury(final Player player, final int coins) {
        if (treasury.coins() < coins) {
            throw new RuntimeException("Treasury depleted");
        }
        for (int i = 0; i < coins; i++) {
            treasury.deal(1);
            player.wallet().receive(1);
        }
    }

    public void playerTakesCoinsFromOtherPlayer(final Player playerTaking, final Player playerLosing, final int coins) {
        if (playerLosing.wallet().coins() < coins) {
            throw new RuntimeException("Player is broke and we can't take more coins from it");
        }
        for (int i = 0; i < coins; i++) {
            playerLosing.wallet().deal(1);
            playerTaking.wallet().receive(1);
        }
    }

    public void dealCardsToThePlayer(final Player player) {
        for (int i = 0; i < 2; i++) {
            player.influenceDeck().receiveScrambled(courtDeck.dealFromTheTop());
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

    public void nextPlay() {
        nextPlay(null);
    }

    public void nextPlay(final Integer targetedPlayer) {
        resetStatus();

        calculatePlayerPlaying();
        setPlayerDoingTheAction(player(getCurrentPlayerPlaying()));

        if (null != targetedPlayer) {
            setTargetPlayer(player(targetedPlayer));
        }

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
