package ch05.ex01

fun main() {
    val definite: String = "hello"
    val maybe: String? = null
    // val broken: String = null    // error: null can not be a value of a non-null type String

    println(definite.length)          // fine: definite is a String
    println(lengthIfPresent(null))
    println(lengthIfPresent("hello"))

//    println(maybe.length)          // error: only safe (?.) or non-null asserted (!!.) calls allowed
}

fun lengthOrZero(s: String?): Int {
    // return s.length          // error: same as above
    return 0                    // placeholder for now — we'll fix in ex02
}

fun lengthIfPresent(s: String?): Int {
    if (s == null) return 0
    return s.length             // OK: after the null check, s is String
}