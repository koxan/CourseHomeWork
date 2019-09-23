package org.itstep.shaptala;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class WebServerDemo {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            // Слушаю входящее соединение
            System.out.println("Ожидание клиента...");
            Socket client = serverSocket.accept();
            System.out.println("Клиент подключился");
            System.out.println("Local Port: " + client.getLocalPort());
            System.out.println("Remote socket: " + client.getRemoteSocketAddress());

            // Входной поток - данные от клиента
            try(InputStream in = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                OutputStream out = client.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true)) {
                String line = "";
                int nr = 0;
                while (nr <= 1) {
                    System.out.println(line);
                    if(line.isEmpty()) {
                        nr++;
                    }
                    System.out.println(nr);
                }
                System.out.println("Send response");
                writer.write("HTTP/1.1 200 OK\r\n" +
                        "Server: mywebserver/1.9.15.1\r\n" +
                        "Date: Mon, 12 Jun 2017 17:57:31 GMT\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Connection: close\r\n" +
                        "\r\n\r\n" +
                        "<h1>Hello Client</h1>" );
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
