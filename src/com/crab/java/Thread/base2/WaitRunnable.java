package com.crab.java.Thread.base2;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/29 上午11:35
 */

class WaitRunnable implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s：开始执行，准备锁定object。\n", Thread.currentThread().getName());
        synchronized (Main.object) {
            try {
                System.out.printf("%s：成功锁定object，执行同步模块。\n", Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.printf("%s：被挂起，等待其他线程唤醒自己。\n", Thread.currentThread().getName());
                Main.object.wait();
                System.out.printf("%s: 被唤起，继续开始执行。\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s: 执行结束。", Thread.currentThread().getName());
    }
}
