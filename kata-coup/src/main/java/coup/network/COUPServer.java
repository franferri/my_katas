package coup.network;

import coup.Game;
import coup.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

public class COUPServer {

    private static Game game = new Game();

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java -cp target/kata-coup-0.0.1-SNAPSHOT.jar coup.network.COUPServer <PORT NUMBER>");
            System.exit(1);
        }

        updateServerTerminal();

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {

            while (listening) {
                Player player = new Player();
                COUPServerNetworkListenerThread clientThread = new COUPServerNetworkListenerThread(serverSocket.accept(), game, player);
                game.addPlayer(clientThread, player);
                clientThread.start();
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

}