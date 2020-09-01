import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

operator fun MyDate.plus(timeInterval: TimeInterval) =
        this.addTimeIntervals(timeInterval, 1)

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

/*
Operator para o cenário onde temos por ex.: YEAR * 2
É devolvida então uma instância de RepeatedTimeInterval para que o operator
plus implementado que aceita esse tipo de argumento continue o fluxo da aplicação.
 */
operator fun TimeInterval.times(number: Int) =
        RepeatedTimeInterval(this, number)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate =
        addTimeIntervals(
                repeatedTimeInterval.timeInterval,
                repeatedTimeInterval.number
        )
