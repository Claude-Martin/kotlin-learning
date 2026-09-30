package ch02.ex01

fun main() {
    describeNumber(0)
    describeNumber(1)
    describeNumber(2)
    describeNumber(7)
    println(describeNumberExpr(2))
    println(describeNumberExpr(7))
    classifyLetter('a')
    classifyLetter('z')
// val result = when (c) {
//     'a', 'e', 'i', 'o', 'u' -> "vowel"
// }  // error: 'when' expression must be exhaustive
}

fun describeNumber(n: Int) {
    when (n) {
        0 -> println("zero")
        1 -> println("one")
        2 -> println("two")
        else -> println("many")
    }
}

fun describeNumberExpr(n: Int) = when (n) {
    0 -> "zero"
    1 -> "one"
    2 -> "two"
    else -> "many"
}

fun classifyLetter(c: Char) {
    //when used as a statement: no else required
    when (c) {
        'a', 'e', 'i', 'o', 'u' -> println("vowel")
    }
}