package coup;

import coup.actions.Exchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player {

    private int coins = 0;
    private List<Card> cards = new ArrayList<>();

    private int lastCardLost = -1;

    public void blocks() {

    }

    public void callsTheBluff() {

    }

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

    public Card looseCard() { // What if there are no cards visible left?

        if (cardsInGame() > 1) {
            int card = new Random().nextInt(2);
            lastCardLost = card;
            cards().get(card).setVisible(true);
            return cards().get(card);
        } else {
            dies();
            return null;
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
        if (isDead()){
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

            if (null == card.blocksAction()) {continue;}

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

        if (action instanceof Exchange){
            cardsToCheck = ((Exchange)action).originalCardsInPlayerHand;
        }

        for (Card card : cardsToCheck) {

            if (null == card.doAction()) {continue;}

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
