package com.kox;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class RequestThread implements Runnable {
    private Socket client;
    static final String ROOT = ".";
    static final String ERROR = "public_html/error.html";

    public RequestThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (OutputStream out = client.getOutputStream();
             PrintWriter writer = new PrintWriter(out, false);
             InputStream in = client.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String queryLine = reader.readLine();
            System.out.println(queryLine);
            String queryPath = getQueryPath(queryLine);
            String type = getQueryFileType(queryPath);

            System.out.println("queryLine = " + queryLine + " queryPath = " + queryPath);
            if (queryPath.isEmpty()) {
                queryPath = ROOT;
            }
            System.out.println("queryLine = " + queryLine + " queryPath = " + queryPath);
            System.out.println("Response");

            try (InputStream inInner = new FileInputStream(queryPath);
                 BufferedReader readerInner = new BufferedReader(new InputStreamReader(inInner))) {
                writer.print("HTTP/1.1 200 OK\r\n" +
                        "Server: " + HomeWebServer.SERVER_NAME + "\r\n" +
                        "Date: " + new Date(System.currentTimeMillis()).toString() + "\r\n");

                boolean isText = false;
                if (type.equals("html")) {
                    isText = true;
                    writer.print("Content-Type: text/html\r\n");
                } else if (type.equals("css")) {
                    isText = true;
                    writer.print("Content-Type: text/css\r\n");
                } else if (type.equals("jpg")
                        || type.equals("jpeg")
                        || type.equals("png")
                        || type.equals("gif")
                        || type.equals("bmp")) {
                    writer.print("Content-Type: image/" + type + "\r\n");
                }

                writer.println("Connection: close\r\n" +
                        "\r\n\r\n");

                if (isText) {
                    String line = "";
                    while ((line = readerInner.readLine()) != null) {
                        writer.println(line + "\r\n");
                    }
                } else {
                    byte[] buff = new byte[1024 * 10];
                    int bytesCount = -1;
                    while ((bytesCount = inInner.read(buff)) > 0) {
                        out.write(buff, 0, bytesCount);
                    }
                }
            } catch (FileNotFoundException ex) {
                File file = new File(queryPath);
                if (file.exists()) {
                    System.out.println(queryPath);
                    writer.println("HTTP/1.1 404 ERROR\r\n" +
                            "Server: " + HomeWebServer.SERVER_NAME + "\r\n" +
                            "Date: " + new Date(System.currentTimeMillis()).toString() + "\r\n" +
                            "Content-Type: text/html\r\n" +
                            "Connection: close\r\n" +
                            "\r\n\r\n");
                    writer.println("<h1 style='color:blue'>" + queryPath + "</h1>");
                    writer.println("<p><a href='/" + file.getParent() + "'>" + file.getParent() + "..</a></p>");
                    writer.println("<ul>\n");
                    for (File current : file.listFiles()) {
                        writer.println("<li><a href='/" + queryPath + "/" + current.getName() + "'>" + current.getName() + "</a></li>\n");
                    }
                    writer.println("</ul>\n");
                } else {
                    System.out.println("error");
                    try (InputStream inInner = new FileInputStream(ERROR);
                         BufferedReader readerInner = new BufferedReader(new InputStreamReader(inInner))) {
                        writer.println("HTTP/1.1 404 ERROR\r\n" +
                                "Server: " + HomeWebServer.SERVER_NAME + "\r\n" +
                                "Date: " + new Date(System.currentTimeMillis()).toString() + "\r\n" +
                                "Content-Type: text/html\r\n" +
                                "Connection: close\r\n" +
                                "\r\n\r\n");
                        String line = "";
                        while ((line = readerInner.readLine()) != null) {
                            writer.println(line);
                        }
                    }
                }
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getQueryPath(String queryLine) {
        int firstSpace = queryLine.indexOf(" ");
        int secondSpace = queryLine.indexOf(" ", firstSpace + 1);
        return queryLine.substring(firstSpace + 2, secondSpace);
    }

    private String getQueryFileType(String queryPath) {
        int dotPos = queryPath.indexOf(".");
        return queryPath.substring(dotPos + 1);
    }
}
