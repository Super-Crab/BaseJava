package com.crab.java.Thread.base4;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/12/3 下午2:52
 */

class Task implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s: I am starting work.\n", Thread.currentThread().getName());
        try {
            while (true) {
                if (Thread.interrupted()) throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.out.printf("%s: I am interrupted.\n", Thread.currentThread().getName());
        }
    }
}
