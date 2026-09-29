package ch01.ex03

fun add(a: Int, b: Int):Int { return a + b } //block-body
fun addExpr(a: Int, b: Int):Int = a + b       //expression body
fun square(n: Int) = n * n      //inferred return type
fun shout(msg: String) = println(msg.uppercase()) //returns Unit

fun main() {
    //every function has a return type, even when it's Unit.
    println("add(5,7)=${add(5,7)} addExpr(5,10)=${addExpr(5,10)} square(5)=${square(5)}")
    val result = shout("Hello") //returns Unit
    println("shout returned: $result")
}