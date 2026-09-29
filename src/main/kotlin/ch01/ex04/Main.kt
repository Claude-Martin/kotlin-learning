package ch01.ex04

fun main() {
    describe(5)
    describe(-3)
    println(describeExpr(5))
    println(describeExpr(-3))
    println(describeExpr(0))

    val n = 10
    val label = if (n > 0) "positive" else "non-positive"
    println(label)

    // val x = if (n > 0) "yes"   // error: 'if' must have both branches to be used as an expression
}

fun describe(n: Int) {
    if (n > 0) {
        println("positive")
    } else if (n < 0) {
        println("negative")
    } else {
        println("zero")
    }
}
fun describeExpr(n: Int) = if (n > 0) "positive" else if (n < 0) "negative" else "zero"
