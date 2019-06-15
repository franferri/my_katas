package coup.cards;

import coup.Card;
import coup.actions.Assassinate;

public class TheContessa extends Card {

    public  String name = "Contessa";

    public TheContessa() {
        this.blocks = new Assassinate();
    }

}
