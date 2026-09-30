package ch02.ex04

enum class Direction { NORTH, SOUTH, EAST, WEST }

fun turn(d: Direction) = when (d) {
    Direction.NORTH -> "up"
    Direction.SOUTH -> "down"
    Direction.EAST -> "right"
    Direction.WEST -> "left"
}

fun main() {
    for (d in Direction.entries) {
        println("$d => ${turn(d)}")
    }
//    println(Direction.entries)
    /*
    the pattern is: when the compiler can prove coverage, you don't need else;
    when it can't, else is the only tool.
    And preferring provable coverage over else is what makes code robust to future changes.
     */
    val i = 0
    when {  // no subject: conditions are plain Booleans
        i<0 -> println("negative")
        i==0 -> println("zero")
        i>0 -> println("positive")
    }
    when (i) {      // subject: conditions are values, in, or is
        0 -> println("zero")
        in 1..10 -> println("between 1 and 10")
        is Int -> println("not between 0 and 10")
    }
}