package components.toolbar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import data.model.DefaultToolbarState
import io.github.kotlin.components.buttons.checkType
import io.github.kotlin.data.model.Constants.DEFAULT_TOOLBAR_IS_ARROW_SHOWED_INDEX
import io.github.kotlin.data.model.Constants.DEFAULT_TOOLBAR_IS_COLUMN_INDEX
import io.github.kotlin.data.model.Constants.DEFAULT_TOOLBAR_IS_RIGHT_STRING_SHOWED_INDEX
import io.github.kotlin.data.model.Constants.DEFAULT_TOOLBAR_ON_SKIP_TAPPED_INDEX
import io.github.kotlin.data.model.Constants.DEFAULT_TOOLBAR_RIGHT_STRING_INDEX

class DefaultToolbarStateImp(
    isArrowShowed: Boolean = true,
    isColumn: Boolean = true,
    rightString: String = "",
    rightStringIsShowed: Boolean = false,
    onSkipTapped: () -> Unit = {}
) : DefaultToolbarState {

    override var isArrowShowed: Boolean by mutableStateOf(isArrowShowed)
    override var isColumn: Boolean by mutableStateOf(isColumn)
    override var rightString: String by mutableStateOf(rightString)
    override var rightStringIsShowed: Boolean by mutableStateOf(rightStringIsShowed)
    override var onSkipTap: () -> Unit by mutableStateOf(onSkipTapped)

    companion object {
        val Saver = Saver<DefaultToolbarStateImp, List<Any>>(save = {
            listOf(
                it.isArrowShowed,
                it.isColumn,
                it.rightString,
                it.rightStringIsShowed,
                it.onSkipTap
            )
        },
            restore = { restore(it) })

        private fun restore(it: List<Any>): DefaultToolbarStateImp {
            return DefaultToolbarStateImp(
                it[DEFAULT_TOOLBAR_IS_ARROW_SHOWED_INDEX] as Boolean,
                it[DEFAULT_TOOLBAR_IS_COLUMN_INDEX] as Boolean,
                it[DEFAULT_TOOLBAR_RIGHT_STRING_INDEX] as String,
                it[DEFAULT_TOOLBAR_IS_RIGHT_STRING_SHOWED_INDEX] as Boolean,
                it[DEFAULT_TOOLBAR_ON_SKIP_TAPPED_INDEX].checkType<() -> Unit>() as () -> Unit,
            )
        }
    }
}