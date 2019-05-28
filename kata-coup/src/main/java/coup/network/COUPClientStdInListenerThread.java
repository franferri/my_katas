package coup.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class COUPClientStdInListenerThread extends Thread {

    private Socket kkSocket;

    public COUPClientStdInListenerThread(Socket kkSocket) {
        this.kkSocket = kkSocket;
    }

    @Override
    public void run() {


        String msg;

        try (PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true)) {

            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

            while ((msg = stdin.readLine()) != null) {
                out.println(msg);
            }

            System.out.println("Aborted.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}