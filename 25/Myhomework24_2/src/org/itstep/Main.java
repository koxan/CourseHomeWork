package org.itstep;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        int threadCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

        HomeThread[] thrs = new HomeThread[threadCount];
        for (int i = 0, priority = 1; i < thrs.length; i++, priority += 2) {
            thrs[i] = new HomeThread(cyclicBarrier);
            thrs[i].setPriority(priority);
            System.out.println("thrs[i].getPriority() = " + thrs[i].getPriority());
        }

        for (HomeThread current : thrs) {
            current.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HomeThread.stopPlay();

        for (HomeThread current : thrs) {
            try {
                current.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Конец");
    }
}
