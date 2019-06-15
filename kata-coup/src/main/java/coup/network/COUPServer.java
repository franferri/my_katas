package coup.network;

import coup.Game;
import coup.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class COUPServer {

    public static Game game = new Game();

    private static List<COUPServerNetworkListenerThread> onlinePlayersThreads = new ArrayList<>();

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java -cp target/kata-coup-0.0.1-SNAPSHOT.jar coup.network.COUPServer <PORT NUMBER>");
            System.exit(1);
        }

        updateServerTerminal();

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {

            int playerNumber = 1;
            while (listening) {

                // Server waits here till a new client connects
                Socket socket = serverSocket.accept();

                // Server does the following once a new client connect
                Player player = game.gameEngine().addPlayer("WAITING");

                COUPServerNetworkListenerThread clientThread = new COUPServerNetworkListenerThread(socket, playerNumber);
                onlinePlayersThreads.add(clientThread);

                clientThread.start();
                ++playerNumber;
            }

        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }

    public static void updateServerTerminal() {
        System.out.print(COUPTerminalView.cleanTerminal() + COUPTerminalView.normalize());
        List<String> lines = COUPTerminalView.renderWelcomeScreenServer(game);

        for (int i = 0; i < lines.size(); i++) {
            if (lines.size() == i + 1) {
                System.out.print(lines.get(i));
            } else {
                System.out.println(lines.get(i));
            }
        }

    }

    public static void playersThreadsUpdateTerminal(int playerToAvoid) {

        updateServerTerminal();

        for (COUPServerNetworkListenerThread clientThread : onlinePlayersThreads) {
            if (clientThread.playerNumber() != playerToAvoid) {
                clientThread.updateTerminal();
            }
        }

    }

}