package com.crab.java.Thread.base3;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/30 上午11:16
 */

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s: I am start working.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 10 + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: I am end working.\n", Thread.currentThread().getName());
    }
}
