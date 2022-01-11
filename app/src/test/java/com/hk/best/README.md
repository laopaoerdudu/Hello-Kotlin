思考我们如何通过 Java 代码创建一个 Student 对象？看这里

```
public class Student {
    public String name;
    private Student() {
        throw new IllegalArgumentException("can not create.");
    }
}
```

Please check `BestTest.kt` source code

`Unsafe` 提供了类似 C 语言指针一样操作内存空间的能力。

#### Unsafe 一点用没有？

大家都知道在 Android P 上面，Google 限制了 app 对 hidden API 的访问。

那么 Google 是如何区分是我们 app 调用，还是它自己调用呢？

其中有一个办法就是通过 ClassLoader，系统认为如果 ClassLoader 为 BootStrapClassLoader 则就认为是系统类，则放行。

但是这样有个问题，假设 google 有一天把反射设置 classLoader 也完全限制掉，就不行了。

那么怎么办？原理还是换 ClassLoader，但是我们不走 Java 反射的方式了，而是用 Unsafe:

#### 深入理解 Kotlin 无参构造函数

Kotlin 中不管是 class 还是 data class 都不会自动帮你生成无参的构造函数。
这里实际上是非常坑爹的一点。 大家都知道纯 java 的代码 如果你不写任何构造函数，编译器也会帮你生成一个无参的构造函数。
但是在 Kotlin 中，这个特性被抹掉了。

有没有方法可以避免这种情况。当然是可以的。
比如我们把定义的属性手动给他指定一个默认值

```
class KUser(var name:String = "")

data class KUser2(var name: String = "")
```

或者手动指定一个无参的构造函数:

```
data class KUser(var name: String, var age: Int){
    constructor() : this("123",0)
}
```

总之只要你指定了全部属性都有默认值，那么就肯定会有无参的构造函数的。
记住： Kotlin 要想和一些序列化或者反序列化框架工作正常，最好还是提供一下无参构造函数。




