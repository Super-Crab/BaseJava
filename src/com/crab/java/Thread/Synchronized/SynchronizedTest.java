package com.crab.java.Thread.Synchronized;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2019-08-30 09:53
 */

class SynchronizedTest {

    public void method1() {
        System.out.println(Thread.currentThread().getName() + " Method 1 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 1 end");
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName() + " Method 2 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedTest synchronizedTest = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.method1();
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.method2();
            }
        }, "thread2").start();
    }
}
