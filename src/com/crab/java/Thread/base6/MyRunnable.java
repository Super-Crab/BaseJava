package com.crab.java.Thread.base6;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/12/3 下午5:39
 */

class MyRunnable implements Runnable {

    private ThreadLocal<Integer> num = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 3;
        }
    };

    @Override
    public void run() {
        while (num.get() > 0) {
            System.out.println("Thread:" + Thread.currentThread().getName() + ", consume " + num.get());
            num.set(num.get() - 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
