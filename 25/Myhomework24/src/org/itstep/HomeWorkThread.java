package org.itstep;

import java.io.*;

public class HomeWorkThread implements Runnable {
    private InputStream in;
    private OutputStream out;
    private String name;
    private Object sync;
    private static boolean isPlay;
    private int countIter;

    static {
        isPlay = true;
    }

    public HomeWorkThread(InputStream in, OutputStream out, String name, Object sync) {
        this.in = in;
        this.out = out;
        this.name = name;
        this.sync = sync;
        countIter = 0;
    }

    @Override
    public void run() {
        byte[] buff = new byte[100];
        int count = -1;
        try {
            while (isPlay) {
                synchronized (sync) {
                    countIter++;
                    count = in.read(buff);
                    // sleep
                    if (count < 1) {
                        isPlay = false;
                        break;
                    }
                    out.write(buff, 0, count);
                    // sleep
                }
            }
            System.out.println(name + " количество итераций:" + countIter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

