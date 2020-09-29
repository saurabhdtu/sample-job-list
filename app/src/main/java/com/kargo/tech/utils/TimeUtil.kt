package com.kargo.tech.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {
    fun getTimeString(time: Long): String {
        var date = Date(time * 1000)
        return SimpleDateFormat("EEE, dd MMM, hh:mm a").format(date)
    }
}