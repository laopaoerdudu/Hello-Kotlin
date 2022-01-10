package com.hk.best

class WorkSingleton private constructor() {

    companion object {

        // 方式一
        val INSTANCE1 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { WorkSingleton() }

        // 方式二 默认就是 LazyThreadSafetyMode.SYNCHRONIZED，可以省略不写，如下所示
        val INSTANCE2 by lazy { WorkSingleton() }
    }
}