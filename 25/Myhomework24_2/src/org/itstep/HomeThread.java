package org.itstep;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class HomeThread extends Thread {
    private long count;
    private CyclicBarrier cyclicBarrier;
    private static volatile boolean isPlay;

    static {
        isPlay = true;
    }

    public HomeThread(CyclicBarrier cyclicBarrier) {
        count = 0;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(getName() + " готов");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " стартовал");
        while (isPlay) {
            count++;
        }
        System.out.println(getName() + " закончил приоритет:" + getPriority() + " итераций:" + count);
    }

    public static void stopPlay() {
        isPlay = false;
    }
}

