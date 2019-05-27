package coup.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkInThreat extends Thread {

    private String stdIn = "";

    private Socket kkSocket;

    public NetworkInThreat(Socket kkSocket) {
        this.kkSocket = kkSocket;
    }

    @Override
    public void run() {

        String fromServer;

        int lines = -1;
        int metaStartPosition = -1;
        int metaEndPosition = -1;

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        ) {

            while ((fromServer = in.readLine()) != null) {

                if (fromServer.startsWith("<META>") && fromServer.endsWith("</META>")) {
                    metaStartPosition = fromServer.indexOf(">") + 1;
                    metaEndPosition = fromServer.indexOf("<", metaStartPosition);
                    lines = Integer.valueOf(fromServer.substring(metaStartPosition, metaEndPosition));
                    continue;
                }

                System.out.println("Received from the Server: " + fromServer);
                stdIn = "Received from the Server: " + fromServer;

                --lines;
                if (lines <= 0) {
                }

            }

            System.out.println("Aborted.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String fromThread() {
        return stdIn;
    }

}