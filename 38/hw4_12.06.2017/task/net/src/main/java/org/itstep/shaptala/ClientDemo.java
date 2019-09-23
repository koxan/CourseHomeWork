package org.itstep.shaptala;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;


public class ClientDemo {
    public static void main(String[] args) {
        try(Socket client = new Socket("10.2.111.10", 8080)){
            // Входной поток - данные от клиента
            try(InputStream in = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                OutputStream out = client.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true)) {

                Scanner scanner = new Scanner(System.in);

                String line = "";
                while(true) {
                    // запрос пользователя
                    System.out.print(">>> ");
                    line = scanner.nextLine();
                    writer.println(line);
                    line = reader.readLine();
                    System.out.println("Ответ сервера: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
