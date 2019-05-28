package coup.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class COUPServerStdInLisenerThread extends Thread {

    private Socket kkSocket;

    public COUPServerStdInLisenerThread(Socket kkSocket) {
        this.kkSocket = kkSocket;
    }

    @Override
    public void run() {

// Can we capture any keyboard stroke in here, so in the server screen if the users touches a leter and press enter we just refresh the screen?

    }

}