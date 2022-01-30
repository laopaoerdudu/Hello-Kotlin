#### 反射

关于带 `Declare` 的属性和方法和不带 `Declare` 区别：

- 带 `Declare` 的属性和方法获取的是 `本类所有的属性和方法`，不包含继承得来的

- 不带 `Declare` 的属性和方法获取的是所有 `public` 修饰的属性和方法，包含继承得来的

- 访问 private 修饰的属性和方法，需调用 setAccessible 设置为 true ，表示允许我们访问私有变量

**获取单个属性：**

```
Field carName = benzClass.getDeclaredField("carName");
```

**获取多个属性：**

- 获取本类全部属性

```
Field[] declaredFields = benzClass.getDeclaredFields();
```

- 获取 本类 及 父类 全部 public 修饰的属性

```
Field[] fields = benzClass.getFields();
```

**获取单个方法：**

- 获取 public 方法

```
benzClass.getMethod("combine");
```

- 获取 private 方法

```
benzClass.getDeclaredMethod("privateMethod", String.class);
```

##### 构造方法

- 获取单个构造方法

```
// 获取本类的一个构造方法
Constructor declaredConstructor = benzClass.getDeclaredConstructor(String.class);

// 获取本类某个 public 修饰的构造方法
Constructor singleConstructor = benzClass.getConstructor(String.class, String.class);
```

- 获取多个构造方法

```
// 获取本类全部构造方法
Constructor[] declaredConstructors = benzClass.getDeclaredConstructors();

// 获取全部 public 构造方法, 不包含父类的构造方法，注意是不包含
Constructor[] constructors = benzClass.getConstructors();
```

**构造方法实例化对象：**

```
declaredConstructor.setAccessible(true);
Benz declareBenz = (Benz) declaredConstructor.newInstance("");

// 以上面 singleConstructor 为例
Benz singleBenz = (Benz) singleConstructor.newInstance("奔驰 S", "香槟金");
```

#### 泛型

- 获取父类的泛型

```
Type genericType = benzClass.getGenericSuperclass();
if (genericType instanceof ParameterizedType) {
   Type[] actualType = ((ParameterizedType) genericType).getActualTypeArguments();
   for (Type type : actualType) {
       System.out.println(type.getTypeName());
   }
}
// 打印结果
java.lang.String
java.lang.Integer
```

#### 注解

- 获取单个注解

```
// 获取单个本类或父类注解
Annotation annotation1 = benzClass.getAnnotation(CustomAnnotation1.class);
System.out.println(annotation1.annotationType().getSimpleName());

// 获取单个本类注解
Annotation declaredAnnotation1 = benzClass.getDeclaredAnnotation(CustomAnnotation2.class);
System.out.println(declaredAnnotation1.annotationType().getSimpleName());
```

- 获取全部注解

```
// 获取本类和父类的注解(父类的注解需用 @Inherited 表示可被继承)
Annotation[] annotations = benzClass.getAnnotations();
for (Annotation annotation : annotations) {
    System.out.println("注解名称: " + annotation.annotationType().getSimpleName());
}

// 获取本类的注解
Annotation[] declaredAnnotations = benzClass.getDeclaredAnnotations();
for (Annotation declaredAnnotation : declaredAnnotations) {
    System.out.println("注解名称: " + declaredAnnotation.annotationType().getSimpleName());
}
```






























