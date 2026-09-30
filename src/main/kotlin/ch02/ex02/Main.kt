package ch02.ex02

fun main() {

    println("letterKind 'a' => ${letterKind('a')}")
    println("letterKind 'b' => ${letterKind('b')}")
    println("letterKind 'z' => ${letterKind('z')}")
    println("letterKind 'A' => ${letterKind('A')}")
    println("letterKind '1' => ${letterKind('1')}")


    println("isWeekend : 3 => ${isWeekend(3)}")
    println("isWeekend : 6 => ${isWeekend(6)}")
    println("isWeekend : 8 => ${isWeekend(8)}")
}

fun letterKind(c: Char) = when (c) {
    'a', 'e', 'i', 'o', 'u' -> "vowel"
    in 'a'..'z' -> "consonant"
    else -> "not a lowercase letter"
}

fun isWeekend(day: Int) = when (day) {
    in 1..5 -> false
    6, 7 -> true
    else ->  throw IllegalArgumentException("invalid day: $day")
}

/*
fun duplicateDemo(n: Int) = when (n) {
    1, 2, 2 -> "a"   // warning: the second 2 in 'when' branch is never reachable
    else -> "b"
}
 */