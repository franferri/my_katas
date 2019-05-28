package coup.network;

import coup.Game;

import java.util.ArrayList;
import java.util.List;

public class COUPTerminalView {

    public static List<String> layout() {

        List<String> lines = new ArrayList<>();

        lines.add("___________________________________________________________________________________________________ ");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
        lines.add("                                                                                                   |");
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

    public static List<String> welcomeServer(Game game) {

        List<String> lines = new ArrayList<>();

        lines.add("Welcome to COUP Kata Server");
        lines.add("Users connected ["+game.players()+"]");
        lines.add("Recommended terminal size 100 columns x 30 lines");

        return lines;

    }

    public static List<String> welcomeClients() {

        List<String> lines = new ArrayList<>();

        lines.add("Welcome to COUP Kata");
        lines.add("Users connected [X], press ENTER to join");
        lines.add("Recommended terminal size 100 columns x 30 lines");

        return lines;

    }

    public static List<String> playerOne() {

        List<String> lines = new ArrayList<>();

        lines.add("              ____________ ");
        lines.add("[ PLAYER   ] |            |");
        lines.add("    ____     |            |");
        lines.add("   /    \\    |____________|");
        lines.add("  / 10   \\    ____________ ");
        lines.add("  \\  ISK /   |            |");
        lines.add("   \\____/    |            |");
        lines.add("             |____________|");

        return lines;

    }

    public static List<String> playerTwo() {

        List<String> lines = new ArrayList<>();

        lines.add("              ____________ ");
        lines.add("[ PLAYER   ] |            |");
        lines.add("    ____     |            |");
        lines.add("   /    \\    |____________|");
        lines.add("  / 10   \\    ____________ ");
        lines.add("  \\  ISK /   |            |");
        lines.add("   \\____/    |            |");
        lines.add("             |____________|");

        return lines;

    }

    public static List<String> playerThree() {

        List<String> lines = new ArrayList<>();

        lines.add("              ____________ ");
        lines.add("[ PLAYER   ] |            |");
        lines.add("    ____     |            |");
        lines.add("   /    \\    |____________|");
        lines.add("  / 10   \\    ____________ ");
        lines.add("  \\  ISK /   |            |");
        lines.add("   \\____/    |            |");
        lines.add("             |____________|");

        return lines;

    }

    public static List<String> playerFour() {

        List<String> lines = new ArrayList<>();

        lines.add("              ____________ ");
        lines.add("[ PLAYER   ] |            |");
        lines.add("    ____     |            |");
        lines.add("   /    \\    |____________|");
        lines.add("  / 10   \\    ____________ ");
        lines.add("  \\  ISK /   |            |");
        lines.add("   \\____/    |            |");
        lines.add("             |____________|");

        return lines;

    }

    public static List<String> playerFive() {

        List<String> lines = new ArrayList<>();

        lines.add("              ____________ ");
        lines.add("[ PLAYER   ] |            |");
        lines.add("    ____     |            |");
        lines.add("   /    \\    |____________|");
        lines.add("  / 10   \\    ____________ ");
        lines.add("  \\  ISK /   |            |");
        lines.add("   \\____/    |            |");
        lines.add("             |____________|");

        return lines;

    }

    public static List<String> playerSix() {

        List<String> lines = new ArrayList<>();

        lines.add("              ____________ ");
        lines.add("[ PLAYER   ] |            |");
        lines.add("    ____     |            |");
        lines.add("   /    \\    |____________|");
        lines.add("  / 10   \\    ____________ ");
        lines.add("  \\  ISK /   |            |");
        lines.add("   \\____/    |            |");
        lines.add("             |____________|");

        return lines;

    }

    public static String cleanTerminal() {
        return "\033[H\033[2J";
    }

    public static String normalize() {
        return "\033[0;0m";
    }

    public static String boldifyText(String textToBold) {
        String strNormalSize = "\033[0;0m";
        String strBoldSize = "\033[0;1m";
        return strBoldSize + textToBold + strNormalSize;
    }

    public static List<String> renderWelcomeScreenServer(Game game) {

        List<String> layout = new ArrayList<>(layout());

        List<String> logo = logo();
        int line = 3;
        int column = 3;

        placeInTheLayout(layout, logo, line, column);

        List<String> welcomeServerLines = welcomeServer(game);
        line = 27;
        for (int i = 0; i < welcomeServerLines.size(); i++) {
            column = (layout.get(line).length() - welcomeServerLines.get(i).length()) / 2;
            placeInTheLayout(layout, welcomeServerLines.get(i), line, column);
            ++line;
        }

        return layout;

    }

    public static List<String> renderWelcomeScreenClient() {

        List<String> layout = new ArrayList<>(layout());
        layout.remove(layout.size()-2);

        List<String> logo = logo();
        int line = 3;
        int column = 3;

        placeInTheLayout(layout, logo, line, column);

        List<String> welcomeServerLines = welcomeClients();
        line = 26;
        for (int i = 0; i < welcomeServerLines.size(); i++) {
            column = (layout.get(line).length() - welcomeServerLines.get(i).length()) / 2;
            placeInTheLayout(layout, welcomeServerLines.get(i), line, column);
            ++line;
        }

        layout.add("Player> "); // Line for the user to write
        return layout;

    }

    public static List<String> table(int players) {

        List<String> layout = new ArrayList<>(layout());
        layout.remove(layout.size()-2);

        // Add Player 1 to the table
        if (players >= 1) {
            List<String> player1 = playerOne();
            int player1_line = 3;
            int player1_column = 36;

            placeInTheLayout(layout, player1, player1_line, player1_column);
        }

        // Add Player 2 to the table
        if (players >= 2) {
            List<String> player2 = playerTwo();
            int player2_line = 19;
            int player2_column = 38;

            placeInTheLayout(layout, player2, player2_line, player2_column);
        }
        // Add Player 3 to the table
        if (players >= 3) {
            List<String> player3 = playerThree();
            int player3_line = 5;
            int player3_column = 69;

            placeInTheLayout(layout, player3, player3_line, player3_column);
        }
        // Add Player 4 to the table
        if (players >= 4) {
            List<String> player4 = playerFour();
            int player4_line = 15;
            int player4_column = 5;

            placeInTheLayout(layout, player4, player4_line, player4_column);
        }
        // Add Player 5 to the table
        if (players >= 5) {
            List<String> player5 = playerFive();
            int player5_line = 5;
            int player5_column = 5;

            placeInTheLayout(layout, player5, player5_line, player5_column);
        }
        // Add Player 6 to the table
        if (players == 6) {
            List<String> player6 = playerSix();
            int player6_line = 15;
            int player6_column = 69;

            placeInTheLayout(layout, player6, player6_line, player6_column);
        }

        layout.add("Player> "); // Line for the user to write
        return layout;

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
                String suffix = table.get(i).substring(inColumn + lineToAdd.length(), table.get(i).length() - 1);

                newLine = prefix + lineToAdd + suffix;
                newLine += "|";

                ++player_iteration;
                table.remove(i);
                table.add(i, newLine);
            }

        }
    }

}
