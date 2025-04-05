package components.dropdown

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import data.model.DefaultDropDownObjState
import data.model.DefaultDropDownState
import io.github.kotlin.components.buttons.checkType
import io.github.kotlin.data.model.Constants.DEFAULT_INPUT_DROPDOWN_LIST_INDEX
import io.github.kotlin.data.model.Constants.DEFAULT_INPUT_DROPDOWN_SELECTED_INDEX

class DropDownStateImp(
    onSelectedOption: (selectedOption: String) -> Unit = {},
    dropdownOptionList: List<String> = listOf(),
) : DefaultDropDownState {
    override var onSelectedOption: (selectedOption: String) -> Unit by mutableStateOf(
        onSelectedOption,
    )
    override var dropdownOptionList: List<String> by mutableStateOf(dropdownOptionList)

    internal companion object {
        val Saver = Saver<DropDownStateImp, List<Any?>>(save = {
            listOf(
                it.onSelectedOption,
                it.dropdownOptionList,
            )
        },
            restore = { restore(it) })

        private fun restore(it: List<Any?>): DropDownStateImp {
            return DropDownStateImp(
                it[DEFAULT_INPUT_DROPDOWN_SELECTED_INDEX].checkType<(selectedOption: String) -> Unit>() as (selectedOption: String) -> Unit,
                it[DEFAULT_INPUT_DROPDOWN_LIST_INDEX].checkType<List<String>>() as List<String>,
            )
        }
    }
}

class DropDownStateObjImp<T>(
    override var displayProperty: (T) -> String = {it.toString()}, // Function to extract display text from T
    override var onSelectedOption: (selectedOption: T) -> Unit = {},
    override var dropdownOptionList: List<T> = listOf(),
    override var selectedOption: T? = null,
    override var showAddNew: Boolean = false,
    override var onAddNew: (() -> Unit)? = null,
    override var addNewText: String? = "Add New",
) : DefaultDropDownObjState<T> {

    fun getDisplayOptions(): List<String> {
        return dropdownOptionList.map(displayProperty)
    }

    internal companion object {
        fun <T> Saver() = Saver<DropDownStateObjImp<T>, List<Any?>>(
            save = {
                listOf(
                    it.displayProperty,
                    it.onSelectedOption,
                    it.dropdownOptionList,
                    it.selectedOption,
                    it.showAddNew,
                    it.onAddNew,
                    it.addNewText,
                )
            },
            restore = {
                DropDownStateObjImp(
                    it[0].checkType<(T) -> String>() as (T) -> String,
                    it[1].checkType<(T) -> Unit>() as (T) -> Unit,
                    it[2].checkType<List<T>>() as List<T>,
                    it[3] as T,
                    it[4] as Boolean,
                    it[5].checkType<() -> Unit>() as () ->Unit,
                    it[6] as String,
                )
            }
        )
    }
}
