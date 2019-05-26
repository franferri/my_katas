package coup.network;

import coup.Game;
import coup.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class COUPServerThread extends Thread {

    private Socket socket;
    private Game game;

    private PrintWriter out;
    private BufferedReader in;

    private COUPServerProtocol protocol;

    public COUPServerThread(Socket socket, Game game, Player player) {
        super("COUPServerThread");
        this.socket = socket;
        this.game = game;

        protocol = new COUPServerProtocol(game, player);
    }

    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {

            this.out = out;
            this.in = in;

            String inputLine;
            List<String> outputLines;

            // Mandamos mensaje inicial al cliente
            outputLines = protocol.processInput(null);
            out.println("<META>" + outputLines.size() + "</META>");
            for (String line : outputLines) {
                out.println(line);
            }

            // Recibimos mensaje del cliente, y le respondemos según el protocolo
            outerloop:
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);

                outputLines = protocol.processInput(inputLine);
                out.println("<META>" + outputLines.size() + "</META>");
                for (String line : outputLines) {
                    out.println(line);
                    if (line.equals("Bye"))
                        break outerloop;
                }

            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateTerminal() {
        List<String> outputLines;

        outputLines = protocol.processInput("updateTerminal");
        out.println("<META>" + outputLines.size() + "</META>");
        for (String line : outputLines) {
            out.println(line);
        }

    }

}