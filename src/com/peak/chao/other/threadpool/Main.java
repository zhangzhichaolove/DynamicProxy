package com.peak.chao.other.threadpool;

public class Main {


    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        for (int i = 0; i < 20; i++) {
            ThreadPoolUtil.getInstance().execute(runnable);
        }

    }


}
