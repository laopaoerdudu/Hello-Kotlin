#### Java8 的 SAM

Single Abstract Method 实际上这是 Java8 中提出的概念，你就把他理解为是一个方法的接口的就可以了

```
// 起个别名
typealias Funtionx = () -> Unit

fun submit(block: Funtionx) {
    block.invoke()
}
```

#### 高阶函数

参数类型包含 函数类型，或者返回值类型是 一个函数类型的函数 都可以称之为是高阶函数。

谷歌源码里最常用的几个高阶函数:

```
let run also apply use
```

#### asSequence() vs listOf()

Please reference: ExampleUnitTest

#### map vs flatMap

>map: 集合中的各个元素经过 map 操作后，得到新集合
> flatMap：把集合中的每一个元素经过 flatMap 操作后都转成 List，然后在把这些 List 全部合并

Please reference: ExampleUnitTest
