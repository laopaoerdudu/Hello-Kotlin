#### JvmName

```
@file:JvmName("Utils")
package com.test
fun String.appendUserName(): String {
    return this+"wuyue"
}

// How to apply in java?
Utils.appendUserName("hello");
```

#### JvmMultifileClass

可以将2个 `.kt` 文件里面的代码合并到一个 `.class` 文件中。

```
// A.kt

@file:JvmName("Utils")
@file:JvmMultifileClass
package com.test
fun one() { ... }

// B.kt
@file:JvmName("Utils")
@file:JvmMultifileClass

package com.test
fun two() { ... }

// 这样在 Java 中 调用 Utils 这个类就有 one() 和 two() 两个方法了
```

#### JvmSynthetic

>如果一个函数只想给 Kotlin 代码调用，而不想给 Java 调用，那你就在你的函数上面加上这个注解即可

```
@file:JvmName("Utils")
package com.test
@JvmSynthetic
fun String.appendUserName(): String {
    return this+"wuyue"
}
```


在 Kotlin 中， val 并不意味着是常量，只不过 val 声明的变量是没有 set 方法的，只有 get 方法。
所以给了你一个常量的错觉。 你要真正的在 Kotlin 中定义一个常量，只有两种方法：

- 在 top-level 或者 object 中使用 const val

- 或者使用 @JvmField val（这种方式定义的就是常量了，讲白了你也无法重写 val 的 get 方法了）


