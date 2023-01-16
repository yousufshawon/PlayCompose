package com.ayousuf.playcompose.ui.compose.picker

import android.view.ContextThemeWrapper
import android.widget.CalendarView
import android.widget.TimePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.ayousuf.playcompose.R
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email:
 * Date:  16/1/23
 * To change this template use File | Settings | File and Code Templates.
 *
 */

@Preview(showBackground = true)
@Composable
fun CreateCalendar() {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    val cal = Calendar.getInstance()
    val date = remember{ mutableStateOf(dateFormat.format(cal.time)) }

    Column(
        modifier =  Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = date.value, fontSize = 25.sp)
        AndroidView(
            { CalendarView(ContextThemeWrapper(it, R.style.CalenderViewCustom)) },
            update = { views ->
                views.weekDayTextAppearance = R.style.CalenderViewWeekCustomText
                views.firstDayOfWeek = Calendar.SATURDAY
                views.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    cal.set(year, month, dayOfMonth)
                    date.value = dateFormat.format(cal.time).toString()
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun CreateTimePicker() {
    val dateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
    val cal = Calendar.getInstance()
    var time by remember { mutableStateOf(dateFormat.format(cal.time)) }
    Column(
        modifier =  Modifier.fillMaxWidth().padding(start = 50.dp, end = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = time, fontSize = 25.sp)
        AndroidView(factory = {
            TimePicker(it)
        }, update = {
            it.setOnTimeChangedListener { view, hourOfDay, minute ->
                val nowCal = Calendar.getInstance()
                nowCal.set(Calendar.HOUR_OF_DAY, hourOfDay)
                nowCal.set(Calendar.MINUTE, minute)
                time = dateFormat.format(nowCal.time)
            }
        })
    }
}