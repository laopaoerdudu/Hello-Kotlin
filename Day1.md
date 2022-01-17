#### Kotlin 与 Java 的泛型

```
class AClass {

}

class BClass extends AClass {

}

public class TestJavaG {
    public static void main(String[] args) {
        AClass aClass = new BClass();
        List<AClass> alist = new ArrayList<BClass>(); // 在 java 中这是不允许的编译就报错

        // 但是数组却是可以的，因为数组没有在编译时擦除类型，类型擦除会导致类型不安全的问题
        AClass[] aArray = new BClass[3];

        // 这样的代码肯定编译报错
        BClass bClass = new AClass();    
        
        // 一样编译报错
        List<BClass> blist = new ArrayList<AClass>();   

        // 一旦使用 `? super` 这个通配符，那么就不会报错了
        List<? super BClass> blist2 = new ArrayList<AClass>(); 
    }
}

// 当然如果你非要这样做，也不是不可以
List<? extends AClass> a_list = new ArrayList<BClass>();

// 下面2个语句在调用的时候都会报错，因为我们虽然用 ? extends解除了上述的限制
// 我们只能使用 a_list 而不能修改它
a_list.add(new AClass());
a_list.add(new BClass());
```

如果你某个函数只想使用参数的值，而不想修改该参数，那么就用这个 `？extends` 就可以大大扩大这个函数的使用范围。避免很多麻烦

```
 // 使用了 `？extends` 通配符 所以他的参数可以是任何 Aclsss 的子类声明的
static void printlnAll2(List<? extends AClass> aClassList) {
    for (AClass aClass : aClassList) {
        aClass.printlnInfo();
    }
}
```
- 如果你的泛型只想使用而不想修改，那么就用 `？extends`

- 如果你的泛型只想修改，那么就用 `? super`

Kotlin 中的 out 对应 Java 的 `？extends` 就意味着你只能读我，不能写我。 因为 out 是对外输出的意思

Kotlin 中的 in 对应 Java 的 `？super`， 就意味着你只能写我，不能读我，因为 in 是对内写入的意思

Java 中使用泛型的时候是没办法做类型判断的，但是在 Kotlin 中的 ( inline + reified )，可以做类型判断：

```
inline fun <reified T> printTypeMath(item: Any) {
    if (item is T) {
        println("match")
    } else {
        println("miss")
    }
}

inline fun <reified T> Context.startActivity() {
    Intent(this, T::class.java).apply {
        startActivity(this)
    }
}

// how to use
context.startActivity<MainActivity>()
```

#### Java 中的泛型到底是用来干嘛的，为什么需要这个东西，类型擦除和类型安全又是什么

所谓类型擦除，使用泛型的时候加上类型参数，在编译器编译的时候会去掉，这个过程成为类型擦除。

>如在代码中定义 List<Object> 和 List<String> 等类型，在编译后都会变成 List，JVM 看到的只是 List，而由泛型附加的类型信息 JVM 是看不到的

如果不指定泛型，那么这个 ArrayList 可以存储任意的对象。

```
public static void main(String[] args) {  
    ArrayList list = new ArrayList();  
    list.add(1);  
    list.add("David");  
    list.add(new Date());  
}  
```

list1 使用了泛型，就可以完成类型的安全检查

```
ArrayList<String> list1 = new ArrayList();  
list1.add("1"); //编译通过  
list1.add(1); //编译错误  
String str1 = list1.get(0); //返回类型就是String  
```

list2 没有使用泛型，没有做类型安全检查

```
ArrayList list2 = new ArrayList<String>();  
list2.add("1"); //编译通过  
list2.add(1); //编译通过  
Object object = list2.get(0); //返回类型就是Object  
```

泛型类中的泛型参数的实例化是在定义对象的时候指定的，而 静态变量 和 静态方法 不需要使用对象来调用

```
public class Test<T> {    
    public static T one;   //编译错误    
    public static T show (T one) { //编译错误    
        return null;    
    }    
}

//但是要区分下面的这种情况
//这是一个泛型方法，在泛型方法中使用的 T 是自己在方法中定义的 T，而不是泛型类中的 T。
public class Test2<T> {    
    public static <T> T show (T one) { // 这是正确的    
        return null;    
    }    
}
```

泛型类型变量不能是基本数据类型

>没有 ArrayList<double>，只有 ArrayList<Double>。因为当类型擦除后，ArrayList 的原始类型变为 Object，但是 Object 类型不能存储 double 值，只能引用 Double 的值。







































