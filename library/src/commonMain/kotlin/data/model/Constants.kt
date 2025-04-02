package io.github.kotlin.fibonacci.data.model

object Constants {

    var LIMIT_SYMBOL_CURRENCY = '$'
    const val DEFAULT_TOOLBAR_IS_ARROW_SHOWED_INDEX = 0
    const val DEFAULT_TOOLBAR_IS_COLUMN_INDEX = 1
    const val DEFAULT_TOOLBAR_RIGHT_STRING_INDEX = 2
    const val DEFAULT_TOOLBAR_IS_RIGHT_STRING_SHOWED_INDEX = 3
    const val DEFAULT_TOOLBAR_ON_SKIP_TAPPED_INDEX = 4

    const val DEFAULT_CIRCULAR_BUTTON_CLICK_INDEX = 0
    const val DEFAULT_CIRCULAR_BUTTON_TITLE_INDEX = 1
    const val DEFAULT_CIRCULAR_IS_LOADING_INDEX = 2

    const val EMPTY_VIEW_TITLE = 0
    const val EMPTY_VIEW_SUB_TITLE = 1
    const val EMPTY_VIEW_BUTTON_TITLE = 2
    const val EMPTY_VIEW_BUTTON_SECONDARY_TITLE = 3
    const val EMPTY_VIEW_SHOW_BUTTON = 4
    const val EMPTY_VIEW_SECONDARY_SHOW_BUTTON = 5
    const val EMPTY_VIEW_SECONDARY_DONE_BUTTON = 6
    const val EMPTY_VIEW_DONE_BUTTON = 7

    const val MINIMUM_PASSWORD_LENGTH = 8


    const val DEFAULT_INPUT_IS_FOCUSED_INDEX = 0
    const val DEFAULT_INPUT_TEXT_INDEX = 1
    const val DEFAULT_INPUT_ON_TEXT_CHANGED_INDEX = 2
    const val DEFAULT_INPUT_LABEL_INDEX = 3
    const val DEFAULT_INPUT_HINT_INDEX = 4
    const val DEFAULT_INPUT_SHOW_HINT_INDEX = 5
    const val DEFAULT_INPUT_SHOW_ERROR_INDEX = 6
    const val DEFAULT_INPUT_SHOW_SUCCESS_INDEX = 7
    const val DEFAULT_INPUT_ICON_INDEX = 8
    const val DEFAULT_INPUT_TEXT_AREA_PLACEHOLDER_INDEX = 9
    const val DEFAULT_INPUT_ICON_CLICK_INDEX = 10
    const val DEFAULT_INPUT_SHOW_PASSWORD_INDEX = 11
    const val DEFAULT_INPUT_TYPE_INDEX = 12
    const val DEFAULT_INPUT_SELECTED_COUNTRY_INDEX = 13
    const val DEFAULT_INPUT_FOCUSABLE = 14
    const val DEFAULT_INPUT_HIDE_IS_NOT_FOCUS = 15
    const val DEFAULT_INPUT_KEYBOARD_OPTIONS = 16
    const val DEFAULT_INPUT_INTERACTION_SOURCE = 17
    const val DEFAULT_COUNTRY_CODE_INDEX = 18
    const val DROPDOWN_CAN_EXPANDED_CODE_INDEX = 19
    const val DEFAULT_INPUT_ENABLE = 20
    const val DEFAULT_INPUT_DROPDOWN_SELECTED_INDEX = 1
    const val DEFAULT_INPUT_DROPDOWN_LIST_INDEX = 2


    const val DEFAULT_BUTTON_IS_ENABLED_INDEX = 0
    const val DEFAULT_BUTTON_IS_LOADING_INDEX = 1
    const val DEFAULT_CHECKBOX_IS_CHECKED_INDEX = 0
    const val DEFAULT_RADIO_BUTTON_IS_CHECKED_INDEX = 0
    const val DEFAULT_BUTTON_ID = "default_button"
    const val CUSTOM_LOGO_ID = "custom_logo"
    const val DEFAULT_CHECKBOX_ID = "default_checkbox"
    const val DEFAULT_RADIO_BUTTON_ID = "default_radio_button"
    const val DEFAULT_BUTTON_ICON_ID = "default_button_icon"

    const val DEFAULT_INPUT_ID = "input_field"
    const val FILLED_INPUT_ID = "filled_field"
    const val OUTLINED_INPUT_ID = "outlined_field"
    const val DEFAULT_INPUT_TEXTAREA_ID = "input_textarea_field"
    const val FILLED_INPUT_TEXTAREA_ID = "filled_textarea_field"
    const val OUTLINED_INPUT_TEXTAREA_ID = "outlined_textarea_field"
    const val DEFAULT_INPUT_DROPDOWN_ID = "input_dropdown_field"
    const val FILLED_INPUT_DROPDOWN_ID = "filled_dropdown_field"
    const val OUTLINED_INPUT_DROPDOWN_ID = "outlined_dropdown_field"
    const val PHONE_INPUT_DROPDOWN_ID = "phone_input_dropdown"
    const val CURRENCY_INPUT_DROPDOWN_ID = "currency_input_dropdown"
    const val CREDIT_CARD_INPUT_ID = "credit_card_input"
    const val DEFAULT_CIRCULAR_BUTTON_ID = "circular_button"
    const val BORDER_CIRCULAR_BUTTON_ID = "border_circular_button"
    const val MODAL_BOTTOM_SHEET_ID_CONTENT = "modal_bottom_sheet_content_view"
    const val MODAL_BOTTOM_SHEET_ID = "modal_bottom_sheet_view"
    const val DEFAULT_CLICKABLE_TEXT = "button_clickable_text"
    const val SPACER = "spacer_component"
    const val TOOLBAR = "toolbar_component"
    const val TEXT_DECORATION_BOX = "text_decoration_box"

    const val DEFAULT_CARD_ID = "default_card"

    const val DEFAULT_TITLE_CARD_INDEX = 0
    const val DEFAULT_SUB_TITLE_CARD_INDEX = 1
    const val DEFAULT_TITLE_BUTTON_CARD_INDEX = 2
    const val DEFAULT_CARD_BUTTON_CLICK_INDEX = 3
    const val DEFAULT_CARD_SHOW_CLICKABLE_TEXT = 3

    const val MODAL_BOTTOM_SHEET_HAS_CANCEL_BUTTON_INDEX = 0
    const val DISMISS_MODAL_BOTTOM_SHEET_INDEX = 1
    const val NUMBER_INPUT_ROOT_TAG = "NUMBER_INPUT_ROOT_TAG"
    object Regex {
        val EMAIL = "^[A-Za-z](.*)(@)(.+)(\\.)(.+)".toRegex()
        val ADDRESS = "^.{1,100}$".toRegex()
        val CITY = "^.{2,60}\$".toRegex()
        val NAME = "^[\\w'\\-,.][^0-9_!¡?÷¿/\\\\+=@#\$%ˆ&*(){}|~<>;:]{2,100}\$".toRegex()
        val ITEMNAME = "^(?!\\\\s*\$).+".toRegex()
        val NUMBER = "^[0-9]+$".toRegex()
        val QUANTITY = "^[1-9]+$".toRegex()
        val VALIDPRICE = """^(?:\d{1,3}(?:\.\d{3})*)$""".toRegex()
        val SPECIAL_CHARACTER = "[!@#\$%^&*]".toRegex()
    }
}