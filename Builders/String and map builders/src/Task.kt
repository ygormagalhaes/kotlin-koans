import kotlin.collections.HashMap

fun buildMap(build: HashMap<Int, String>.() -> Unit): HashMap<Int, String> {
    val theMap = HashMap<Int, String>()
    theMap.build().also { return theMap }
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
