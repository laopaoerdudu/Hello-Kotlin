#### Kotlin 线程同步的 N 种方法

- Thread.join()

>这是最简单的线程同步方式，`join()` 方法的定义是等待该线程终止。

- synchronized

- ReentrantLock

>它是一种独享锁

- CountDownLatch

>它可以让一个线程一直处于阻塞状态，直到其他线程的执行全部完成，它属于共享锁，
>共享锁的好处是不必为了每个任务都创建单独的锁，即使再多并行任务写起来也很轻松。

