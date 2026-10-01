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


}