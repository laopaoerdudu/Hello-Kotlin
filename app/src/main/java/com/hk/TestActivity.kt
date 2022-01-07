package com.hk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

class TestActivity : AppCompatActivity() {
    private val tvTitle by lazy {
        findViewById<TextView>(R.id.tvTitle)
    }
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = "David"
    }

    // 利用属性委托实现双击退出功能
    private var backPressTime by Delegates.observable(0L) { _, old, new ->
        if (new - old < 2000) {
            finish()
        } else {
            // show toast 再按返回键就退出
        }
    }

    override fun onBackPressed() {
        backPressTime = System.currentTimeMillis()
    }
}