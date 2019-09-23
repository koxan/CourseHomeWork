package org.itstep.shaptala;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class ServerDemo {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            // Слушаю входящее соединение
            System.out.println("Ожидание клиента...");
            Socket client = serverSocket.accept();
//            System.out.println("Клиент подключился");
//            System.out.println("Local Port: " + client.getLocalPort());
//            System.out.println("Remote socket: " + client.getRemoteSocketAddress());

            // Входной поток - данные от клиента
            try(InputStream in = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                OutputStream out = client.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true)) {
                String line = "";
                Scanner scanner = new Scanner(System.in);
                while(true) { // запрос пользователя
                    line = reader.readLine();
                    System.out.println(">>> " + line);
                    System.out.print("<<< ");
                    line = scanner.nextLine();
                    System.out.println(line);
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
