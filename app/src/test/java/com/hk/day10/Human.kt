package com.hk.day10

// companion init one
//companion init two
//TestInit init
//TestInit init 摔角手
//主构造方法 constructor
//com.hk.day10.Human@1ff8b8f
class Human {
    private var work: String = "摔角手"

    constructor() {
        println("主构造函数 invoke")
    }

    constructor(name: String) {
        println("带参数次构造方法 invoke")
    }

    init {
        println("Human init")
    }

    init {
        println("Human init $work")
    }

    companion object {
        val instance: Human by lazy {
            Human("David")
        }

        init {
            println("companion init")
        }
    }
}

