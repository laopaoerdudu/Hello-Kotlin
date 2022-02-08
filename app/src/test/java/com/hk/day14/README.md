#### Kotlin 泛型中的 in 和 out

in & out 怎么记？

- Out (协变)

>如果你的类是将泛型作为内部方法的返回，那么可以用 out：
因此，可以这样来记：produce = output = out。

```
interface Production<out T> {
    fun produce(): T
}
```

- In(逆变)

>如果你的类是将泛型对象作为函数的参数，那么可以用 in：

```
interface Consumer<in T> {
    fun consume(item: T)
}
```

- Invariant(不变)

>如果既将泛型作为函数参数，又将泛型作为函数的输出，那就既不用 in 或 out。

```
interface ProductionConsumer<T> {
    fun produce(): T
    fun consume(item: T)
}
```

父类泛型对象可以赋值给子类泛型对象，用 in；

子类泛型对象可以赋值给父类泛型对象，用 out。




