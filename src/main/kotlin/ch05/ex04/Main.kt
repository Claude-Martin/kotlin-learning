package ch05.ex04

fun process(input: String?) {
    input?.let {
        if (it.length < 3) {
            println("'$it' is too short")
            return@let
        }
        println("processing: $it")
    }
    println("done from process")
}
fun shout(s: String?): String? = s?.let { it.uppercase() + "!" }
fun section(name: String) = println("\n--- $name ---")
fun shoutOrDefault(s: String?): String = s?.let { it.uppercase() + "!" } ?: "NOTHING TO SHOUT"

fun main() {
    section("Basics ?.let")
    val name: String? = "Ada"
    name?.let { println("Hello, $it!") }
    val missing: String? = null
    missing?.let { println("This should not print: $it") } //produces null

    section("?.let produces a value")
    println(shout("hello"))   // HELLO!
    println(shout(null))      // null

    section("Chaining with Elvis")
    println(shoutOrDefault("hello"))   // HELLO!
    println(shoutOrDefault(null))      // NOTHING TO SHOUT

    section("?.let for validation")
    process("OK")
    process("It's over!")
    process(null)


}
