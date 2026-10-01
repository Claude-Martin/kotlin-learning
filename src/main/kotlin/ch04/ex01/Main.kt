package ch04.ex01

fun section(name: String) = println("\n--- $name ---")

fun greet(name: String, greeting: String = "Hello") = "$greeting, $name!"

fun main() {
    section("default parameter values")

    println(greet("Ada"))                   // uses default greeting
    println(greet("Ada", "Hi"))   // overrides default
    println(greet("Ada", greeting = "Hey")) // named argument
    println(greet(greeting = "Nice to meet you", name = "Claude" )) // named argument

    fun formatName(first: String, last: String, title: String = "") =
        if (title.isEmpty()) "$first $last" else "$title. $first $last"

    section("named arguments")

    println(formatName("Ada", "Lovelace"))
    println(formatName("Ada", "Lovelace", "Dr"))
    println(formatName(last = "Lovelace", first = "Ada"))
    println(formatName(first = "Ada", last = "Lovelace", title = "Dr"))

    fun sum(vararg nums: Int): Int {
        var total = 0
        for (n in nums) total += n
        return total
    }

    fun printAll(vararg items: String) {
        for (item in items) println(item)
    }

    section("vararg")

    println(sum(1, 2, 3))
    println(sum(1, 2, 3, 4, 5))
    println(sum())                          // zero arguments — empty array

    printAll("a", "b", "c")

    val values = intArrayOf(10, 20, 30)
    println(sum(*values))                   // spread operator: pass array as vararg

    val list = listOf(1,2,3,4,5)
    println(sum(*list.toIntArray()))

    fun tag(label: String, vararg items: String): String {
        return "[$label] " + items.joinToString(", ")
    }

    // fun broken(vararg items: String, label: String) = ...

    section("vararg with other parameters")

    println(tag("fruit", "apple", "banana", "cherry"))
    println(tag("empty"))
    // vararg is usually last, but named arguments can change that:
    println(tag("veggies", "carrot", "pea"))

    fun classifyScores(scores: List<Int>): String {
        fun grade(score: Int) = when {
            score >= 90 -> "A"
            score >= 80 -> "B"
            score >= 70 -> "C"
            else -> "F"
        }

        return scores.joinToString(", ") { "${it}->${grade(it)}" }
    }

    section("local functions")

    println(classifyScores(listOf(95, 82, 71, 64)))

}