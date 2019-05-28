package coup.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class COUPClient {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: java COUPClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket kkSocket = new Socket(hostName, portNumber);
        ) {

            NetworkInThreat threadFromServer = new NetworkInThreat(kkSocket);
            threadFromServer.start();

            StdInThreat threadKeyboard = new StdInThreat(kkSocket);
            threadKeyboard.start();

            while (true) {
                Thread.sleep(1000);
            }

            // capturar el teclado del usuario debería hacerse en un thread a parte, si no, los updates q envía el servidor para refrescar la pantalla no se ejecutan

            // Necesitamos que el teclado y la recepción desde el servidor sea tratada asíncrona y separadamente, o no podremos hacer cosas cmo actualizar la pantalla a todos los clientes

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}