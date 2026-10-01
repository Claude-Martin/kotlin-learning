package ch05.ex03

fun lengthUnsafe(s: String?): Int = s!!.length

fun main() {
    println(lengthUnsafe("hello"))   // 5, fine — s wasn't null
    try {
        println(lengthUnsafe(null))
    } catch (e: NullPointerException) {
        println("caught NPE: ${e.message}")
    }
    println("program continues")

}

fun shoutIfPresentBad(s: String?): String {
    if (s == null) return "nothing to shout"
    return s!!.uppercase()      // !! unnecessary — IntelliJ will warn
// When !! is tempting but wrong:
// val name: String? = findName()
// val upper = name!!.uppercase()    // crashes if findName() returned null
//
// Better:
// val upper = name?.uppercase() ?: "UNKNOWN"
//
// Or if null is truly unexpected and should fail loudly:
// val upper = requireNotNull(name) { "name must not be null" }.uppercase()
//
// !! has no message. requireNotNull does. Prefer the latter when you must fail.
}