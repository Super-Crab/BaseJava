### base4 线程中断
>在Java API中，提供了关于线程中断的两个方法。Thread.interrupt()方法会给线程设置一个中断状态，Thread.interrupted()则用来判断中断状态。
---

### base 5
>Java中的提供的守护线程优先级很低。也就是说，当同一个应用中中没有其他线程运行的时候，守护线程才运行，当其他线程都已经终止后，守护线程成为了唯一的运行线程时，那么守护线程就会终止，JVM应用结束。
 
>因为守护线程的特性，通常情况下守护线程是用来为普通线程提供服务的。它在结构设计上是无限循环的，并且不能够承担重要工作，因为我们不知道守护线程什么时候能够获取CPU时间，守护线程也不能够独立存在。在Java中，守护线程最典型的一个例子就是垃圾收集器(GC)。
---