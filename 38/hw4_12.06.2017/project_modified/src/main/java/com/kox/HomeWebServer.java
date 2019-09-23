package com.kox;

import java.io.*;
import java.net.ServerSocket;

public class HomeWebServer {
    static final String SERVER_NAME = "myBetaWebServer/0.2";

    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                System.out.println("waiting...");
                new Thread(new RequestThread(socket.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
