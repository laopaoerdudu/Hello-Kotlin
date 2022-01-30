#### Unsafe 方法在 Android 上有什么用处？

注意：Google 在 Android 9.0 及之后对反射做了限制，被使用 @hide 标记的属性和方法通过反射拿不到

>但是，Google 不能限制自己对 hidden API 访问对吧，所以它自己的相关类，是允许访问 hidden API 的。

**那么 Google 是如何区分是我们 app 调用，还是它自己调用呢？**

>其中有一个办法就是通过 `ClassLoader`，系统认为如果 `ClassLoader` 为 `BootStrapClassLoader` 则就认为是系统类，则放行。

那么，我们突破 P 访问限制，其中一个思路就是，搞一个类，把它的 ClassLoader 换成 BootStrapClassLoader，从而可以反射任何 hidden api。
假设 Google 有一天把反射设置 classLoader 也完全限制掉，就不行了。
那么怎么办？原理还是换 ClassLoader，但是我们不走 Java 反射的方式了，而是用 Unsafe,
Unsafe 赋予了我们操作内存的能力，也就能完成一些平时只能依赖 C++ 完成的代码。

在程序中过度、不正确使用 Unsafe 类会使得程序出错的概率变大，使得 Java 这种安全的语言变得不再“安全”，因此对 Unsafe 的使用一定要慎重。

#### 那如若想使用这个类，该如何获取其实例？

>通过反射获取单例对象 theUnsafe

```
private static Unsafe reflectGetUnsafe() {
    try {
      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      return (Unsafe) field.get(null);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
}
```

[一种纯 Java 层绕过 Android P 私有函数调用限制的方式](https://fucknmb.com/2018/10/05/%E4%B8%80%E7%A7%8D%E7%BA%AFJava%E5%B1%82%E7%BB%95%E8%BF%87Android-P%E7%A7%81%E6%9C%89%E5%87%BD%E6%95%B0%E8%B0%83%E7%94%A8%E9%99%90%E5%88%B6%E7%9A%84%E6%96%B9%E5%BC%8F/)


