package com.hk

import android.content.Context
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("MainActivity classLoader: ${MainActivity::class.java.classLoader}")

        // 系统类 都是交给 `java.lang.BootClassLoader` 来加载的
        // 只不过 JVM 中的是叫 `BootstrapClassLoader` 罢了
        println("Context classLoader: ${Context::class.java.classLoader}")
        println("ListView classLoader: ${ListView::class.java.classLoader}")

        // dalvik.system.PathClassLoader[DexPathList[[zip file "/data/app/com.hk-AzQytiwxoD3m4rMVKDz5iw==/base.apk"],nativeLibraryDirectories=[/data/app/com.hk-AzQytiwxoD3m4rMVKDz5iw==/lib/x86, /system/lib]]]
        println("应用程序默认加载器: $classLoader")

        // 系统类加载器: dalvik.system.PathClassLoader[DexPathList[[directory "."],nativeLibraryDirectories=[/system/lib, /system/lib]]]
        println("系统类加载器: ${ClassLoader.getSystemClassLoader()}")
    }
}