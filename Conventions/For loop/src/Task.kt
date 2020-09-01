

class DateRange(private val start: MyDate, private val end: MyDate) : Iterator<MyDate> {
    private var currentDate = start

    override fun next(): MyDate {
        val nextDate = currentDate
        currentDate = currentDate.followingDate()
        return nextDate
    }

    override fun hasNext(): Boolean {
        return currentDate <= end
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    val dateRange = DateRange(firstDate, secondDate)

    for (date in dateRange) {
        handler(date)
    }
}