package ch01.ex01b

fun main() {
    val numbers = mutableListOf(1, 2, 3)
    println(numbers)
    numbers.add(4)
    println(numbers)
    // numbers = mutableListOf(5)   // error: 'val' cannot be reassigned
    /*
    val locks the reference, not the object —
    I can't point numbers somewhere else, but I can still change what's inside the list.
     */
}