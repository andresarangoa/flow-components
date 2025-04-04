package data.model

interface DefaultDropDownState {
    var onSelectedOption: (selectedOption: String) -> Unit
    var dropdownOptionList: List<String>
}

interface DefaultDropDownObjState<T> {
    var displayProperty:  (T) -> String
    var onSelectedOption: (selectedOption: T) -> Unit
    var selectedOption: T?
    var dropdownOptionList: List<T>
    var showAddNew: Boolean
    var onAddNew: (()-> Unit)?
    var addNewText: String?
}
