package components.buttons.circular

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import data.model.DefaultCircularButtonState
import io.github.kotlin.fibonacci.components.buttons.checkType
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_CIRCULAR_BUTTON_CLICK_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_CIRCULAR_BUTTON_TITLE_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_CIRCULAR_IS_LOADING_INDEX

class DefaultCircularButtonImp(
    onButtonClick: () -> Unit = {},
    buttonTitle: String = "",
    isLoading: Boolean = false
) : DefaultCircularButtonState {

    override var onButtonClick: () -> Unit by mutableStateOf(onButtonClick)
    override var buttonTitle: String by mutableStateOf(buttonTitle)
    override var isLoading: Boolean by mutableStateOf(isLoading)

    companion object {
        val Saver = Saver<DefaultCircularButtonImp, List<Any>>(save = {
            listOf(
                it.onButtonClick,
                it.buttonTitle,
                it.isLoading
            )
        },
            restore = { restore(it) })

        private fun restore(it: List<Any>): DefaultCircularButtonImp {
            return DefaultCircularButtonImp(
                it[DEFAULT_CIRCULAR_BUTTON_CLICK_INDEX].checkType<() -> Unit>() as () -> Unit,
                it[DEFAULT_CIRCULAR_BUTTON_TITLE_INDEX] as String,
                it[DEFAULT_CIRCULAR_IS_LOADING_INDEX] as Boolean,
            )
        }
    }
}