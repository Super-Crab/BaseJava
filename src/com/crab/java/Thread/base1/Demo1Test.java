package com.crab.java.Thread.base1;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/28 上午10:36
 */

class Demo1Test {

    public static void main(String[] args) {
//        三个线程跑各自的东西
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();
//      三个线程跑一个
        Runnable runnable = new MyRunnable();

        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);

        thread4.start();
        thread5.start();
        thread6.start();

    }
}
