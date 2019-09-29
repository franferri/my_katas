package coup.cards;

import coup.Card;
import coup.actions.Steal;

public class TheCaptain extends Card {

    public TheCaptain() {
        this.setAction(new Steal());
        this.setBlocks(new Steal());
    }

}
