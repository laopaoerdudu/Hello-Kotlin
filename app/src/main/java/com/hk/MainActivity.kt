package com.hk

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // dalvik.system.PathClassLoader[DexPathList[[zip file "/data/app/com.hk-AzQytiwxoD3m4rMVKDz5iw==/base.apk"],nativeLibraryDirectories=[/data/app/com.hk-AzQytiwxoD3m4rMVKDz5iw==/lib/x86, /system/lib]]]
        Log.d("WWE", "应用程序默认加载器: $classLoader")
        Log.d("WWE", "系统类加载器: ${ClassLoader.getSystemClassLoader()}")

        Log.d("WWE", "MainActivity classLoader: ${MainActivity::class.java.classLoader}")

        // 系统类 都是交给 `java.lang.BootClassLoader` 来加载的
        // 只不过 JVM 中的是叫 `BootstrapClassLoader` 罢了
        Log.d("WWE", "Context classLoader: ${Context::class.java.classLoader}")
        Log.d("WWE", "ListView classLoader: ${ListView::class.java.classLoader}")
    }
}