package controller.server;

import com.sun.xml.internal.ws.api.message.Packet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;

/**
 *
 * @author hung
 */
public class Server {

    private static ServerSocket serverSocket = null;
    private static Socket clientS = null;
    public static HashMap<String, ServerChat> threads = new HashMap<>();

    public static void main(String args[]) throws InterruptedException, ClassNotFoundException, SQLException {
        int portNumber = 9821;
        //Khai bao
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println(e);
        }

        while (true) {
            try {
                clientS = serverSocket.accept();
                System.out.println("connection Established");
                ServerChat clientThread = new ServerChat(clientS);
                clientThread.start();
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
