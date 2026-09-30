package ch03.ex01

fun section(name: String) = println("\n--- $name ---")

fun main() {
    section("for with ranges")

    for (i in 1..5) { print("$i ") }
    println()

    for (i in 1 until 5) { print("$i ") }
    println()

    for (i in 5 downTo 1) { print("$i ") }
    println()

    for (i in 1..10 step 2) { print("$i ") }
    println()

    for (i in 10 downTo 1 step 3) { print("$i ") }
    println()

    section("for over collections and strings")

    for (c in "hello") { print("$c-") }
    println()

    for (n in listOf(3, 1, 4, 1, 5)) { print("$n ") }
    println()

    for ((i, n) in listOf(3, 1, 4, 1, 5).withIndex()) {
        println("index $i: $n")
    }
}
