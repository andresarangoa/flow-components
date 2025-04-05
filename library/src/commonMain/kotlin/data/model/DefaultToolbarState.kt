package data.model

interface DefaultToolbarState {
    var isArrowShowed: Boolean
    var isColumn: Boolean
    var rightString: String
    var rightStringIsShowed: Boolean
    var onSkipTap: () -> Unit
}