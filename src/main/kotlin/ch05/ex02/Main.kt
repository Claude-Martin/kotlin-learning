package ch05.ex02

fun lengthOrNull(s: String?): Int? = s?.length
fun lengthOrDefault(s: String?): Int? = s?.length ?: 0

fun section(name: String) = println("\n--- $name ---")

fun main() {
    section("lengthOrNull")
    println(lengthOrNull("hello"))
    println(lengthOrNull(null))
    println(lengthOrNull(""))

    section("cityOf")
    println(cityOf(Person("Ada", Address("Paris"))))
    println(cityOf(Person("Bob", null)))
    println(cityOf(null))

    section("lengthOrDefault / cityOrDefault")
    println(lengthOrDefault(null))
    println(cityOrDefault(null))

    section("report")
    report("hi")
    report(null)
}

data class Address(val city: String?)
data class Person(val name: String, val address: Address?=null)

fun cityOf(p: Person?): String? = p?.address?.city
fun cityOrDefault(p: Person?): String? = p?.address?.city ?: "Unknown"

fun report(s: String?) {
    val message = s ?: run {
        println("no value provided")
        "default"
    }
    println("message: $message")
}