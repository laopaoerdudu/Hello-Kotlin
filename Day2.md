`const val` 是 public 的 
`val` 是 private 的

访问 `val` 是通过方法，要有一次方法调用。
而 `const val` 则是直接访问 field 效率更高。

#### `==` vs `===`

反编译 `User`, 你会发现 data class 这种写法会自动根据我们设定的 field 来帮我们生成 equals 方法。

直接说结论吧：

== 对象中的 field 是否相等。
=== 代表引用是否相等。

#### 扩展函数的实现原理

所谓的扩展函数无非就是定义静态函数罢了

Day2 所有的源码建议在反编译下查看，源码路径：




