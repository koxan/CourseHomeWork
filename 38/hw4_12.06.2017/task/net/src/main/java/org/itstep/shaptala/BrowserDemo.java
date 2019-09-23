package org.itstep.shaptala;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by shaptala on 12.06.2017.
 */
public class BrowserDemo {
    public static void main(String[] args) {
        try (Socket client = new Socket("maxchv.pythonanywhere.com", 80)) {
            // Входной поток - данные от клиента
            try (InputStream in = client.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                 OutputStream out = client.getOutputStream();
                 PrintWriter writer = new PrintWriter(out, true)) {

                writer.print("GET /index.html HTTP/1.1\r\n" +
                        "Host: maxchv.pythonanywhere.com\r\n" +
                        "Connection: close\r\n" +
                        "User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36\r\n" +
                        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                        //"Accept-Encoding: gzip, deflate, sdch\r\n" +
                        "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4\r\n" +
                        "\r\n\r\n");
                writer.flush();
                System.out.println("GET");
                String line = "";
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
