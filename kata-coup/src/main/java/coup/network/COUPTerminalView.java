package coup.network;

import coup.Game;
import coup.GameEngine;
import coup.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class COUPTerminalView {

    private static Random random = new Random();

    public static List<String> layout() {

        List<String> lines = new ArrayList<>();

        lines.add("___________________________________________________________________________________________________ ");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("|                                                                                                  |");
        lines.add("___________________________________________________________________________________________________|");

        return lines;

    }

    public static List<String> logo() {

        List<String> lines = new ArrayList<>();

        lines.add(" @@@@####@@@@@@#@@@@    @@@@@@@@#@@#@@##@@@.  #@@@@           @@@@@   @@@@@@@@@@#@@@@##@@:");
        lines.add("##++++++++++###+#+++@   ###+###++#+++++#+#+@  ###++           @++++  .#####+###+++#++#+++#");
        lines.add("@+++#++++#++##++##++#  @###+##++##+++++###++  ##+++           @++++  ++++##+###++++++++##+");
        lines.add("@++#+++++#++#+#+#++#+  @#+#+##+++++++++#++++  ##+#+           @++++  ++++##+###++++++#++++");
        lines.add("@++++#####+#@####+++#  @#+#+####+########+#+  ##+#+           @+#++  +++#++#@#@##+#@#+++++");
        lines.add("@++++           ##+++  @###+,          @#+#+  ##+#+           @++++  +++##           @++++");
        lines.add("@++++.                 @#+#+,          @#+++  #++#+           @++++  +++##           @++++");
        lines.add("@++++.                 @+##+,          @++++  ##+#+           @++++  +++#+           @++++");
        lines.add("@++++.                 @++#+,          @++++  #++++           @++++  +++#++          @++++");
        lines.add("@++++.                 @+##+,          @++++  #++++           @+++#  +++#+           @++++");
        lines.add("@++++.                 @+##+,          @#+#+  ##+#+           @+#++  +++#+         ::@++++");
        lines.add("@++++.      @          @++#+,          @#+#+  #+++#           @++++  +++##        :  @++++");
        lines.add("@+++++###### @ @       @+##+#############+++  #++#+############++++  +++##       :+###++++");
        lines.add("@+++++####### @ @      @+##+###########+#+#+  #++#++##########++#++  +++##     @:+@###++++");
        lines.add("@++++++++++++# @ @     @+##+#+++++++++++++++  #++#+++#+++++++++++++  +++++    @,#@+++#++++");
        lines.add("@+++++++++++++#.@ @    @+##+++++++++++++++++  #++++++#+++++++++++++  +++++   @,#@++++#++++");
        lines.add(" ++++++++++++++#.@ @    +##+#++++++++++++#+@   ++++++#++++++++++++#  +++++  @,#@+++++#+++@");
        lines.add("                                                                     +++++                ");
        lines.add("                                                                     ++++#                ");
        lines.add("                                                                     +++##                ");
        lines.add("                                                                     ++++#                ");
        lines.add("                                                                     +++++                ");
        lines.add("                                                                     ++++#                ");

        return lines;

    }

    public static List<String> addNewPlayer(String playerName, int coins, String card1, String card2) {

        if (null == playerName) {
            playerName = "ERROR";
        }

        boolean rightSide = true;
        for (int i = playerName.length(); i < 8; i++) {

            if (rightSide) {
                playerName = playerName + " ";
                rightSide = false;
            } else {
                playerName = " " + playerName;
                rightSide = true;
            }

        }

        String isks = Integer.toString(coins);
        for (int i = isks.length(); i < 2; i++) {
            isks = isks + " ";
        }

        rightSide = true;
        for (int i = card1.length(); i < 10; i++) {

            if (rightSide) {
                card1 = card1 + " ";
                rightSide = false;
            } else {
                card1 = " " + card1;
                rightSide = true;
            }

        }

        rightSide = true;
        for (int i = card2.length(); i < 10; i++) {

            if (rightSide) {
                card2 = card2 + " ";
                rightSide = false;
            } else {
                card2 = " " + card2;
                rightSide = true;
            }

        }

        List<String> patternOne = new ArrayList<>();
        patternOne.add("              ____________ ");
        patternOne.add("[ " + playerName + " ] |            |");
        patternOne.add("    ____     | " + card1 + " |");
        patternOne.add("   /    \\    |____________|");
        patternOne.add("  / " + isks + "   \\    ____________ ");
        patternOne.add("  \\  ISK /   |            |");
        patternOne.add("   \\____/    | " + card1 + " |");
        patternOne.add("             |____________|");

        List<String> patternTwo = new ArrayList<>();
        patternTwo.add(" ____________              ");
        patternTwo.add("|            |     ____    ");
        patternTwo.add("| " + card1 + " |    /    \\   ");
        patternTwo.add("|____________|   / " + isks + "   \\  ");
        patternTwo.add(" ____________    \\  ISK /  ");
        patternTwo.add("|            |    \\____/   ");
        patternTwo.add("| " + card1 + " |             ");
        patternTwo.add("|____________| [ " + playerName + " ]");

        List<String> patternThree = new ArrayList<>();
        patternThree.add(" ____________              ");
        patternThree.add("|            | [ " + playerName + " ]");
        patternThree.add("| " + card1 + " |     ____    ");
        patternThree.add("|____________|    /    \\   ");
        patternThree.add(" ____________    / " + isks + "   \\  ");
        patternThree.add("|            |   \\  ISK /  ");
        patternThree.add("| " + card1 + " |    \\____/   ");
        patternThree.add("|____________|             ");

        List<String> patternFour = new ArrayList<>();
        patternFour.add(" ____________              ");
        patternFour.add("|            |             ");
        patternFour.add("| " + card1 + " | [ " + playerName + " ]");
        patternFour.add("|____________|     ____    ");
        patternFour.add(" ____________     /    \\   ");
        patternFour.add("|            |   / " + isks + "   \\  ");
        patternFour.add("| " + card1 + " |   \\  ISK /  ");
        patternFour.add("|____________|    \\____/   ");

        List<String> patternFive = new ArrayList<>();
        patternFive.add("              ____________ ");
        patternFive.add("             |            |");
        patternFive.add("[ " + playerName + " ] | " + card1 + " |");
        patternFive.add("    ____     |____________|");
        patternFive.add("   /    \\     ____________ ");
        patternFive.add("  / " + isks + "   \\   |            |");
        patternFive.add("  \\  ISK /   | " + card1 + " |");
        patternFive.add("   \\____/    |____________|");

        List<List<String>> patterns = new ArrayList<>();
        patterns.add(patternOne);
        patterns.add(patternTwo);
        patterns.add(patternThree);
        patterns.add(patternFour);
        patterns.add(patternFive);

        int randomNumber = random.nextInt(patterns.size());

        return patterns.get(randomNumber);

    }

    public static List<String> welcomeServer(Game game) {

        List<String> lines = new ArrayList<>();

        lines.add(boldifyText("Welcome to COUP Kata Server"));
        lines.add("Users connected [" + COUPServer.game.gameEngine().players.size() + "]");
        lines.add("Recommended terminal size 100 columns x 30 lines");

        return lines;

    }

    public static List<String> welcomeClients() {

        List<String> lines = new ArrayList<>();

        lines.add("Welcome to COUP Kata");
        lines.add(boldifyText("Write your name and press ENTER to join the play"));
        lines.add("Resize your terminal to 100 columns x 30 lines");

        return lines;

    }

    public static List<String> welcomeClientsServerFull() {

        List<String> lines = new ArrayList<>();

        lines.add("Welcome to COUP Kata");
        lines.add("");
        lines.add(boldifyText("All seats are taken in the table"));

        return lines;

    }

    public static List<String> welcomeClientsWaitingForAtLeastAnotherPlayer() {

        List<String> lines = new ArrayList<>();

        lines.add("Welcome to COUP Kata");
        lines.add("");
        lines.add(boldifyText("Waiting for another player needed to open the table"));

        return lines;

    }

    public static List<String> winner(Game game) {

        List<String> lines = new ArrayList<>();

        lines.add(boldifyText("The Winner is: XXXXX"));

        return lines;

    }

    public static List<String> unexpectedCommand() {

        List<String> lines = new ArrayList<>();

        lines.add(boldifyText("Unexpected command"));

        return lines;

    }

    public static List<String> table(Game game, String action, String targetPlayer, String block, String challenge) {

        List<String> layout = new ArrayList<>(layout());
        layout.remove(layout.size() - 2);

        int line;
        int column;

        Player aPlayer;
        String card1 = "";
        String card2 = "";

        // Add Player 1 to the table
        if (game.gameEngine().players.size() >= 1) {
            aPlayer = game.gameEngine().player(1);
            if (game.gameEngine().isStarted) {
                if (aPlayer.cards().get(0).isVisible()) {
                    card1 = aPlayer.cards().get(0).name;
                } else {
                    card1 = "";
                }
                if (aPlayer.cards().get(1).isVisible()) {
                    card2 = aPlayer.cards().get(1).name;
                } else {
                    card2 = "";
                }
            }
            List<String> player = addNewPlayer(aPlayer.name(), aPlayer.coins(), card1, card2);
            line = 3;
            column = 36;

            placeInTheLayout(layout, player, line, column);
        }

        // Add Player 2 to the table
        if (game.gameEngine().players.size() >= 2) {
            aPlayer = game.gameEngine().player(2);
            if (game.gameEngine().isStarted) {
                if (aPlayer.cards().get(0).isVisible()) {
                    card1 = aPlayer.cards().get(0).name;
                } else {
                    card1 = "";
                }
                if (aPlayer.cards().get(1).isVisible()) {
                    card2 = aPlayer.cards().get(1).name;
                } else {
                    card2 = "";
                }
            }
            List<String> player = addNewPlayer(aPlayer.name(), aPlayer.coins(), card1, card2);
            line = 20;
            column = 38;

            placeInTheLayout(layout, player, line, column);
        }

        // Add Player 3 to the table
        if (game.gameEngine().players.size() >= 3) {
            aPlayer = game.gameEngine().player(3);
            if (game.gameEngine().isStarted) {
                if (aPlayer.cards().get(0).isVisible()) {
                    card1 = aPlayer.cards().get(0).name;
                } else {
                    card1 = "";
                }
                if (aPlayer.cards().get(1).isVisible()) {
                    card2 = aPlayer.cards().get(1).name;
                } else {
                    card2 = "";
                }
            }
            List<String> player = addNewPlayer(aPlayer.name(), aPlayer.coins(), card1, card2);
            line = 5;
            column = 70;

            placeInTheLayout(layout, player, line, column);
        }

        // Add Player 4 to the table
        if (game.gameEngine().players.size() >= 4) {
            aPlayer = game.gameEngine().player(4);
            if (game.gameEngine().isStarted) {
                if (aPlayer.cards().get(0).isVisible()) {
                    card1 = aPlayer.cards().get(0).name;
                } else {
                    card1 = "";
                }
                if (aPlayer.cards().get(1).isVisible()) {
                    card2 = aPlayer.cards().get(1).name;
                } else {
                    card2 = "";
                }
            }
            List<String> player = addNewPlayer(aPlayer.name(), aPlayer.coins(), card1, card2);
            line = 15;
            column = 5;

            placeInTheLayout(layout, player, line, column);
        }

        // Add Player 5 to the table
        if (game.gameEngine().players.size() >= 5) {
            aPlayer = game.gameEngine().player(5);
            if (game.gameEngine().isStarted) {
                if (aPlayer.cards().get(0).isVisible()) {
                    card1 = aPlayer.cards().get(0).name;
                } else {
                    card1 = "";
                }
                if (aPlayer.cards().get(1).isVisible()) {
                    card2 = aPlayer.cards().get(1).name;
                } else {
                    card2 = "";
                }
            }
            List<String> player = addNewPlayer(aPlayer.name(), aPlayer.coins(), card1, card2);
            line = 5;
            column = 5;

            placeInTheLayout(layout, player, line, column);
        }

        // Add Player 6 to the table
        if (game.gameEngine().players.size() >= 6) {
            aPlayer = game.gameEngine().player(6);
            if (game.gameEngine().isStarted) {
                if (aPlayer.cards().get(0).isVisible()) {
                    card1 = aPlayer.cards().get(0).name;
                } else {
                    card1 = "";
                }
                if (aPlayer.cards().get(1).isVisible()) {
                    card2 = aPlayer.cards().get(1).name;
                } else {
                    card2 = "";
                }
            }
            List<String> player = addNewPlayer(aPlayer.name(), aPlayer.coins(), card1, card2);
            line = 16;
            column = 70;

            placeInTheLayout(layout, player, line, column);
        }

        int additionalSpacer = 0;
        List<String> actionText = play(action);
        line = 13;
        column = 35;
        placeInTheLayout(layout, actionText, line, column);

        if (null != targetPlayer && !"".equals(targetPlayer)) {
            List<String> targetPlayerText = play(targetPlayer);
            line = 14;
            column = 37;
            placeInTheLayout(layout, targetPlayerText, line, column);
            ++additionalSpacer;
        }

        if (null != block && !"".equals(block)) {

            List<String> blockText = play(block);
            line = 15 + additionalSpacer;
            column = 35;

            placeInTheLayout(layout, blockText, line, column);

            if (null != challenge && !"".equals(challenge)) {
                List<String> challengeText = play(challenge);
                line = 17 + additionalSpacer;
                column = 35;

                placeInTheLayout(layout, challengeText, line, column);
            }

        } else {

            if (null != challenge && !"".equals(challenge)) {
                List<String> challengeText = play(challenge);
                line = 15 + additionalSpacer;
                column = 35;

                placeInTheLayout(layout, challengeText, line, column);
            }

        }

        List<String> courtDeckTreasury = courtDeckTreasury(game.gameEngine().deck().cards().size(), game.gameEngine().treasury());
        line = 27;
        column = 76;
        placeInTheLayout(layout, courtDeckTreasury, line, column);

        return layout;

    }

    public static List<String> commandLineWaitingForTheGameToStart() {
        List<String> layout = new ArrayList<>();
        layout.add(boldifyText("Write \"start\" to start the game> "));
        return layout;
    }

    public static List<String> commandLineInGameWaitingForPlayerAction(Game game) {
        List<String> layout = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("[1] Income");
        sb.append(", ");
        sb.append("[2] Foreign Aid");
        sb.append(", ");
        sb.append("[3] Coup");
        sb.append(", ");
        sb.append("[4] Tax");
        sb.append(", ");
        sb.append("[5] Assassinate");
        sb.append(", ");
        sb.append("[6] Exchange");
        sb.append(", ");
        sb.append("[7] Steal");

        layout.add(sb.toString());

        return layout;
    }

    public static List<String> commandLineInGame(Game game) {
        List<String> layout = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("Player ");
        sb.append(game.gameEngine().playerDoingTheAction.name());
        sb.append(" is thinking his next move...");
        layout.add(sb.toString());

        return layout;
    }

    public static List<String> commandPostAction(Game game) {
        List<String> layout = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("[1] Challenge");
        sb.append(", ");
        sb.append("[2] Block");
        sb.append(", ");
        sb.append("[3] Let it pass");

        layout.add(sb.toString());

        return layout;
    }

    public static List<String> commandPostPostAction(Game game) {
        List<String> layout = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("[1] Challenge");
        sb.append(", ");
        sb.append("[2] Let it pass");

        layout.add(sb.toString());

        return layout;
    }

    public static List<String> commandLinePlayers(Game game) {
        List<String> layout = new ArrayList<>();

        // TODO: remove himself and list only players still in the game
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= game.gameEngine().players.size(); i++) {
            sb.append("[");
            sb.append(i);
            sb.append("] ");
            sb.append(game.gameEngine().player(i).name());
            sb.append(", ");
        }

        layout.add(boldifyText(sb.toString()));

        return layout;
    }

    public static String cleanTerminal() {
        return "\033[H\033[2J";
    }

    public static String normalize() {
        return "\033[0;0m";
    }

    public static String boldifyText(String textToBold) {

        String strBoldSize = "\033[0;1m";
        String strNormalSize = "\033[0;0m";

        String output = "";

        boolean boldifying = false;
        for (int i = 0; i < textToBold.length(); i++) {

            if (textToBold.charAt(i) == ' ') {

                if (boldifying) {
                    output += strNormalSize + textToBold.charAt(i);
                    boldifying = false;
                } else {
                    output += textToBold.charAt(i);
                }

            } else {

                if (!boldifying) {
                    output += strBoldSize + textToBold.charAt(i);
                    boldifying = true;
                } else {
                    output += textToBold.charAt(i);
                }

            }

        }

        return output + strNormalSize;
    }

    public static List<String> renderWinner(Game game) {

        List<String> layout = new ArrayList<>(layout());

        List<String> logo = winner(game);
        int line = 3;
        int column = 6;

        placeInTheLayout(layout, logo, line, column);

        return layout;

    }

    public static List<String> renderError() {

        List<String> layout = new ArrayList<>(layout());

        List<String> logo = unexpectedCommand();
        int line = 3;
        int column = 6;

        placeInTheLayout(layout, logo, line, column);

        return layout;

    }

    public static List<String> renderWelcomeScreenServer(Game game) {

        List<String> layout = new ArrayList<>(layout());

        List<String> logo = logo();
        int line = 3;
        int column = 6;

        placeInTheLayout(layout, logo, line, column);

        List<String> lines = welcomeServer(game);
        line = 27;
        int lineLength;
        for (int i = 0; i < lines.size(); i++) {
            lineLength = lengthWithtoutEffects(lines.get(i));
            column = (layout.get(line).length() - lineLength) / 2;
            placeInTheLayout(layout, lines.get(i), line, column);
            ++line;
        }
        return layout;

    }

    public static List<String> renderWelcomeScreenClient() {

        List<String> layout = new ArrayList<>(layout());
        layout.remove(layout.size() - 2);

        List<String> logo = logo();
        int line = 3;
        int column = 6;

        placeInTheLayout(layout, logo, line, column);

        List<String> lines = welcomeClients();
        line = 26;
        int lineLength;
        for (int i = 0; i < lines.size(); i++) {
            lineLength = lengthWithtoutEffects(lines.get(i));
            column = (layout.get(line).length() - lineLength) / 2;
            placeInTheLayout(layout, lines.get(i), line, column);
            ++line;
        }

        layout.add("Write your name when ready to joing [Max 8 characters]> "); // Line for the user to write
        return layout;

    }

    public static List<String> renderWelcomeScreenClientServerIsFull() {

        List<String> layout = new ArrayList<>(layout());
        layout.remove(layout.size() - 2);

        List<String> logo = logo();
        int line = 3;
        int column = 6;

        placeInTheLayout(layout, logo, line, column);

        List<String> lines = welcomeClientsServerFull();
        line = 26;
        int lineLength;
        for (int i = 0; i < lines.size(); i++) {
            lineLength = lengthWithtoutEffects(lines.get(i));
            column = (layout.get(line).length() - lineLength) / 2;
            placeInTheLayout(layout, lines.get(i), line, column);
            ++line;
        }

        return layout;

    }

    public static List<String> renderWelcomeScreenClientWaitingForAtLeastAnotherPlayer() {

        List<String> layout = new ArrayList<>(layout());
        layout.remove(layout.size() - 2);

        List<String> logo = logo();
        int line = 3;
        int column = 6;

        placeInTheLayout(layout, logo, line, column);

        List<String> lines = welcomeClientsWaitingForAtLeastAnotherPlayer();
        line = 26;
        int lineLength;
        for (int i = 0; i < lines.size(); i++) {
            lineLength = lengthWithtoutEffects(lines.get(i));
            column = (layout.get(line).length() - lineLength) / 2;
            placeInTheLayout(layout, lines.get(i), line, column);
            ++line;
        }

        return layout;

    }

    public static List<String> play(String text) {
        List<String> lines = new ArrayList<>();
        lines.add(boldifyText(text));
        return lines;
    }

    public static List<String> courtDeckTreasury(int courtDeck, int treasury) {
        List<String> lines = new ArrayList<>();
        lines.add("Court deck: " + courtDeck + " cards");
        lines.add("Treasury: " + treasury + " ISK");
        return lines;
    }

    private static void placeInTheLayout(List<String> table, String toAdd, int inLine, int inColumn) {
        List<String> line = new ArrayList<>();
        line.add(toAdd);
        placeInTheLayout(table, line, inLine, inColumn);
    }

    private static void placeInTheLayout(List<String> table, List<String> toAdd, int inLine, int inColumn) {
        String newLine;
        --inLine;
        --inColumn;

        int player_iteration = 0;
        int tableLength = table.get(0).length();
        int remainingSpaces = 0;
        for (int i = 0; i < table.size(); i++) {

            if (i >= inLine && i < inLine + toAdd.size()) {

                String lineToAdd = toAdd.get(player_iteration);

                String prefix = table.get(i).substring(0, inColumn);
                int a = lengthWithtoutEffects(lineToAdd);
                int b = lineToAdd.length();
                String suffix = table.get(i).substring(inColumn + lengthWithtoutEffects(lineToAdd), table.get(i).length() - 1);

                newLine = prefix + lineToAdd + suffix;
                newLine += "|";

                ++player_iteration;
                table.remove(i);
                table.add(i, newLine);
            }

        }
    }

    private static int lengthWithtoutEffects(String lineToAdd) {
        // If toAdd has \33+5 chars, discount it from the size, since those are the colors for the terminal

        int length = 0;

        for (int i = 0; i < lineToAdd.length(); i++) {

            if (lineToAdd.charAt(i) == '\033') {
                i = i + 5;
                continue;
            }

            ++length;

        }

        return length;

    }

}
