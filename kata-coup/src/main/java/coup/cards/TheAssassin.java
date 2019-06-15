package coup.cards;

import coup.Card;
import coup.actions.Assassinate;

public class TheAssassin extends Card {

    public  String name = "Assassin";

    public TheAssassin() {
        this.action = new Assassinate();
    }

}
