package com.crab.java.Thread.base3;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/30 上午11:18
 */

class Main1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        System.out.printf("%s: start two threads.\n", Thread.currentThread().getName());
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.printf("%s: child runnable both ends.\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: end.\n", Thread.currentThread().getName());
    }
}
