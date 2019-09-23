package org.itstep;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        Object sync = new Object();

        try {
            in = new FileInputStream("alice.txt");
            out = new FileOutputStream("result.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int threadCount = 10;
        HomeWorkThread[] myThrs = new HomeWorkThread[threadCount];
        Thread[] thrs = new Thread[threadCount];
        for (int i = 0; i < myThrs.length; i++) {
            myThrs[i] = new HomeWorkThread(in, out, "Thread " + i, sync);
            thrs[i] = new Thread(myThrs[i]);
        }

        for (Thread current : thrs) {
            current.start();
        }

        try {
            for (Thread current : thrs) {
                current.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

