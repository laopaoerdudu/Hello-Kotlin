#### 类的构造器

如果参数加上 var 或者 val 那就是属性，不加的话就仅仅是个参数了
例如这里 params 就是个参数 但是 age 和 name 就是属性

```
class Person(var age: Int, var name: String, params: Int)
```

#### 接口代理

#### 属性代理

#### 延迟初始化

>推荐使用 by lazy 来做初始化，声明和初始化放在一起是最好的写法。
>Please reference: `com.hk.TestActivity`

```
private val nameTextView by lazy {
    findViewById<TextView>(R.id.textview)
}
```

#### 内部类

>普通的内部类 会持有外部类的引用，容易引发内存泄漏。

Java 的写法

```
public class Outer {
    class Inner {}
    static class StaticInner {}
}
```

Kotlin 的写法

```
class Outer {
    inner class Inner // 这个是非静态的内部类
    class StaticInner // 这个是静态的内部类
}
```

#### 枚举类

既然是枚举，所以肯定是可以穷尽的对吧，所以当他和 when 表达式在一起的时候，他是可以省略 else 分支的。

#### 密封类

>构造器都是私有的，密封类的子类还都是 final 类的，那当然外部无法继承了
>密封类是用来标定 `类型` 差异的，而枚举是用来标定 `值` 差异的。

- 密封类是一个抽象类
 
- 密封类的子类必须与密封类定义在同一个文件中
 
- 密封类的子类个数是有限的

#### 数据类 (data class)

>Kotlin 中的 data class 与java bean 并不相等，因为 data class 不可以被继承
>编译器在编译 `data class` 的时候 会自动生成 `equals`, `hashcode`, `toString` 以及 `copy` 方法。
这里注意 copy 方法是一个浅拷贝方法。
>此外，数据类编译以后在 Java 中要用 `component` 的形式调用。
>反编译看下就知道为何要用 `component` 的形式调用了。

```
// 数据类建议大家就写成这种最简单的方式，不要做任何扩展
data class Book(val id: Long, val name: String, val author: String)
```



































