package mjin.gaeshowex.util

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*


const val DF_yyyy_MM_dd = "yyyy.MM.dd"
const val DF_yyyy_MM_dd_kr = "yyyy년 MM월 dd일"
const val DF_SERVER = "yyyy-MM-dd'T'HH:mm:ssz"
const val DF_RF3339 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"



fun getLocalSDF(df: String) =
    SimpleDateFormat(df, Locale.getDefault())

fun getServerDate(date: String?): Date? = try {
    getLocalSDF(DF_SERVER).parse(date)
} catch (e: Exception) {
    null
}


fun get_yyyy_MM_dd_Str(date: String): String {
    val serverDate = getServerDate(date)
    return serverDate?.let { getLocalSDF(DF_yyyy_MM_dd).format(serverDate) } ?: ""
}

fun get_yyyy_MM_dd_Str_kr(date: String): String {
    val serverDate = getServerDate(date)
    return serverDate?.let { getLocalSDF(DF_yyyy_MM_dd_kr).format(serverDate) } ?: ""
}

fun get_yyyy_MM_dd_Str_kr(date: Date): String {
    return getLocalSDF(DF_yyyy_MM_dd_kr).format(date)
}


fun getRf3339Str(date: String?): String {
    return getServerDate(date)?.let { getLocalSDF(DF_RF3339).format(it) } ?: ""
}


fun Date.getYearInt(): Int {
    val date = this
    return Calendar.getInstance().apply {
        time = date
    }.get(Calendar.YEAR)
}

fun Date.getMonthInt(): Int {
    val date = this
    return Calendar.getInstance().apply {
        time = date
    }.get(Calendar.MONTH)
}

fun Date.getDayInt(): Int {
    val date = this
    return Calendar.getInstance().apply {
        time = date
    }.get(Calendar.DAY_OF_MONTH)
}

fun Date.getDayOfYear(): Int {
    val date = this
    return Calendar.getInstance().apply {
        time = date
    }.get(Calendar.DAY_OF_YEAR)
}
