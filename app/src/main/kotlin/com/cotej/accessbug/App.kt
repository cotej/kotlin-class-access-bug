package com.cotej.accessbug

import com.cotej.accessbug.lower.Lower
import com.cotej.accessbug.upper.Upper

fun main(args: Array<String>) {
    val lower = Lower.getInstance("hello")
    val upper = Upper.getInstance(lower)

    print(upper)
}
