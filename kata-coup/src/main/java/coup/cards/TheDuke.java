package coup.cards;

import coup.Card;
import coup.actions.ForeignAid;
import coup.actions.Tax;

public class TheDuke extends Card {

    public TheDuke() {
        this.action = new Tax();
        this.blocks = new ForeignAid();
    }

}
