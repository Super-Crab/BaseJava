package com.crab.java.Thread.base5;

import java.util.Date;
import java.util.Deque;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/12/3 下午3:33
 */

class GuardTask implements Runnable {
    private Deque<Event> deque;

    public GuardTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true) {
            Event event = deque.getLast();

            Date now = new Date();

            if (now.getTime() - event.getDate().getTime() > 10000) {
                deque.removeLast();

                System.out.printf("%s: Clean Deque %s. Deque size is %d.\n",
                        Thread.currentThread().getName(),
                        event.getEvent(),
                        deque.size());
            }
        }
    }
}
