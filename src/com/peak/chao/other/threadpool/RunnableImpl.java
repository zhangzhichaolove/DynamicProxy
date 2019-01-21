package com.peak.chao.other.threadpool;

public class RunnableImpl implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
                System.err.println("线程" + Thread.currentThread().getName() + ":" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
