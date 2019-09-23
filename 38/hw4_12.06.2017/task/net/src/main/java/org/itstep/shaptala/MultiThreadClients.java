package org.itstep.shaptala;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MultiThreadClients {

    static class Client implements Runnable {

        @Override
        public void run() {
            try(Socket client = new Socket("10.2.111.10", 8080)){
                // Входной поток - данные от клиента
                try(InputStream in = client.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    OutputStream out = client.getOutputStream();
                    PrintWriter writer = new PrintWriter(out, true)) {

                    writer.println("Hello from thread " + Thread.currentThread().getName());
                    System.out.println(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            new Thread(new Client()).start();
        }
    }
}
