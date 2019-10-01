package coup;

import coup.actions.Assassinate;
import coup.actions.Coup10;
import coup.actions.Coup7;
import coup.actions.Exchange;
import coup.actions.ForeignAid;
import coup.actions.Income;
import coup.actions.Steal;
import coup.actions.Tax;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the game itself.
 * As in a real game requires a table with treasury coins, a deck and players.
 * Also it has the allowed actions than the players can do during the game.
 */
public final class COUP {

    private TheTable theTable;

    private Action playerAction;

    private Rules rules;

    private final List<Player> players;

    public COUP() {
        theTable = new TheTable();
        rules = new Rules();
        players = new ArrayList<>();
    }

    public void actionPlayerTakesIncomeFromTreasury() {
        theTable.nextPlay();

        playerAction = new Income(theTable);
        playerAction.doAction();
    }

    public void actionPlayerTakesForeignAidFromTreasury() {
        theTable.nextPlay();

        playerAction = new ForeignAid(theTable);
        playerAction.doAction();
    }

    public void actionPlayerCoups7(final int targetedPlayer) {
        theTable.nextPlay(targetedPlayer);

        playerAction = new Coup7(theTable);
        playerAction.doAction();
    }

    public void actionPlayerCoups10(final int targetedPlayer) {
        theTable.nextPlay(targetedPlayer);

        playerAction = new Coup10(theTable);
        playerAction.doAction();
    }

    public void actionPlayerTakesTaxesFromTreasury() {
        theTable.nextPlay();

        playerAction = new Tax(theTable);
        playerAction.doAction();
    }

    public void actionPlayerAssassinates(final int targetedPlayer) {
        theTable.nextPlay(targetedPlayer);

        playerAction = new Assassinate(theTable);
        playerAction.doAction();
    }

    public void actionPlayerExchangesCardsFromTheCourtDeck() {
        theTable.nextPlay();

        playerAction = new Exchange(theTable);
        playerAction.doAction();
    }

    public void actionPlayerStealsFrom(final int targetedPlayer) {
        theTable.nextPlay(targetedPlayer);

        playerAction = new Steal(theTable);
        playerAction.doAction();
    }

    public void actionPlayerBlocks(final int playerBlocking) {
        theTable.setPlayerBlockingTheAction(theTable.player(playerBlocking));
        playerAction.doBlockAction();
    }

    public void actionPlayerCallsTheBluff(final int playerCallingTheBluff) {
        theTable.setPlayerCallingTheBluff(theTable.player(playerCallingTheBluff));

        if (playerAction.isBlocked()) {
            playerAction.doCallTheBluffOnBlockAction();
        } else {
            playerAction.doCallTheBluffOnAction();
        }
    }

    //TODO remove, just used in tests - https://stackoverflow.com/questions/6694715/junit-testing-private-variables
    public TheTable theTable() {
        return theTable;
    }

}
