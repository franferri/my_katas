package coup.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class COUPClient {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket kkSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            int lines = -1;
            int metaStartPosition = -1;
            int metaEndPosition = -1;

            while ((fromServer = in.readLine()) != null) {
                if (fromServer.startsWith("<META>") && fromServer.endsWith("</META>")) {
                    metaStartPosition = fromServer.indexOf(">") + 1;
                    metaEndPosition = fromServer.indexOf("<", metaStartPosition);
                    lines = Integer.valueOf(fromServer.substring(metaStartPosition, metaEndPosition));
                }

                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye.")) break;

                --lines;
                if (lines <= 0) {
                    fromUser = stdIn.readLine();
                    if (fromUser != null) {
                        System.out.println("Client: " + fromUser);
                        out.println(fromUser);
                    }
                }

            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}