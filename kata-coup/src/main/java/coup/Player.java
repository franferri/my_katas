package coup;

import coup.actions.Exchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player {

    private int coins = 0;
    private final List<Card> cards = new ArrayList<>();

    private int lastCardLost = -1;

    public void gainCoin() {
        ++coins;
    }

    public void looseCoin() {
        --coins;
    }

    public int coins() {
        return coins;
    }

    public List<Card> cards() {
        return cards;
    }

    private String name;

    public Player() {
        this.name = System.nanoTime()+"";
    }

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void looseCard() { // What if there are no cards visible left?

        if (cardsInGame() > 1) {
            int card = new Random().nextInt(2);
            lastCardLost = card;
            cards().get(card).setVisible(true);
        } else {
            dies();
        }
    }

    public void restoreLostCard() throws Exception {
        if (lastCardLost < 0 || lastCardLost > 2) {
            throw new Exception("Card number/range is not valid");
        }
        cards().get(lastCardLost).setVisible(false);
    }

    public void dies() {
        cards().get(0).setVisible(true);
        cards().get(1).setVisible(true);
    }

    public boolean isDead() {
        return cards().get(0).isVisible() && cards().get(1).isVisible();
    }

    public Card returnActiveCardToCourtDeck() throws Exception {
        if (isDead()) {
            throw new Exception("Player is dead, don't have any visible cards");
        }

        for (int i = 0; i < cards.size(); i++) {
            if (!cards.get(i).isVisible()) {
                return cards.remove(i);
            }
        }

        return null;
    }

    public int cardsInGame() {

        int leftCards = 0;
        if (!cards().get(0).isVisible()) {
            ++leftCards;
        }
        if (!cards().get(1).isVisible()) {
            ++leftCards;
        }

        return leftCards;
    }

    public boolean canHeBlockTheAction(Action action) {

        for (Card card : cards) {

            if (null == card.blocksAction()) {
                continue;
            }

            Class classz = card.blocksAction().getClass();
            if (classz == null) return false;

            if (classz == action.getClass()) {
                return true;
            }

        }

        return false;

    }

    public boolean canHeDoTheAction(Action action) {

        List<Card> cardsToCheck = cards();

        if (action instanceof Exchange) {
            cardsToCheck = ((Exchange) action).originalCardsInPlayerHand;
        }

        for (Card card : cardsToCheck) {

            if (null == card.doAction()) {
                continue;
            }

            Class classz = card.doAction().getClass();
            if (classz == null) return false;

            if (classz == action.getClass()) {
                return true;
            }

        }

        return false;

    }

    public void shuffleCardsInHand() {
        Collections.shuffle(cards);
    }

    public static Player[] newPlayers(int players) {

        Player[] pool = new Player[players];

        for (int i = 0; i < players; i++) {
            pool[i] = new Player();
        }

        return pool;
    }
}
