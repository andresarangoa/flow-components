package data.model

interface DefaultCircularButtonState {
    var onButtonClick: () -> Unit
    var buttonTitle: String
    var isLoading: Boolean
}