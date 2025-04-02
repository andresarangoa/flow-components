package components.birthdayPicker


import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import io.github.kotlin.fibonacci.getCurrentMillis


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayPickerDialog(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {

    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis <= getCurrentMillis()
        }
    })

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }

            ) {
                Text(text = "ok")
            }
        },
        dismissButton = {
            Button(onClick = {
                onDismiss()
            }) {
                Text(text = "dismiss")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}