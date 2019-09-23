package org.itstep.shaptala;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class MultiThreadServer {

    static class ClientResponse implements Runnable {

        Socket client;

        public ClientResponse(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Входной поток - данные от клиента
            try (InputStream in = client.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                 OutputStream out = client.getOutputStream();
                 PrintWriter writer = new PrintWriter(out, true)) {

                String line = "";
                line = reader.readLine();
                writer.println("[" + LocalTime.now() + "] " + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                // Слушаю входящее соединение
                while(true) {
                    System.out.println("Ожидание клиента...");
                    Socket client = serverSocket.accept();
                    new Thread(new ClientResponse(client)).start();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
