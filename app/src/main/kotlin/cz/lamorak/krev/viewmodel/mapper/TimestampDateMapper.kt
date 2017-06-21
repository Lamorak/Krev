package cz.lamorak.krev.viewmodel.mapper

import io.reactivex.functions.Function
import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 * Created by ondrej on 15.6.2017.
 */
class TimestampDateMapper : Function<Long, String> {

    private val format: DateFormat = SimpleDateFormat.getDateTimeInstance()

    override fun apply(timestamp: Long?): String {
        return format.format(timestamp?.times(1000))
    }
}