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

}
