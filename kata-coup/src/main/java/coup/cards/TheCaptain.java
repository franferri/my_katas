package coup.cards;

import coup.Card;
import coup.actions.Steal;

public class TheCaptain extends Card {

    public  String name = "Ambassator";

    public TheCaptain() {
        this.action = new Steal();
        this.blocks = new Steal();
    }

}
