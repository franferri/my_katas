package coup.network;

import java.util.ArrayList;
import java.util.List;

public class ASCIIArt {

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

    public static List<String> showWaitingTable() {

        // Given the amount of players connected, we show their allocations
        // For each player we "boldify" his location and keep it that way

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
        lines.add("[ PLAYER 1 ] |            |");
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

        lines.add(" ____________              ");
        lines.add("|            |     ____    ");
        lines.add("| ASSASSIN   |    /    \\   ");
        lines.add("|____________|   /  10  \\  ");
        lines.add(" ____________    \\  ISK /  ");
        lines.add("|            |    \\____/   ");
        lines.add("|            |             ");
        lines.add("|____________| [ PLAYER 2 ]");

        return lines;

    }

    public static String boldify(String textToBold) {
        String strNormalSize = "\033[0;0m";
        String strBoldSize = "\033[0;1m";
        return strBoldSize + textToBold + strNormalSize;
    }

    public static List<String> boldifyPlayer(List<String> player) {

        List<String> boldPlayer = new ArrayList<>();

        String strNormalSize = "\033[0;0m";
        String strBoldSize = "\033[0;1m";

        for (String line : player) {
            boldPlayer.add(strBoldSize + line + strNormalSize);
        }

        return boldPlayer;

    }

    // Para manipular la mesa necesitamos un método q genere espacio de 23lineas por 100 espacios
    // y metodos por player, que generen el player
    // y el método q reemplaza los caracteres, al final es un eje de coordenadas

    public static List<String> table() {

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

        List<String> player1 = addPlayerOneToTheTable();
        int player1_line = 1;
        int player1_column = 36;

        --player1_line;
        --player1_column;

        String newLine;
        int player1_iteration = 0;
        for (int i = 0; i < lines.size(); i++) {

            if (i >= player1_line && i < player1_line + player1.size()) {
                String prefix = lines.get(i).substring(0, player1_column);
                String suffix = lines.get(i).substring(player1_column + 1, lines.get(i).length() - 1);
                newLine = prefix + player1.get(player1_iteration) + suffix;
                ++player1_iteration;
                lines.remove(i);
                lines.add(i, newLine);
            }

        }

        List<String> player2 = boldifyPlayer(addPlayerTwoToTheTable());
        int player2_line = 17;
        int player2_column = 38;

        --player2_line;
        --player2_column;

        int player2_iteration = 0;
        for (int i = 0; i < lines.size(); i++) {

            if (i >= player2_line && i < player2_line + player2.size()) {
                String prefix = lines.get(i).substring(0, player2_column);
                String suffix = lines.get(i).substring(player2_column + 1, lines.get(i).length() - 1);
                newLine = prefix + player2.get(player2_iteration) + suffix;
                ++player2_iteration;
                lines.remove(i);
                lines.add(i, newLine);
            }

        }

        return lines;

    }

}
