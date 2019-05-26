package coup.network;

import java.util.ArrayList;
import java.util.List;

public class TerminalView {

    public static List<String> welcome() {

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
        lines.add("Welcome to COUP Kata");

        return lines;

    }

    public static List<String> showCurrentTable() {

        // This class has to update the table based in the game info

        List<String> lines = new ArrayList<>();

        lines.add("                                                 ____________                                      ");
        lines.add("                                   [ PLAYER 1 ] |            |                                     ");
        lines.add("                                       ____     |            |                                     ");
        lines.add("                  ____________        /    \\    |____________|       ____________                  ");
        lines.add("    [ PLAYER 6 ] |            |      / 10   \\    ____________       |            | [ PLAYER 3 ]    ");
        lines.add("        ____     |            |      \\  ISK /   |            |      |            |     ____        ");
        lines.add("       /    \\    |____________|       \\____/    |            |      |____________|    /    \\       ");
        lines.add("      / 10   \\    ____________                  |____________|       ____________    / 10   \\      ");
        lines.add("      \\  ISK /   |            |                                     |            |   \\  ISK /      ");
        lines.add("       \\____/    | COMPTESA   |                                     | AMBASSADOR |    \\____/       ");
        lines.add("                 |____________|                                     |____________|                 ");
        lines.add("");
        lines.add("");
        lines.add("                  ____________                                       ____________                  ");
        lines.add("                 |            |                                     |            |                 ");
        lines.add("    [ PLAYER 5 ] |            |                                     |            | [ PLAYER 4 ]    ");
        lines.add("        ____     |____________|       ____________                  |____________|     ____        ");
        lines.add("       /    \\     ____________       |            |     ____         ____________     /    \\       ");
        lines.add("      / 10   \\   |            |      | ASSASSIN   |    /    \\       |            |   / 10   \\      ");
        lines.add("      \\  ISK /   | COMPTESA   |      |____________|   /  10  \\      | COMPTESA   |   \\  ISK /      ");
        lines.add("       \\____/    |____________|       ____________    \\  ISK /      |____________|    \\____/       ");
        lines.add("                                     |            |    \\____/                                      ");
        lines.add("                                     |            |                                                ");
        lines.add("                                     |____________| [ PLAYER 2 ]                                   ");

        return lines;

    }

    public static List<String> addPlayerOneToTheTable() {

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

    public static List<String> addPlayerTwoToTheTable() {

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

    public static List<String> addPlayerThreeToTheTable() {

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

    public static List<String> addPlayerFourToTheTable() {

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

    public static List<String> addPlayerFiveToTheTable() {

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

    public static List<String> addPlayerSixToTheTable() {

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

    public static String boldify(String textToBold) {
        String strNormalSize = "\033[0;0m";
        String strBoldSize = "\033[0;1m";
        return strBoldSize + textToBold + strNormalSize;
    }

    // Para manipular la mesa necesitamos un método q genere espacio de 23lineas por 100 espacios
    // y metodos por player, que generen el player
    // y el método q reemplaza los caracteres, al final es un eje de coordenadas

    public static List<String> table(int players) {

        List<String> lines = new ArrayList<>();

        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");
        lines.add("                                                                                                   ");

        // Add Player 1 to the table
        if (players >= 1) {
            List<String> player1 = addPlayerOneToTheTable();
            int player1_line = 1;
            int player1_column = 36;

            placeInTheTable(lines, player1, player1_line, player1_column);
        }

        // Add Player 2 to the table
        if (players >= 2) {
            List<String> player2 = addPlayerOneToTheTable();
            int player2_line = 17;
            int player2_column = 38;

            placeInTheTable(lines, player2, player2_line, player2_column);
        }
        // Add Player 3 to the table
        if (players >= 3) {
            List<String> player3 = addPlayerOneToTheTable();
            int player3_line = 3;
            int player3_column = 69;

            placeInTheTable(lines, player3, player3_line, player3_column);
        }
        // Add Player 4 to the table
        if (players >= 4) {
            List<String> player4 = addPlayerOneToTheTable();
            int player4_line = 13;
            int player4_column = 5;

            placeInTheTable(lines, player4, player4_line, player4_column);
        }
        // Add Player 5 to the table
        if (players >= 5) {
            List<String> player5 = addPlayerOneToTheTable();
            int player5_line = 3;
            int player5_column = 5;

            placeInTheTable(lines, player5, player5_line, player5_column);
        }
        // Add Player 6 to the table
        if (players == 6) {
            List<String> player6 = addPlayerOneToTheTable();
            int player6_line = 13;
            int player6_column = 69;

            placeInTheTable(lines, player6, player6_line, player6_column);
        }
        return lines;

    }

    private static void placeInTheTable(List<String> table, List<String> toAdd, int inLine, int inColumn) {
        String newLine;
        --inLine;
        --inColumn;

        int player_iteration = 0;
        for (int i = 0; i < table.size(); i++) {

            if (i >= inLine && i < inLine + toAdd.size()) {

                String lineToAdd = toAdd.get(player_iteration);

                String prefix = table.get(i).substring(0, inColumn);
                String suffix = table.get(i).substring(inColumn + lineToAdd.length(), table.get(i).length() - 1);

                newLine = prefix + lineToAdd + suffix;

                ++player_iteration;
                table.remove(i);
                table.add(i, newLine);
            }

        }
    }

}
