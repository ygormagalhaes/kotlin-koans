import java.util.Date

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        val time1 = Date(year, month, dayOfMonth).time
        val time2 = Date(other.year, other.month, other.dayOfMonth).time

        return when {
            time1 > time2 -> 1
            time1 < time2 -> -1
            else -> 0
        }
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
