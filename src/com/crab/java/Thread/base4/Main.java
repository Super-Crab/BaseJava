package com.crab.java.Thread.base4;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/12/3 下午2:53
 */

class Main {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Setting interrupt flag.\n", Thread.currentThread().getName());
        thread.interrupt();
    }
}
