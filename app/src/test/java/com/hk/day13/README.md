#### Kotlin 中的 `inline`, `noinline` 和 `crossinline`

- inline 在编译时，会将此修饰符修饰的函数复制到调用处（称为内联），避免创建 Function 对象，以减少创建对象的内存开销； 

- noinline 需要配合 inline 使用，使用在函数型参上，告诉编译器当前这个函数不能内联；

- crossinline 需要配合 inline 使用，告诉编译器不能使用 return，还是得使用 return@label 来返回到指定层面。
  （本身在 lambda 内部就是不能使用 return的，而只能使用 return@label）

  