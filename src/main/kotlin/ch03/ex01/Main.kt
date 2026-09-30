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
}
