package ch01.ex05

// A grade reporter
fun main() {
    report("Ada", 95)
    report("Bob", 82)
    report("Cleo", 71)
    report("Dan", 64)
    report("Eve", 42)
//    val score:Int = 95
//    println("$score ---> grade ${grade(score)}")
    // var msg = if (score>90) "YES"   //When used as expression, if must have else branch

}

fun grade(score: Int): String = if (score >= 90) "A"
                                else if (score >= 80) "B"
                                else if (score >= 70) "C"
                                else if (score >= 60) "D"
                                else "F"

fun report(name: String, score: Int) {
    val g = grade(score)
    println("$name scored $score -> grade $g")
}

