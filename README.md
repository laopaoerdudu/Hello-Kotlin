#### noinline

noinline 作用于函数类型参数，代表该参数不参与内联。

适用范围：如果一个 inline 函数中有 多个 lambda 表达式 参数，那么可以用 noinline 修饰符标记不希望内联的 函数参数

```
inline fun foo(wantInlined: () -> Unit, noinline notWantInLined: () -> Unit) {}
```


#### 双冒号 ::method 到底是什么？

>这个双冒号的写法叫做函数引用 Function Reference 加了两个冒号，这个函数才变成了一个对象。 函数名的左边加上双冒号，它就不表示这个函数本身了，而是表示一个和这个函数具有相同功能的对象。
> 再说一遍，这个双冒号的这个东西，它不是一个函数，而是一个对象，一个函数类型的对象。

```
fun b(param: Int): String {
  return param.toString()
}

b(1) // 调用函数
(::b)(1) // 用对象 :b 后面加上括号来实现 b() 的等价操作，实际上会调用 (::b).invoke(1)

// 你可以对一个函数类型的 对象 调用 invoke()，但不能对一个函数这么做：
b.invoke(1) // 报错
```

Kotlin 语言中，Lambda 表达式里不允许使用 return，除非整个 Lambda 表达式是内联函数的参数。
由于函数内联优化，两个函数类型参数均被内联，代码铺平后，return直接结束了main方法，导致println("Finish Greeting")未执行，

Please reference `TT.kt`