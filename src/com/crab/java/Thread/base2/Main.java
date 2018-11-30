package com.crab.java.Thread.base2;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/29 上午11:36
 */

class Main {

    public static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new WaitRunnable());
        Thread thread2 = new Thread(new NotifyRunnable());

        System.out.printf("Main: %s:%s , %s:%s\n", thread1.getName(),thread1.getState(),thread2.getName(),thread2.getState());

        thread1.start();
        thread2.start();

        while (thread1.getState() != Thread.State.TERMINATED || thread2.getState() != Thread.State.TERMINATED) {
            System.out.printf("Main: %s:%s , %s:%s\n", thread1.getName(), thread1.getState(), thread2.getName(), thread2.getState());
            Thread.sleep(1000);
        }
    }
}
