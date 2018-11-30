package com.crab.java.Thread.base1;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/28 上午10:41
 */

class MyRunnable implements Runnable {

    private int num = 5;

    @Override
    public void run() {
        while (num > 0) {
            System.out.println("Thread:" + Thread.currentThread().getName() + ", consume " + num);
            num--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
