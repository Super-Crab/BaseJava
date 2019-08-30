package com.crab.java.Thread.Synchronized;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2019-08-30 10:09
 */

class SynchronizedTest2 {

    public static void main(String[] args) {
        //test2demo1();
        //test2demo2();
        test2demo3();
    }

    /**
     * 2.1、test2demo2测试方法中说明：test和test2属于不同的对象，所以同步互不干扰，线程1和线程2会并行执行。
     *
     * 2.2、通过test2demo1与test2demo3对比说明：同一个类中的所有synchronized修饰的方法是不能同时调用的，也就是说同时只能调用其中一个方法，比如线程1调用method1方法，在method1方法执行完之前，线程2调用method2方法，这个时候线程2就会阻塞，直到线程1调用完method1方法后，线程2才开始执行method2方法。（不仅仅是多个线程调用同一个同步方法）。
     *
     * 2.3、如果线程拥有同步和非同步方法，则非同步方法可以被多个线程自由访问而不受锁的限制。
     */

    /**
     * test2demo1:
     *          thread1 Method 1 start
     *          thread1 Method 1 execute
     *          thread1 Method 1 end
     *          thread2 Method 2 start
     *          thread2 Method 2 execute
     *          thread2 Method 2 end
     * test2demo2:
     *          thread2 Method 2 start
     *          thread2 Method 2 execute
     *          thread1 Method 1 start
     *          thread1 Method 1 execute
     *          thread2 Method 2 end
     *          thread1 Method 1 end
     *
     *test2demo3:
     *          thread1 Method 1 start
     *          thread1 Method 1 execute
     *          thread2 Method 3 start
     *          thread2 Method 3 execute
     *          thread2 Method 3 end
     *          thread1 Method 1 end
     */

    private static void test2demo1() {
        final SynchronizedTest2 test = new SynchronizedTest2();

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

    private static void test2demo2() {
        final SynchronizedTest2 test = new SynchronizedTest2();
        final SynchronizedTest2 test2 = new SynchronizedTest2();

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

    private static void test2demo3() {
        final SynchronizedTest2 test = new SynchronizedTest2();

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

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " Method 1 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 1 end");
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " Method 2 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 2 end");
    }

    public void method3() {
        System.out.println(Thread.currentThread().getName() + " Method 3 start");
        try {
            System.out.println(Thread.currentThread().getName() + " Method 3 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Method 3 end");
    }
}
