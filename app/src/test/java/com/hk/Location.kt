package com.hk

operator fun Location.minus(location: Location): Location {
    return Location(this.x - location.x, this.y - location.y)
}

operator fun Location.plus(location: Location): Location {
    return Location(this.x + location.x, this.y + location.y)
}

operator fun Location.contains(location: Location): Boolean {
    return this.x > location.x && this.y > location.y
}

class Location(val x: Int, val y: Int) {
    // 使用 operator 关键字修饰函数并且函数名只能为 component1、component2、component3 … 时则是实现一个约定，即 解构 。
    operator fun component1() = x
    operator fun component2() = y

    override operator fun equals(other: Any?): Boolean =
        other is Location && this.x == other.x && this.y == other.y

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}

