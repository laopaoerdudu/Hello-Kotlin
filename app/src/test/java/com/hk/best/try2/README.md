
Gson 在没有找到无参的构造方法后，通过 `sun.misc.Unsafe` 构造了一个对象。

please check `com.google.gson.internal.UnsafeAllocator #create()`

注意：Unsafe 该类并不是所有的 Android 版本中都包含，不过目前新版本都包含

#### `sun.misc.Unsafe` 何许 API？

>Unsafe 是位于 `sun.misc` 包下的一个类，主要提供一些用于执行低级别、不安全操作的方法，如直接访问系统内存资源、自主管理内存资源等，
>这些方法在提升 Java 运行效率、增强 Java 语言底层资源操作能力方面起到了很大的作用。
>但由于 Unsafe 类使 Java 语言拥有了类似 C 语言指针一样操作内存空间的能力，这无疑也增加了程序发生相关指针问题的风险。
>在程序中过度、不正确使用 Unsafe 类会使得程序出错的概率变大，使得 Java 这种安全的语言变得不再“安全”，因此对 Unsafe 的使用一定要慎重。
 https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html

看到这里，大家可能最大的收获就是了解 Gson 构建对象流程，以及以后写 Bean 的时候会注意提供默认的无参构造方法，
尤其在使用 Kotlin `data class` 的时候。

