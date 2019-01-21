package com.peak.chao.other.memo;

public class ArraySort implements Runnable {
    private String num;

    public ArraySort(int num) {
        this.num = num + "";
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.err.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] nums = {11, 3, 998, 5455, 1, 152, 990};
        for (int i = 0; i < nums.length; i++) {
            new Thread(new ArraySort(nums[i])).start();
        }
    }

}
