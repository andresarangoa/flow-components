package components

import androidx.compose.ui.graphics.Color

data class ColorData(
    val color: Color,
    val name: String,
    val hex: String,
    val rgb: String,
)
data class AppColorScheme(
    // Icon
    val iconPrimaryButton: Color = Color.Unspecified,
    val iconSecondaryButton: Color = Color.Unspecified,
    val iconDisableButton: Color = Color.Unspecified,
    val iconCloseButton: Color = Color.Unspecified,
    val iconChevronButton: Color = Color.Unspecified,
    val iconCancelDefault: Color = Color.Unspecified,
    val iconCancelActive: Color = Color.Unspecified,
    val iconCancelInvert: Color = Color.Unspecified,
    val iconFilled: Color = Color.Unspecified,
    val iconBold: Color = Color.Unspecified,
    val iconDefault: Color = Color.Unspecified,

    // Surface
    val surfacePrimaryButton: Color = Color.Unspecified,
    val surfaceSecondaryButton: Color = Color.Unspecified,
    val surfaceQuaternary: Color = Color.Unspecified,
    val surfaceTertiaryButton: Color = Color.Unspecified,
    val surfaceQuaternaryButton: Color = Color.Unspecified,
    val surfaceOnPrimary: Color = Color.Unspecified,
    val surfaceQuaternaryOutlineButton: Color = Color.Unspecified,
    val surfaceQuaternaryInput: Color = Color.Unspecified,
    val quaternaryBorder: Color = Color.Unspecified,
    val surfaceOptionalButton: Color = Color.Unspecified,
    val surfaceOptionalNavbar:Color = Color.Unspecified,
    val surfaceDestructiveButton: Color = Color.Unspecified,
    val surfaceCardButton: Color = Color.Unspecified,
    val surfaceTabBarBottom: Color = Color.Unspecified,
    val surfaceOnTabBarBottom: Color = Color.Unspecified,
    val surfaceCloseButtom: Color = Color.Unspecified,
    val surfaceDefault: Color = Color.Unspecified,
    val surfaceFocus: Color = Color.Unspecified,
    val surfaceSuccess: Color = Color.Unspecified,
    val surfaceFilled: Color = Color.Unspecified,
    val surfacePrimary: Color = Color.Unspecified,
    val surfaceSecondary: Color = Color.Unspecified,
    val surfaceTertiary: Color = Color.Unspecified,
    val surfaceModerate: Color = Color.Unspecified,
    val surfaceContrast: Color = Color.Unspecified,
    val surfaceStrong: Color = Color.Unspecified,
    val surfaceAverage: Color = Color.Unspecified,
    val surfaceWeak: Color = Color.Unspecified,
    val surfaceAlpha65: Color = Color.Unspecified,
    val surfaceAlpha15: Color = Color.Unspecified,
    val surfaceAlpha35: Color = Color.Unspecified,
    val surfaceAlpha80: Color = Color.Unspecified,
    val surfaceAlpha60: Color = Color.Unspecified,
    val surfaceAlpha70: Color = Color.Unspecified,

    // Text
    val textPrimaryButton: Color = Color.Unspecified,
    val textSecondaryButton: Color = Color.Unspecified,
    val textQuaternaryButton: Color = Color.Unspecified,
    val textQuaternaryOutlineButton: Color = Color.Unspecified,
    val textPrimary: Color = Color.Unspecified,
    val textSecondary: Color = Color.Unspecified,
    val textQuaternary: Color = Color.Unspecified,
    val textAdditional: Color = Color.Unspecified,
    val textDisable: Color = Color.Unspecified,
    val textDisableButton: Color = Color.Unspecified,
    val textTertiary: Color = Color.Unspecified,
    val textInvert: Color = Color.Unspecified,
    val textError: Color = Color.Unspecified,
    val textSuccess: Color = Color.Unspecified,
    val textAverage: Color = Color.Unspecified,
    val textLink: Color = Color.Unspecified,
    val textBottomBanner: Color = Color.Unspecified,


    // Border
    val borderMinimal: Color = Color.Unspecified,
    val borderSubtle: Color = Color.Unspecified,
    val borderModerate: Color = Color.Unspecified,
    val borderCircular: Color = Color.Unspecified,
    val borderSoft: Color = Color.Unspecified,
    val borderBold: Color = Color.Unspecified,
    val borderLight: Color = Color.Unspecified,
    val borderError: Color = Color.Unspecified
)


object AppColors {
    // Primary colors
    val blue50 = Color(0xFFE3F2F6)
    val blue100 = Color(0xFFBCDDE5)
    val blue200 = Color(0xFF94C8D4)
    val blue300 = Color(0xFF6CB3C3)
    val blue400 = Color(0xFF469FB2)
    val blue500 = Color(0xFF0C4A59) // Base color
    val blue600 = Color(0xFF0B4250)
    val blue700 = Color(0xFF093947)
    val blue800 = Color(0xFF07303E)
    val blue900 = Color(0xFF052734)



    // purple
    val purple50 = Color(0xFFFDFCFE)
    val purple100 = Color(0xFFFAF5FC)
    val purple200 = Color(0xFFF7F0FB)
    val purple300 = Color(0xFFF4EAF9)
    val purple400 = Color(0xFFF1E5F8)
    val purple500 = Color(0xFFEEDFF6)
    val purple600 = Color(0xFFD9CBE0)
    val purple700 = Color(0xFFA99EAF)
    val purple800 = Color(0xFF837B87)
    val purple900 = Color(0xFF645E67)
    // Secondary colors
    // cyan
    val cyan50 = Color(0xFFFAFCFC)
    val cyan100 = Color(0xFFEFF7F6)
    val cyan200 = Color(0xFFE8F3F2)
    val cyan300 = Color(0xFFDDEEEC)
    val cyan400 = Color(0xFFD6EAE8)
    val cyan500 = Color(0xFFCCE5E2)
    val cyan600 = Color(0xFFBAD0CE)
    val cyan700 = Color(0xFF91A3A0)
    val cyan800 = Color(0xFF707E7C)
    val cyan900 = Color(0xFF56605F)
    // yellow
    val yellow50 = Color(0xFFFFFCF8)
    val yellow100 = Color(0xFFFFF6E8)
    val yellow200 = Color(0xFFFFF1DD)
    val yellow300 = Color(0xFFFEEBCE)
    val yellow400 = Color(0xFFFEE7C5)
    val yellow500 = Color(0xFFFEE1B6)
    val yellow600 = Color(0xFFE7CDA6)
    val yellow700 = Color(0xFFB4A081)
    val yellow800 = Color(0xFF8C7C64)
    val yellow900 = Color(0xFF6B5F4C)
    // Neutral colors
    // Gray
    val white = Color(0xFFFFFFFF)
    val neutral50 = Color(0xFFF2F2F2)
    val neutral100 = Color(0xFFD7D7D7)
    val neutral200 = Color(0xFFC3C3C3)
    val neutral300 = Color(0xFFA8A8A8)
    val neutral400 = Color(0xFF979797)
    val neutral500 = Color(0xFF7D7D7D)
    val neutral600 = Color(0xFF727272)
    val neutral700 = Color(0xFF595959)
    val neutral800 = Color(0xFF454545)
    val neutral900 = Color(0xFF353535)
    val black = Color(0xFF111111)
    // Alert
    // Message
    // Notification colors
    val notification50 = Color(0xFFEFF6FF)
    val notification100 = Color(0xFFCCE3FF)
    val notification200 = Color(0xFFB4D5FF)
    val notification300 = Color(0xFF92C2FF)
    val notification400 = Color(0xFF7DB6FF)
    val notification500 = Color(0xFF5CA4FF)
    val notification600 = Color(0xFF5495E8)
    val notification700 = Color(0xFF4174B5)
    val notification800 = Color(0xFF335A8C)
    val notification900 = Color(0xFF27456B)
    // Success colors
    val success50 = Color(0xFFF3FAEF)
    val success100 = Color(0xFFD9F1CE)
    val success200 = Color(0xFFC7EAB6)
    val success300 = Color(0xFFAEE095)
    val success400 = Color(0xFF9EDA81)
    val success500 = Color(0xFF86D161)
    val success600 = Color(0xFF7ABE58)
    val success700 = Color(0xFF5F9445)
    val success800 = Color(0xFF4A7335)
    val success900 = Color(0xFF385829)
    // Warning colors
    val warning50 = Color(0xFFFDF9EF)
    val warning100 = Color(0xFFF9ECCD)
    val warning200 = Color(0xFFF7E3B5)
    val warning300 = Color(0xFFF3D693)
    val warning400 = Color(0xFFF1CE7E)
    val warning500 = Color(0xFFEDC25E)
    val warning600 = Color(0xFFD8B156)
    val warning700 = Color(0xFFA88A43)
    val warning800 = Color(0xFF826B34)
    val warning900 = Color(0xFF645127)
    // Error colors
    val error50 = Color(0xFFFCEBEC)
    val error100 = Color(0xFFF6C1C5)
    val error200 = Color(0xFFF2A3A9)
    val error300 = Color(0xFFEC7882)
    val error400 = Color(0xFFE85E6A)
    val error500 = Color(0xFFE23645)
    val error600 = Color(0xFFCE313F)
    val error700 = Color(0xFFA02631)
    val error800 = Color(0xFF7C1E26)
    val error900 = Color(0xFF5F171D)

    val blueGray50 = Color(0xFFECEFF1)
    val blueGray100 = Color(0xFFCFD8DC)
    val blueGray200 = Color(0xFFB0BEC5)
    val blueGray300 = Color(0xFF90A4AE)
    val blueGray400 = Color(0xFF78909C)
    val blueGray500 = Color(0xFF607D8B)
    val blueGray600 = Color(0xFF546E7A)
    val blueGray700 = Color(0xFF455A64)
    val blueGray800 = Color(0xFF37474F)
    val blueGray900 = Color(0xFF263238)


    object Constants {
        // Purple Colors
        const val color_50 = "50"
        const val purple50Hex = "#fdfcfe"
        const val purple50Rgb = "rgb(253, 252, 254)"
        const val color_100 = "100"
        const val purple100Hex = "#faf5fc"
        const val purple100Rgb = "rgb(250, 245, 252)"
        const val color_200 = "200"
        const val purple200Hex = "#f7f0fb"
        const val purple200Rgb = "rgb(247, 240, 251)"
        const val color_300 = "300"
        const val purple300Hex = "#f4eaf9"
        const val purple300Rgb = "rgb(244, 234, 249)"
        const val color_400 = "400"
        const val purple400Hex = "#f1e5f8"
        const val purple400Rgb = "rgb(241, 229, 248)"
        const val color_500 = "500"
        const val purple500Hex = "#eedff6"
        const val purple500Rgb = "rgb(238, 223, 246)"
        const val color_600 = "600"
        const val purple600Hex = "#d9cbe0"
        const val purple600Rgb = "rgb(217, 203, 224)"
        const val color_700 = "700"
        const val purple700Hex = "#a99eaf"
        const val purple700Rgb = "rgb(169, 158, 175)"
        const val color_800 = "800"
        const val purple800Hex = "#837b87"
        const val purple800Rgb = "rgb(131, 123, 135)"
        const val color_900 = "900"
        const val purple900Hex = "#645e67"
        const val purple900Rgb = "rgb(100, 94, 103)"
        // Cyan Colors
        const val cyan50Hex = "#fafcfc"
        const val cyan50Rgb = "rgb(250, 252, 252)"
        const val cyan100Hex = "#eff7f6"
        const val cyan100Rgb = "rgb(239, 247, 246)"
        const val cyan200Hex = "#e8f3f2"
        const val cyan200Rgb = "rgb(232, 243, 242)"
        const val cyan300Hex = "#ddecec"
        const val cyan300Rgb = "rgb(221, 238, 236)"
        const val cyan400Hex = "#d6eae8"
        const val cyan400Rgb = "rgb(214, 234, 232)"
        const val cyan500Hex = "#cce5e2"
        const val cyan500Rgb = "rgb(204, 229, 226)"
        const val cyan600Hex = "#bad0ce"
        const val cyan600Rgb = "rgb(186, 208, 206)"
        const val cyan700Hex = "#91a3a0"
        const val cyan700Rgb = "rgb(145, 163, 160)"
        const val cyan800Hex = "#707e7c"
        const val cyan800Rgb = "rgb(112, 126, 124)"
        const val cyan900Hex = "#56605f"
        const val cyan900Rgb = "rgb(86, 96, 95)"
        // Yellow Colors
        const val yellow50Hex = "#fffcf8"
        const val yellow50Rgb = "rgb(255, 252, 248)"
        const val yellow100Hex = "#fff6e8"
        const val yellow100Rgb = "rgb(255, 246, 232)"
        const val yellow200Hex = "#fff1dd"
        const val yellow200Rgb = "rgb(255, 241, 221)"
        const val yellow300Hex = "#feebce"
        const val yellow300Rgb = "rgb(254, 235, 206)"
        const val yellow400Hex = "#fee7c5"
        const val yellow400Rgb = "rgb(254, 231, 197)"
        const val yellow500Hex = "#fee1b6"
        const val yellow500Rgb = "rgb(254, 225, 182)"
        const val yellow600Hex = "#e7cda6"
        const val yellow600Rgb = "rgb(231, 205, 166)"
        const val yellow700Hex = "#b4a081"
        const val yellow700Rgb = "rgb(180, 160, 129)"
        const val yellow800Hex = "#8c7c64"
        const val yellow800Rgb = "rgb(140, 124, 100)"
        const val yellow900Hex = "#6b5f4c"
        const val yellow900Rgb = "rgb(107, 95, 76)"
        // Gray (Neutral) Colors
        const val whiteHex = "#ffffff"
        const val whiteRgb = "rgb(255, 255, 255)"
        const val neutral50Hex = "#f2f2f2"
        const val neutral50Rgb = "rgb(242, 242, 242)"
        const val neutral100Hex = "#d7d7d7"
        const val neutral100Rgb = "rgb(215, 215, 215)"
        const val neutral200Hex = "#c3c3c3"
        const val neutral200Rgb = "rgb(195, 195, 195)"
        const val neutral300Hex = "#a8a8a8"
        const val neutral300Rgb = "rgb(168, 168, 168)"
        const val neutral400Hex = "#979797"
        const val neutral400Rgb = "rgb(151, 151, 151)"
        const val neutral500Hex = "#7d7d7d"
        const val neutral500Rgb = "rgb(125, 125, 125)"
        const val neutral600Hex = "#727272"
        const val neutral600Rgb = "rgb(114, 114, 114)"
        const val neutral700Hex = "#595959"
        const val neutral700Rgb = "rgb(89, 89, 89)"
        const val neutral800Hex = "#454545"
        const val neutral800Rgb = "rgb(69, 69, 69)"
        const val neutral900Hex = "#353535"
        const val neutral900Rgb = "rgb(53, 53, 53)"
        const val blackHex = "#111111"
        const val blackRgb = "rgb(17, 17, 17)"
        // Notification Colors
        const val notification50Hex = "#eff6ff"
        const val notification50Rgb = "rgb(239, 246, 255)"
        const val notification100Hex = "#cce3ff"
        const val notification100Rgb = "rgb(204, 227, 255)"
        const val notification200Hex = "#b4d5ff"
        const val notification200Rgb = "rgb(180, 213, 255)"
        const val notification300Hex = "#92c2ff"
        const val notification300Rgb = "rgb(146, 194, 255)"
        const val notification400Hex = "#7db6ff"
        const val notification400Rgb = "rgb(125, 182, 255)"
        const val notification500Hex = "#5ca4ff"
        const val notification500Rgb = "rgb(92, 164, 255)"
        const val notification600Hex = "#5495e8"
        const val notification600Rgb = "rgb(84, 149, 232)"
        const val notification700Hex = "#4174b5"
        const val notification700Rgb = "rgb(65, 116, 181)"
        const val notification800Hex = "#335a8c"
        const val notification800Rgb = "rgb(51, 90, 140)"
        const val notification900Hex = "#27456b"
        const val notification900Rgb = "rgb(39, 69, 107)"
        // Success Colors
        const val success50Hex = "#f3faef"
        const val success50Rgb = "rgb(243, 250, 239)"
        const val success100Hex = "#d9f1ce"
        const val success100Rgb = "rgb(217, 241, 206)"
        const val success200Hex = "#c7eab6"
        const val success200Rgb = "rgb(199, 234, 182)"
        const val success300Hex = "#aee095"
        const val success300Rgb = "rgb(174, 224, 149)"
        const val success400Hex = "#9eda81"
        const val success400Rgb = "rgb(158, 218, 129)"
        const val success500Hex = "#86d161"
        const val success500Rgb = "rgb(134, 209, 97)"
        const val success600Hex = "#7abe58"
        const val success600Rgb = "rgb(122, 190, 88)"
        const val success700Hex = "#5f9445"
        const val success700Rgb = "rgb(95, 148, 69)"
        const val success800Hex = "#4a7335"
        const val success800Rgb = "rgb(74, 115, 53)"
        const val success900Hex = "#385829"
        const val success900Rgb = "rgb(56, 88, 41)"
        // Warning Colors
        const val warning50Hex = "#fdf9ef"
        const val warning50Rgb = "rgb(253, 249, 239)"
        const val warning100Hex = "#f9eccd"
        const val warning100Rgb = "rgb(249, 236, 205)"
        const val warning200Hex = "#f7e3b5"
        const val warning200Rgb = "rgb(247, 227, 181)"
        const val warning300Hex = "#f3d693"
        const val warning300Rgb = "rgb(243, 214, 147)"
        const val warning400Hex = "#f1ce7e"
        const val warning400Rgb = "rgb(241, 206, 126)"
        const val warning500Hex = "#edc25e"
        const val warning500Rgb = "rgb(237, 194, 94)"
        const val warning600Hex = "#d8b156"
        const val warning600Rgb = "rgb(216, 177, 86)"
        const val warning700Hex = "#a88a43"
        const val warning700Rgb = "rgb(168, 138, 67)"
        const val warning800Hex = "#826b34"
        const val warning800Rgb = "rgb(130, 107, 52)"
        const val warning900Hex = "#645127"
        const val warning900Rgb = "rgb(100, 81, 39)"
        // Error Colors
        const val error50Hex = "#fcebec"
        const val error50Rgb = "rgb(252, 235, 236)"
        const val error100Hex = "#f6c1c5"
        const val error100Rgb = "rgb(246, 193, 197)"
        const val error200Hex = "#f2a3a9"
        const val error200Rgb = "rgb(242, 163, 169)"
        const val error300Hex = "#ec7882"
        const val error300Rgb = "rgb(236, 120, 130)"
        const val error400Hex = "#e85e6a"
        const val error400Rgb = "rgb(232, 94, 106)"
        const val error500Hex = "#e23645"
        const val error500Rgb = "rgb(226, 54, 69)"
        const val error600Hex = "#ce313f"
        const val error600Rgb = "rgb(206, 49, 63)"
        const val error700Hex = "#a02631"
        const val error700Rgb = "rgb(160, 38, 49)"
        const val error800Hex = "#7c1e26"
        const val error800Rgb = "rgb(124, 30, 38)"
        const val error900Hex = "#5f171d"
        const val error900Rgb = "rgb(95, 23, 29)"
    }
}

