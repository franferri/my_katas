package coup.network;

import coup.Game;
import coup.Player;

import java.io.IOException;
import java.net.ServerSocket;

public class COUPServer {

    private static Game game = new Game();

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java KKMultiServer <port number>");
            System.exit(1);
        }

        for (String line : TerminalView.welcome()) {
            System.out.println(line);
        }

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                Player player = new Player();
                COUPServerThread clientThread = new COUPServerThread(serverSocket.accept(), game, player);
                game.addPlayer(clientThread, player);
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }

}