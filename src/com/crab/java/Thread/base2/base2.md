###1.线程状态
![](base2.png)
---
###2.线程状态转换
```
new Thread()：线程创建之初，线程状态为初始状态NEW。
Thread.start()：线程状态为RUNNABLE，等待JVM分配CUP时间来执行。
Thread.sleep(long)：线程进入TIMED_WAITING状态，不释放线程持有的锁，会释放计算资源，并等待指定时间后恢复。
Object.wait()/Objectwait(long)：前者线程进入WAITING状态，并等待被唤醒；后者线程进入TIMED_WAITING，等待指定时间后恢复。但是wait()方法与sleep()方法不同，它会释放线程持有的锁。
Thread.join()/Thread.join(long)：前者线程进入WAITING状态，并等待加入的线程执行完毕后恢复；后者线程进入TIMED_WAITING，等待指定时间后恢复。
synchronized：等待获取锁会使线程进入BLOCKED状态，并一直竞争这个锁，知道获取锁后进入同步块方法，并恢复RUNNABLE状态。
```

###3.逻辑分析
```aidl
Main: Thread-0:NEW , Thread-1:NEW
Thread-0：开始执行，准备锁定object。
Thread-0：成功锁定object，执行同步模块。
Main: Thread-0:TIMED_WAITING , Thread-1:RUNNABLE
Thread-1：开始执行，准备锁定object。
Main: Thread-0:TIMED_WAITING , Thread-1:BLOCKED
Main: Thread-0:TIMED_WAITING , Thread-1:BLOCKED
Thread-0：被挂起，等待其他线程唤醒自己。
Thread-1：成功锁定object，执行同步模块。
Main: Thread-0:WAITING , Thread-1:TIMED_WAITING
Main: Thread-0:WAITING , Thread-1:TIMED_WAITING
Main: Thread-0:WAITING , Thread-1:TIMED_WAITING
Thread-1: 唤醒其他线程。Main: Thread-0:BLOCKED , Thread-1:TIMED_WAITING
Main: Thread-0:BLOCKED , Thread-1:TIMED_WAITING
Main: Thread-0:BLOCKED , Thread-1:TIMED_WAITING
Thread-1: 执行结束。Thread-0: 被唤起，继续开始执行。Thread-0: 执行结束。
```
```aidl
执行过程分析：

1. Thread-0与Thread-1创建之初。

Thread-0：NEW
Thread-1：NEW
2. Thread-0先启动，获取锁后进入同步方法快并调用sleep方法等待3秒。Thread-1接着启动，也尝试获取锁，但是锁已经被Thread-0获取，Thread-1等待锁释放。

Thread-0：NEW->RUNNABLE->TIMED_WAITNG
Thread-1：NEW->RUNNABLE->BLOCKED
3. Thread-0等待3秒后继续执行然后调用wait方法挂起，并释放锁。Thread-1获取到锁后开始执行同步快并等待三秒。

Thread-0：TIME_WAITING->RUNNABLE->WAITING
Thread-1：BLOCKED->RUNNABLE->TIMED_WAITING
4. Thread-1休眠3秒后唤醒Thread-0，但这个时候锁依然被Thread-1所拥有，然后Thread-1继续休眠3秒。Thread-0等待Thread-1释放锁。

Thread-0：WAITING->BLOCKED
Thread-1：TIMED_WAITING->RUNNABLE->TIMED_WAITING
5. Thread-1休眠结束后恢复，并执行完毕同步方法快后结束。Thread-0获取锁后恢复，执行完同步方法快后结束。

Thread-0：BLOCKED->RUNNABLE->TERMINATED
Thread-1：TIMED_WAITING->RUNNABLE->TERNINATED
```