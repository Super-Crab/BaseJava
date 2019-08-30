package com.crab.java.Thread.Synchronized;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2019-08-30 10:21
 */

class SynchronizedTest3 {
    public static void main(String[] args) {
        //test3demo1();
        //test3demo2();
        test3demo3();
    }

    /**
     * 3.1、test3demo1与test3demo2对比：对静态方法的同步本质上是对类的同步（静态方法本质上是属于类的方法，而不是对象上的方法），所以即使test和test2属于不同的对象，但是它们都属于SynchronizedTest类的实例，所以也只能顺序的执行method1和method2，不能并发执行。
     *
     * 3.2、test3demo2与test3demo3对比说明：实例对象上的锁与类对象的锁是两个，所以可以并行的执行method1和method3。
     */

//    test3demo1：
/*
    thread1 Method 1 start
    thread1 Method 1 execute
    thread1 Method 1 end
    thread2 Method 2 start
    thread2 Method 2 execute
    thread2 Method 2 end
*/

//    test3demo2
/*
    thread1 Method 1 start
    thread1 Method 1 execute
    thread1 Method 1 end
    thread2 Method 2 start
    thread2 Method 2 execute
    thread2 Method 2 end
*/
//    test3demo3
/*  thread1 Method 1 start
    thread1 Method 1 execute
    thread2 Method 2 start
    thread2 Method 2 execute
    thread2 Method 2 end
    thread1 Method 1 end
*/
    private static void test3demo1() {
        final SynchronizedTest3 test = new SynchronizedTest3();

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

    private static void test3demo2() {
        final SynchronizedTest3 test = new SynchronizedTest3();
        final SynchronizedTest3 test2 = new SynchronizedTest3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method2();
            }
        }, "thread2").start();
    }

    private static void test3demo3() {
        final SynchronizedTest3 test = new SynchronizedTest3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method3();
            }
        }, "thread2").start();
    }

    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " Method 1 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 1 end");
    }

    public static synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " Method 2 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 2 end");
    }

    public synchronized void method3() {
        System.out.println(Thread.currentThread().getName() + " Method 2 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 2 end");
    }
}
