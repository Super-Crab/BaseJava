package com.crab.java.Thread.base5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/12/3 下午3:37
 */

class Main {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<Event>();

        Thread producer1 = new Thread(new ProducerTask(deque), "Producer-1");
        Thread producer2 = new Thread(new ProducerTask(deque), "Producer-2");
        Thread producer3 = new Thread(new ProducerTask(deque), "Producer-3");

        producer1.start();
        producer2.start();
        producer3.start();

        //创建守护线程
        Thread guard = new Thread(new GuardTask(deque), "Guard");
        guard.setDaemon(true);

        guard.start();
    }
}
