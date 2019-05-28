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

        try (BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()))) {

            while ((msg = in.readLine()) != null) {
                System.out.print(msg);
            }

            System.out.println("Aborted.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}