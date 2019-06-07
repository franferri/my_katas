package coup.network;

import coup.Game;

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

    public static List<String> addNewPlayer() {

        List<String> patternOne = new ArrayList<>();
        patternOne.add("              ____________ ");
        patternOne.add("[  PLAYER  ] |            |");
        patternOne.add("    ____     |            |");
        patternOne.add("   /    \\    |____________|");
        patternOne.add("  / 10   \\    ____________ ");
        patternOne.add("  \\  ISK /   |            |");
        patternOne.add("   \\____/    |            |");
        patternOne.add("             |____________|");

        List<String> patternTwo = new ArrayList<>();
        patternTwo.add(" ____________              ");
        patternTwo.add("|            |     ____    ");
        patternTwo.add("| ASSASSIN   |    /    \\   ");
        patternTwo.add("|____________|   /  10  \\  ");
        patternTwo.add(" ____________    \\  ISK /  ");
        patternTwo.add("|            |    \\____/   ");
        patternTwo.add("|            |             ");
        patternTwo.add("|____________| [  PLAYER  ]");

        List<String> patternThree = new ArrayList<>();
        patternThree.add(" ____________              ");
        patternThree.add("|            | [  PLAYER  ]");
        patternThree.add("|            |     ____    ");
        patternThree.add("|____________|    /    \\   ");
        patternThree.add(" ____________    / 10   \\  ");
        patternThree.add("|            |   \\  ISK /  ");
        patternThree.add("| AMBASSADOR |    \\____/   ");
        patternThree.add("|____________|             ");

        List<String> patternFour = new ArrayList<>();
        patternFour.add(" ____________              ");
        patternFour.add("|            |             ");
        patternFour.add("|            | [  PLAYER  ]");
        patternFour.add("|____________|     ____    ");
        patternFour.add(" ____________     /    \\   ");
        patternFour.add("|            |   / 10   \\  ");
        patternFour.add("| COMPTESA   |   \\  ISK /  ");
        patternFour.add("|____________|    \\____/   ");

        List<String> patternFive = new ArrayList<>();
        patternFive.add("              ____________ ");
        patternFive.add("             |            |");
        patternFive.add("[  PLAYER  ] |            |");
        patternFive.add("    ____     |____________|");
        patternFive.add("   /    \\     ____________ ");
        patternFive.add("  / 10   \\   |            |");
        patternFive.add("  \\  ISK /   | COMPTESA   |");
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
        lines.add("Users connected [" + game.onlinePlayers() + "]");
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

    public static List<String> table(int players, String action, String targetPlayer, String block, String challenge) {

        List<String> layout = new ArrayList<>(layout());
        layout.remove(layout.size() - 2);

        int line;
        int column;

        // Add Player 1 to the table
        if (players >= 1) {
            List<String> player1 = addNewPlayer();
            line = 3;
            column = 36;

            placeInTheLayout(layout, player1, line, column);
        }

        // Add Player 2 to the table
        if (players >= 2) {
            List<String> player2 = addNewPlayer();
            line = 20;
            column = 38;

            placeInTheLayout(layout, player2, line, column);
        }

        // Add Player 3 to the table
        if (players >= 3) {
            List<String> player3 = addNewPlayer();
            line = 5;
            column = 70;

            placeInTheLayout(layout, player3, line, column);
        }

        // Add Player 4 to the table
        if (players >= 4) {
            List<String> player3 = addNewPlayer();
            line = 15;
            column = 5;

            placeInTheLayout(layout, player3, line, column);
        }

        // Add Player 5 to the table
        if (players >= 5) {
            List<String> player3 = addNewPlayer();
            line = 5;
            column = 5;

            placeInTheLayout(layout, player3, line, column);
        }

        // Add Player 6 to the table
        if (players >= 6) {
            List<String> player3 = addNewPlayer();
            line = 16;
            column = 70;

            placeInTheLayout(layout, player3, line, column);
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

        List<String> courtDeckTreasury = courtDeckTreasury(55, 88);
        line = 27;
        column = 76;
        placeInTheLayout(layout, courtDeckTreasury, line, column);

        layout.add(boldifyText("Player> ")); // Line for the user to write
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

        layout.add("Write your name [Max 8 characters]> "); // Line for the user to write
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
