package components.foundations

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.roboto_bold
import io.github.andresarangoa.library.generated.resources.roboto_regular
@Composable
fun RobotoTypography(): androidx.compose.material3.Typography {
    // Use the KMP resource system's FontResourceLoader
    val robotoRegular = org.jetbrains.compose.resources.Font(Res.font.roboto_regular)
    val robotoBold = org.jetbrains.compose.resources.Font(Res.font.roboto_bold)

    val RobotoFontFamily = FontFamily(
        robotoRegular,
        robotoBold
    )

    return androidx.compose.material3.Typography(
        titleLarge = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 34.sp
        ),
        titleMedium = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp
        ),
        titleSmall = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp
        ),

        bodyLarge = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp
        ),
        bodySmall = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),

        headlineLarge = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),

        labelSmall = TextStyle(
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp
        ),
    )
}