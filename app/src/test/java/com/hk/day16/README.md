## Sequece VS Flow

- `Sequece` 没有切换线程的操作，更没有切换协程的操作。也就是说，`Sequence` 链上的操作都执行在同一个线程中。

- Flow：官方称之为 Asynchronous Flow，异步流。异步是 Flow 和 Sequence 的最重要区别。

>异步流比常规的多协程、多线程概念似乎更复杂一丢丢，因为它还有 并行流 的概念。

如下 Flow 操作，是 Sequence 所没有的：

1、Flow.flowOn(context: CoroutineContext)

2、Flow.launchIn(scope: CoroutineScope): Job

3、Flow.buffer(capacity: Int = BUFFERED)
