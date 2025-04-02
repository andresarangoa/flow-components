// src/commonMain/kotlin/components/foundation/CustomIcon.kt
package components.foundation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.automirrored.rounded.TrendingDown
import androidx.compose.material.icons.automirrored.rounded.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * A class to hold all custom icons used in the library.
 * This allows consumers to override default icons with their own.
 */
@Stable
data class CustomIcon(
    // Default icons use Material icons
    var add: ImageVector = Icons.Default.Add,
    var arrowBack: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    var arrowDownward: ImageVector = Icons.Default.ArrowDownward,
    var arrowDropDown: ImageVector = Icons.Default.ArrowDropDown,
    var arrowForward: ImageVector = Icons.AutoMirrored.Filled.ArrowForward,
    var arrowUpward: ImageVector = Icons.Default.ArrowUpward,
    var cancel: ImageVector = Icons.Default.Cancel,
    var check: ImageVector = Icons.Default.Check,
    var checkCircle: ImageVector = Icons.Default.CheckCircle,
    var checkCircleFilled: ImageVector = Icons.Filled.CheckCircle,
    var chevronLeft: ImageVector = Icons.Default.ChevronLeft,
    var chevronRight: ImageVector = Icons.Default.ChevronRight,
    var close: ImageVector = Icons.Default.Close,
    var creditCard: ImageVector = Icons.Default.CreditCard,
    var creditCardFilled: ImageVector = Icons.Filled.CreditCard,
    var error: ImageVector = Icons.Default.Error,
    var errorFilled: ImageVector = Icons.Filled.Error,
    var expandLess: ImageVector = Icons.Default.ExpandLess,
    var expandMore: ImageVector = Icons.Default.ExpandMore,
    var facebook: ImageVector = Icons.Default.Security, // Placeholder as no direct Facebook icon
    var google: ImageVector = Icons.Default.Public, // Placeholder as no direct Google icon
    var home: ImageVector = Icons.Default.Home,
    var homeFilled: ImageVector = Icons.Filled.Home,
    var image: ImageVector = Icons.Default.Image,
    var moreHorizontal: ImageVector = Icons.Default.MoreHoriz,
    var paid: ImageVector = Icons.Default.Paid,
    var paidFilled: ImageVector = Icons.Filled.Paid,
    var send: ImageVector = Icons.AutoMirrored.Filled.Send,
    var settings: ImageVector = Icons.Default.Settings,
    var settingsFilled: ImageVector = Icons.Filled.Settings,
    var trendingDown: ImageVector = Icons.AutoMirrored.Filled.TrendingDown,
    var trendingUp: ImageVector = Icons.AutoMirrored.Filled.TrendingUp,
    var visibilityOff: ImageVector = Icons.Default.VisibilityOff,
    var visibilityOn: ImageVector = Icons.Default.Visibility,
    var closeBottomSheet: ImageVector = Icons.Default.Close,
    var dragHandleBottomSheet: ImageVector = Icons.Default.DragHandle,
    var camera: ImageVector = Icons.Default.Camera,
    var iconCamera: ImageVector = Icons.Default.PhotoCamera,
    var unchecked: ImageVector = Icons.Default.CheckBoxOutlineBlank,
    var checkedCancel: ImageVector = Icons.Default.Cancel,
    var checkedCheck: ImageVector = Icons.Default.CheckBox
) {
    /**
     * Gets all icons in the system with their respective names
     */
    fun getAllIcons(): List<Pair<ImageVector, String>> {
        return listOf(
            add to "add",
            arrowBack to "arrowBack",
            arrowDownward to "arrowDownward",
            arrowDropDown to "arrowDropDown",
            arrowForward to "arrowForward",
            arrowUpward to "arrowUpward",
            cancel to "cancel",
            check to "check",
            checkCircle to "checkCircle",
            checkCircleFilled to "checkCircleFilled",
            chevronLeft to "chevronLeft",
            chevronRight to "chevronRight",
            close to "close",
            creditCard to "creditCard",
            creditCardFilled to "creditCardFilled",
            error to "error",
            errorFilled to "errorFilled",
            expandLess to "expandLess",
            expandMore to "expandMore",
            facebook to "facebook",
            google to "google",
            home to "home",
            homeFilled to "homeFilled",
            image to "image",
            moreHorizontal to "moreHorizontal",
            paid to "paid",
            paidFilled to "paidFilled",
            send to "send",
            settings to "settings",
            settingsFilled to "settingsFilled",
            trendingDown to "trendingDown",
            trendingUp to "trendingUp",
            visibilityOff to "visibilityOff",
            visibilityOn to "visibilityOn",
            closeBottomSheet to "closeBottomSheet",
            dragHandleBottomSheet to "dragHandleBottomSheet",
            camera to "camera",
            iconCamera to "iconCamera",
            unchecked to "unchecked",
            checkedCancel to "checkedCancel",
            checkedCheck to "checkedCheck"
        )
    }
}

/**
 * Dark theme variant of custom icons (using rounded style for visual distinction)
 */
val CustomIconDark = CustomIcon(
    add = Icons.Rounded.Add,
    arrowBack = Icons.AutoMirrored.Rounded.ArrowBack,
    arrowDownward = Icons.Rounded.ArrowDownward,
    arrowDropDown = Icons.Rounded.ArrowDropDown,
    arrowForward = Icons.AutoMirrored.Rounded.ArrowForward,
    arrowUpward = Icons.Rounded.ArrowUpward,
    cancel = Icons.Rounded.Cancel,
    check = Icons.Rounded.Check,
    checkCircle = Icons.Rounded.CheckCircle,
    checkCircleFilled = Icons.Rounded.CheckCircle,
    chevronLeft = Icons.Rounded.ChevronLeft,
    chevronRight = Icons.Rounded.ChevronRight,
    close = Icons.Rounded.Close,
    creditCard = Icons.Rounded.CreditCard,
    creditCardFilled = Icons.Rounded.CreditCard,
    error = Icons.Rounded.Error,
    errorFilled = Icons.Rounded.Error,
    expandLess = Icons.Rounded.ExpandLess,
    expandMore = Icons.Rounded.ExpandMore,
    facebook = Icons.Rounded.Security, // Placeholder
    google = Icons.Rounded.Public, // Placeholder
    home = Icons.Rounded.Home,
    homeFilled = Icons.Rounded.Home,
    image = Icons.Rounded.Image,
    moreHorizontal = Icons.Rounded.MoreHoriz,
    paid = Icons.Rounded.Paid,
    paidFilled = Icons.Rounded.Paid,
    send = Icons.AutoMirrored.Rounded.Send,
    settings = Icons.Rounded.Settings,
    settingsFilled = Icons.Rounded.Settings,
    trendingDown = Icons.AutoMirrored.Rounded.TrendingDown,
    trendingUp = Icons.AutoMirrored.Rounded.TrendingUp,
    visibilityOff = Icons.Rounded.VisibilityOff,
    visibilityOn = Icons.Rounded.Visibility,
    closeBottomSheet = Icons.Rounded.Close,
    dragHandleBottomSheet = Icons.Rounded.DragHandle,
    camera = Icons.Rounded.Camera,
    iconCamera = Icons.Rounded.PhotoCamera,
    unchecked = Icons.Rounded.CheckBoxOutlineBlank,
    checkedCancel = Icons.Rounded.Cancel,
    checkedCheck = Icons.Rounded.CheckBox
)

/**
 * Light theme variant of custom icons (using default style)
 */
val CustomIconLight = CustomIcon(
    // Uses all the defaults (which are the "Default" variants)
)

/**
 * Global object to access and modify icons throughout the app
 */
object IconProvider {
    private var _current = CustomIconLight

    /**
     * Current set of icons to use in the library
     */
    var current: CustomIcon
        get() = _current
        set(value) {
            _current = value
        }
}

/**
 * Returns the appropriate icon set based on the current theme
 */
fun getCustomIconBasedOnTheme(isDarkTheme: Boolean): CustomIcon {
    return if (isDarkTheme) {
        CustomIconDark
    } else {
        CustomIconLight
    }
}