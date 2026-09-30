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

    section("while")

    var n = 5
    while (n > 0) {
        print("$n ")
        n--
    }
    println()

    var zero = 0
    while (zero > 0) {
        println("this line should never print")
    }
    println("while with false condition: body ran zero times")

    section("do-while")

    var m = 5
    do {
        print("$m ")
        m--
    } while (m > 0)
    println()

    var alsoZero = 0
    do {
        println("this line prints even though condition is false")
    } while (alsoZero > 0)
    println("do-while with false condition: body ran at least once")

    section("break and continue")

    for (i in 1..10) {
        if (i == 3) continue
        if (i == 7) break
        print("$i ")
    }
    println()

    for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) break
            print("($i,$j) ")
        }
    }
    println()

}
