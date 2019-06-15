package coup.cards;

import coup.Card;
import coup.actions.Exchange;
import coup.actions.Steal;

public class TheAmbassator extends Card {

    public  String name = "Ambassator";

    public TheAmbassator() {
        this.action = new Exchange();
        this.blocks = new Steal();
    }

}
