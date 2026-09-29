@file:Suppress("RedundantExplicitType")
package ch01.ex02

fun main() {
    val myInt: Int = 5
    println("myInt = $myInt (${myInt::class.simpleName})")
    val myDbl = 3.14
    println("myDbl = $myDbl (${myDbl::class.simpleName}) ")
    val myBool: Boolean = true
    println("myBool = $myBool (${myBool::class.simpleName})")
    val myStr = "Hello World"
    println("myStr = $myStr (${myStr::class.simpleName})")
    val myLng: Long = 24L
    println("myLng = $myLng (${myLng::class.simpleName})")
    println("Integer division 5/2 = ${5/2}") //result is Integer
    println("Double division 5.0/2 = ${5.0/2}") //result is Double
    //val x: Int = 3.14   // error: the floating-point literal does not conform to the expected type Int
    //                    // Kotlin does not implicitly narrow Double -> Int
}