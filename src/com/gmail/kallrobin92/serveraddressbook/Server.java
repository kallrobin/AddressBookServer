package com.gmail.kallrobin92.serveraddressbook;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Robin Gk on 2016-12-01 as a school project.
 * email kallrobin92@gmail.com
 */
public class Server {
    int portNumber;
    String filePath;

    public Server(int portNumber, String filePath) {
       this.portNumber = portNumber;
       this.filePath = filePath;
        runServer();
    }

    private void runServer() {
        while (true) {
            try (
                    ServerSocket serverSocket = new ServerSocket(portNumber);
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter toClient =
                            new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader fromClient = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Session with port: " + portNumber + " started");

                String inputLine, outputLine;

                ServerProtocol serverProtocol = new ServerProtocol();

                while ((inputLine = fromClient.readLine()) != null) {
                    outputLine = serverProtocol.processInput(inputLine, filePath);
                    toClient.println(outputLine);
                    if (outputLine.equals("Closing connection.")) break;
                }
                System.out.println("Session with port: " + portNumber + " ended ");
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

