package ch05.ex05

class User {
    lateinit var name: String
    fun isNameSet() = this::name.isInitialized
    fun describe() = "User: $name"
}

class Expensive {
    val data: String by lazy {
        println("(computing data...)")
        "expensive result"
    }
}

class Person(val first: String, val last: String) {
    val fullName: String by lazy { println("computing..."); "$first $last" }
    val greeting: String by lazy { println("computing..."); "Hello, $fullName" }
}


fun section(name: String) = println("\n--- $name ---")
fun main() {

    section("lateInit")
    val u = User()
    println("set? ${u.isNameSet()}")    // false
//    println(u.describe())             // UninitializedPropertyAccessException
    u.name = "Ada"
    println("set? ${u.isNameSet()}")    // true
    println(u.describe())               // User: Ada

    section("by Lazy - computed once, on first read")
    val e = Expensive()
    println("about to access")
    println(e.data)      // (computing data...) then expensive result
    println(e.data)      // expensive result — no recomputation

    val p = Person("Ada", "Lovelace")
    println(p.greeting)  // Hello, Ada Lovelace
    println(p.greeting)  // cached
}