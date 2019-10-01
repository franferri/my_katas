package coup.cards;

import coup.actions.ForeignAid;
import coup.actions.Tax;

public class TheDuke extends Card {

    public TheDuke() {
        this.setAction(new Tax());
        this.setBlocks(new ForeignAid());
    }

}
