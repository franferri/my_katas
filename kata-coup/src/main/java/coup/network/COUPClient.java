package coup.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class COUPClient {
    public static void main(String[] args) {

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
                    continue;
                }

                System.out.println(fromServer);
                if (fromServer.equals("Game over")) break;

                // capturar el teclado del usuario debería hacerse en un thread a parte, si no, los updates q envía el servidor para refrescar la pantalla no se ejecutan

                // Necesitamos que el teclado y la recepción desde el servidor sea tratada asíncrona y separadamente, o no podremos hacer cosas cmo actualizar la pantalla a todos los clientes

                --lines;
                if (lines <= 0) {
                    //if (null != fromUser && "".equals(fromUser)) {
                    //    out.println(fromUser);
                    //}

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