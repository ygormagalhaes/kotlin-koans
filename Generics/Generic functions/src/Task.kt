import java.util.*

fun <T> Collection<T>.partitionTo(
        firstCollection: MutableCollection<T>,
        secondCollection: MutableCollection<T>,
        predicate: (T) -> Boolean): Pair<Collection<T>, Collection<T>> =
    this.forEach {
        if (predicate(it)) firstCollection.add(it)
        else secondCollection.add(it)
    }.let { Pair(firstCollection, secondCollection) }

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
