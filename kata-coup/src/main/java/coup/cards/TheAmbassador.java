package coup.cards;

import coup.actions.Exchange;
import coup.actions.Steal;

public class TheAmbassador extends Card {

    public TheAmbassador() {
        this.setAction(new Exchange());
        this.setBlocks(new Steal());
    }

}
