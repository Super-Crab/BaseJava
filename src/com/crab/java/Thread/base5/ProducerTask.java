package com.crab.java.Thread.base5;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/12/3 下午3:30
 */

class ProducerTask implements Runnable {

    private Deque<Event> deque;

    public ProducerTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(Thread.currentThread().getName() + " Event:" + i);
            deque.addFirst(event);

            System.out.printf("%s: Produce one event %s.\n", Thread.currentThread().getName(), event.getEvent());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
