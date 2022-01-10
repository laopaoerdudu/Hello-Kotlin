#### 尽量少使用 toLowerCase 和 toUpperCase 方法

每次调用 toLowerCase() 方法或者 toUpperCase() 方法会创建一个新的字符串，然后在进行比较。

使用 equals 方法较两个字符串并没有创建额外的对象（添加可选参数 ignoreCase 来忽略大小写），
如果遇到需要比较字符串的时候，可以使用这种方法，减少额外的对象创建。

#### 如何优雅的处理空字符串

使用 `ifEmpty` 方法，可读性更强，当字符串为空字符串时，返回一个默认值，如下所示。

```
val name = target.ifEmpty { "dhl" }
```

#### 避免将解构声明和数据类一起使用

#### Sequence 和 Iterator 不同之处

为什么 Kotlin 会返回 Sequence，而不返回 Iterator？
其实这个核心原因由于 Sequence 和 Iterator 实现不同导致 内存 和 性能 有很大的差异。

```
interface Iterable<out T> {
    operator fun iterator(): Iterator<T>
}

interface Sequence<out T> {
    operator fun iterator(): Iterator<T>
}
```

- Sequences 是属于懒加载操作类型，在 Sequences 处理过程中，会对单个元素进行一系列操作，然后在对下一个元素进行一系列操作，直到所有元素处理完毕。

- 在 Iterator 处理过程中，每一次的操作都是对整个数据进行操作，需要开辟新的内存来存储中间结果，将结果传递给下一个操作

对于每次操作都会开辟一块新的空间，存储计算的结果，这是对内存极大的浪费，我们往往只关心最后的结果，而不是中间的过程。

Sequences 和 Iterator 性能对比:

这个结果是很让人吃惊的，Sequences 比 Iterator 快 19 倍，如果数据量越大，它们的时间差距会越来越大，
当我们在读取文件的时候，可能会进行一系列的数据操作 drop、filter 等等，所以 Kotlin 库函数 useLines 等等方法会返回 Sequences，因为它们更加的高效。

```
val time = measureTimeMillis {
    (1..10000000 * 10).asSequence()
            .filter { it % 2 == 1 }
            .map { it * 2 }
            .count()
}

println(time) // 1197

val time2 = measureTimeMillis {
    (1..10000000 * 10).asIterable()
            .filter { it % 2 == 1 }
            .map { it * 2 }
            .count()
}

println(time2) // 23641
```

参考源码的实现，如果以后遇到类似的需求，但是 Kotlin 库函数有无法满足我们，我们可以以源码为基础进行扩展。








