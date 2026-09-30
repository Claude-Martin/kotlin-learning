package ch03.ex02

fun main() {
    println("--- labeled break ---")

    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (i * j == 4) break@outer
            print("($i,$j) ")
        }
    }
    println()

    println("--- labeled continue ---")

    outer2@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) continue@outer2
            print("($i,$j) ")
        }
    }
    println()
}