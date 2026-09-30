package ch02.ex03

fun main() {
    for (i in listOf(5,42,315,1000,-1)) {
        println("$i => " + rangeDescription(i))
    }
    demonstrateRanges()
    listOf(95, 82, 71, 64, 0, -5, 105).forEach { println("$it => " + grade(it)) }
    println(1..5)
    println(1 until 5)
    println(5 downTo 1)
}

fun rangeDescription(n: Int) = when (n) {
    in 0..9 -> "single digit"
    in 10..99 -> "two digits"
    in 100..999 -> "three digits"
    else -> "out of range"
}

fun demonstrateRanges() {
    println("1..5          => ${(1..5).toList()}")
    println("5 downTo 1    => ${(5 downTo 1).toList()}")
    println("1..10 step 2  => ${(1..10 step 2).toList()}")
    println("1 until 5     => ${(1 until 5).toList()}")
}

fun grade(score: Int) = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    in 0..59 -> "F"
    else -> "invalid score"
}

// fun badGrade(score: Int) = when (score) {
//     in 60..100 -> "pass"
//     in 90..100 -> "A"       // warning: 'when' branch is never reachable
//     else -> "fail"
// }