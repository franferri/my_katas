package simulation;

import coup.Card;
import coup.Game;
import coup.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomGameShould {

    private Game game;

    private int actions = 7;
    Random random = new Random();

    public int randomize() {
        int weHaveAWinner;

        checkGameStatus(game);

        int randomAction = random.nextInt(actions);
        int targetedPlayer;
        switch (randomAction) {
            case 0:
                game.playerTakesIncomeFromTreasury();
                break;
            case 1:
                game.playerTakesForeignAidFromTreasury();
                break;
            case 2:
                targetedPlayer = random.nextInt(game.gameEngine().playersStillInTheGame());
                game.playerCoups7(targetedPlayer + 1);
                break;
            case 3:
                targetedPlayer = random.nextInt(game.gameEngine().playersStillInTheGame());
                game.playerCoups10(targetedPlayer + 1);
                break;
            case 4:
                game.playerTakesTaxesFromTreasury();
                break;
            case 5:
                targetedPlayer = random.nextInt(game.gameEngine().playersStillInTheGame());
                game.playerAssassinates(targetedPlayer + 1);
                break;
            case 6:
                game.playerExchangesCardsFromTheCourtDeck();
                break;
            case 7:
                targetedPlayer = random.nextInt(game.gameEngine().playersStillInTheGame());
                game.playerStealsFrom(targetedPlayer + 1);
                break;

            default:
                throw new RuntimeException(randomAction + " is not a valid action to do");
        }

        assertGame(game);
        weHaveAWinner = game.gameEngine().whoIsTheWinner();
        if (weHaveAWinner > -1) return weHaveAWinner;

        int randomChallenge = random.nextInt(2);
        int playerCallingTheBluff;
        int playerBlocking;
        if (randomChallenge == 1) {
            checkGameStatus(game);
            playerCallingTheBluff = random.nextInt(game.gameEngine().playersStillInTheGame());
            game.playerCallsTheBluff(playerCallingTheBluff + 1);
            assertGame(game);
            weHaveAWinner = game.gameEngine().whoIsTheWinner();
            if (weHaveAWinner > -1) return weHaveAWinner;

        } else {

            int randomBlock = random.nextInt(2);
            if (randomBlock == 1) {
                checkGameStatus(game);
                playerBlocking = random.nextInt(game.gameEngine().playersStillInTheGame());
                game.playerBlocks(playerBlocking + 1);
                assertGame(game);
                weHaveAWinner = game.gameEngine().whoIsTheWinner();
                if (weHaveAWinner > -1) return weHaveAWinner;

            } else {

                randomChallenge = random.nextInt(2);
                if (randomChallenge == 1) {
                    checkGameStatus(game);
                    playerCallingTheBluff = random.nextInt(game.gameEngine().playersStillInTheGame());
                    game.playerCallsTheBluff(playerCallingTheBluff + 1);
                    assertGame(game);
                    weHaveAWinner = game.gameEngine().whoIsTheWinner();
                    if (weHaveAWinner > -1) return weHaveAWinner;

                }

            }

        }

        return weHaveAWinner;
    }

    @BeforeEach
    void before() {
    }

    @Test
    void randomPlay() {

        for (int i = 0; i < 250; i++) { // We play with all available onlinePlayers setup

            System.out.println("Game " + i);

            int players = random.nextInt(5);

            // given
            game = new Game();

            for (int j = 0; j < players + 2; j++) {
                game.gameEngine().addPlayer();
            }

            game.gameEngine().startGame();

            int weHaveAWinner = -1;
            while (weHaveAWinner < 0) {

                try {
                    weHaveAWinner = randomize();
                    System.out.println("Winner: " + weHaveAWinner);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                    if (e.getMessage().equals("Treasury depleted")) continue;
                    if (e.getMessage().equals("Player cant block himself")) continue;
                    if (e.getMessage().equals("This action can't be challenged")) continue;
                    if (e.getMessage().equals("Player don't have enough coins")) continue;
                    if (e.getMessage().equals("This action can't be blocked")) continue;
                    if (e.getMessage().equals("Action can't be done to himself")) continue;
                    if (e.getMessage().equals("Action bluff can't be called over himself")) continue;
                    if (e.getMessage().equals("Player must coup because has 10 or more coins")) continue;

                    e.printStackTrace();
                    assertTrue(false);
                }

            }

        }

    }

    private void checkGameStatus(Game game) {
        // Print the status

        List<Card> cards = game.gameEngine().deck().cards();
        List<Player> players = game.gameEngine().players;

        System.out.println("------------------------------------------");

        StringBuilder sb = new StringBuilder();
        sb.append("   Amount cards left in the deck: " + cards.size());

        HashMap<String, Integer> quantifiedCards = new HashMap<>();
        quantifiedCards.put("TheAmbassator", 0);
        quantifiedCards.put("TheAssassin", 0);
        quantifiedCards.put("TheCaptain", 0);
        quantifiedCards.put("TheContessa", 0);
        quantifiedCards.put("TheDuke", 0);

        Player player;
        for (int i = 0; i < players.size(); i++) {
            player = players.get(i);
            quantifyCards(player.cards(), quantifiedCards);
        }
        sb.append(", cards in players hands: ");

        sb.append("TheAmbassator " + quantifiedCards.get("TheAmbassator"));
        sb.append(", TheAssassin " + quantifiedCards.get("TheAssassin"));
        sb.append(", TheCaptain " + quantifiedCards.get("TheCaptain"));
        sb.append(", TheContessa " + quantifiedCards.get("TheContessa"));
        sb.append(", TheDuke " + quantifiedCards.get("TheDuke"));

        quantifyCards(cards, quantifiedCards);
        sb.append(", total cards in game: " + (quantifiedCards.get("TheAmbassator") + quantifiedCards.get("TheAssassin") + quantifiedCards.get("TheCaptain") + quantifiedCards.get("TheContessa") + quantifiedCards.get("TheDuke")));
        System.out.println(sb.toString());

        sb = new StringBuilder();
        int totalCoinsInGame = 0;
        totalCoinsInGame += game.gameEngine().treasury();
        sb.append("   Treasury coins: " + game.gameEngine().treasury());
        for (int i = 0; i < players.size(); i++) {
            player = players.get(i);
            totalCoinsInGame += player.coins();
            sb.append(", player " + i + ": " + player.coins());
        }
        sb.append(", total coins in game: " + totalCoinsInGame);
        System.out.println(sb.toString());

        System.out.println("   Current player playing: " + game.gameEngine().currentPlayerPlaying);
        //System.out.println("   Player doing the action: " + game.gameEngine().playerDoingTheAction.name());
        //System.out.println("   Player blocking the action: " + game.gameEngine().playerBlockingTheAction.name());
        //System.out.println("   Player challenging the action: " + game.gameEngine().playerCallingTheBluff.name());

    }

    private boolean assertGame(Game game) {

        // We need to assert, before and after the action:

        // * Amount of cards in the deck
        // * Cards in the deck are the ones not in play
        // * All onlinePlayers have 2 cards
        // * All kind of cards in game (3 dukes, 3...)

        // * Treasury remaining coins
        // * All onlinePlayers amount of coins
        // * Total coins in the board game

        // * Doing Action player, before and after cards kind, cards status and coins
        // * Challenging Action player, before and after cards kind, cards status and coins
        // * Blocking Action player, before and after cards kind, cards status and coins
        // * Challenging Blocking Action player, before and after cards kind, cards status and coins

        // * The rest of the players, before and after cards kind, cards status and coins

        // * Who is the next player playing (needs to be alive) or if we have a winner (if we have a winner this method ends the test)

        System.out.println("------------------------------------------");

        return true;

    }

    private void quantifyCards(List<Card> cards, HashMap<String, Integer> quantifiedCards) {

        Card currentCard;
        for (int i = 0; i < cards.size(); i++) {
            currentCard = cards.get(i);
            switch (currentCard.getClass().getSimpleName()) {
                case ("TheAmbassator"):
                    quantifiedCards.put("TheAmbassator", quantifiedCards.get("TheAmbassator") + 1);
                    break;
                case ("TheAssassin"):
                    quantifiedCards.put("TheAssassin", quantifiedCards.get("TheAssassin") + 1);
                    break;
                case ("TheCaptain"):
                    quantifiedCards.put("TheCaptain", quantifiedCards.get("TheCaptain") + 1);
                    break;
                case ("TheContessa"):
                    quantifiedCards.put("TheContessa", quantifiedCards.get("TheContessa") + 1);
                    break;
                case ("TheDuke"):
                    quantifiedCards.put("TheDuke", quantifiedCards.get("TheDuke") + 1);
                    break;
                default:
                    break;
            }
        }

    }

}
