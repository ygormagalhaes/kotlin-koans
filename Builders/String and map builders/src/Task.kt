import kotlin.collections.HashMap

fun buildMap(build: HashMap<Int, String>.() -> Unit): HashMap<Int, String> {
    return HashMap<Int, String>().apply { build() }
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
