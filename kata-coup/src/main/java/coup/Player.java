package coup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player {

    private int coins = 0;
    private List<Card> cards = new ArrayList<>();
    private int lastCardKilled = -1;

    public Player() {

    }

    public void addCoin() {
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

    public Card looseCard() { // What if there are no cards visible left?

        if (cardsInGame() > 1) {
            int card = new Random().nextInt(2);
            lastCardKilled = card;
            cards().get(card).setVisible(true);
            return cards().get(card);
        } else {
            dies();
            return null;
        }
    }

    public void recover() {
        cards().get(lastCardKilled).setVisible(false);
    }

    public void dies() {
        cards().get(0).setVisible(true);
        cards().get(1).setVisible(true);
    }

    public Card cardOne() {
        return cards().get(0);
    }

    public Card cardTwo() {
        return cards().get(1);
    }

    public boolean isDead() {
        return cards().get(0).isVisible() && cards().get(1).isVisible();
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



    public boolean canHeBlockAction(Action action) {

        for (Card card : cards) {

            Class classz = card.blocksAction().getClass();
            if (classz == null) return false;

            if (classz == action.getClass()) {
                return true;
            }

        }

        return false;

    }

    public boolean doesHaveTheCardToDoTheAction(Action action) {

        for (Card card : cards) {

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

}
