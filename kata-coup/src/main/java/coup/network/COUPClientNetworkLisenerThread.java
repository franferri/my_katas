package coup.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class COUPClientNetworkLisenerThread extends Thread {

    private Socket kkSocket;

    public COUPClientNetworkLisenerThread(Socket kkSocket) {
        this.kkSocket = kkSocket;
    }

    @Override
    public void run() {

        String msg;

        int lines = -1;
        int metaStartPosition = -1;
        int metaEndPosition = -1;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()))) {

            while ((msg = in.readLine()) != null) {

                if (msg.startsWith("<META>") && msg.endsWith("</META>")) {
                    metaStartPosition = msg.indexOf(">") + 1;
                    metaEndPosition = msg.indexOf("<", metaStartPosition);
                    lines = Integer.valueOf(msg.substring(metaStartPosition, metaEndPosition));
                    continue;
                }

                --lines;
                if (lines <= 0) {
                    System.out.print(msg);
                } else {
                    System.out.println(msg);
                }

            }

            System.out.println("Server aborted.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}