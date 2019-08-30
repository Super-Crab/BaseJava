package com.crab.java.Thread.Synchronized;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2019-08-30 10:28
 */

class SynchronizedTest4 {
    public void method1() {
        System.out.println(Thread.currentThread().getName() + " Method 1 start");
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " Method 1 execute");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 1 end");
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName() + " Method 2 start");
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " Method 2 execute");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 2 end");
    }

    public static void main(String[] args) {
        test4demo1();
    }
//    虽然线程1和线程2都进入了对应的方法开始执行，但是线程2在进入同步块之前，需要等待线程1中同步块执行完成。
/*
    thread1 Method 1 start
    thread1 Method 1 execute
    thread2 Method 2 start
    thread1 Method 1 end
    thread2 Method 2 execute
    thread2 Method 2 end*/


    private static void test4demo1() {
        final SynchronizedTest4 test = new SynchronizedTest4();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }, "thread2").start();
    }
}
