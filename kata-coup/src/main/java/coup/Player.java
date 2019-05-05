package coup;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int coins = 0;
    private List<Card> cards = new ArrayList<>();

    public Player() {

    }

    public void addCoin() {
        ++coins;
    }

    public int coins() {
        return coins;
    }

    public List<Card> cards() {
        return cards;
    }

    public void dies() {
        cards().get(0).setVisible(true);
        cards().get(1).setVisible(true);
    }

    public boolean isDead() {
        return cards().get(0).isVisible() && cards().get(1).isVisible();
    }

}
