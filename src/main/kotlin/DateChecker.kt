class DateChecker() {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    fun isWednesday() {
        return today.dayOfWeek.isoDayNumber == 4
    }

    fun isWeekend() {
        return today.dayOfWeek.isoDayNumber == 6 || today.dayOfWeek.isoDayNumber == 7
    }
}