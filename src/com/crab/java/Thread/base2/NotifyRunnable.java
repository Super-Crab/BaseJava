package com.crab.java.Thread.base2;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/29 上午11:36
 */

class NotifyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s：开始执行，准备锁定object。\n", Thread.currentThread().getName());
        synchronized (Main.object) {
            System.out.printf("%s：成功锁定object，执行同步模块。\n", Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: 唤醒其他线程。\n", Thread.currentThread().getName());
            Main.object.notify();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s: 执行结束。\n", Thread.currentThread().getName());
    }
}
