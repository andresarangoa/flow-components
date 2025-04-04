package components.inputs

import data.model.DefaultInputState
import data.model.IconVisibility

fun DefaultInputState.shouldShowIcon(): Boolean {
    return when (this.iconVisibility) {
        IconVisibility.ALWAYS -> true
        IconVisibility.ONLY_WHEN_FOCUSED -> this.isFocused
        IconVisibility.FOCUSED_OR_NOT_EMPTY -> this.isFocused || (!this.isFocused && this.text.isNotEmpty())
        IconVisibility.FOCUSED_AND_NOT_EMPTY -> this.isFocused && this.text.isNotEmpty()
    }
}

//fun Long?.convertMillisToStringDate(): String {
//    if (null == this) return ""
//
//    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.US)
//
//    return formatter.format(Date(this))
//}