package components.termsAndPrivacityText

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.label_privacy_policy
import io.github.andresarangoa.library.generated.resources.label_terms_and_conditions
import io.github.andresarangoa.library.generated.resources.label_terms_and_privacy
import io.github.andresarangoa.library.generated.resources.label_and
import org.jetbrains.compose.resources.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.sp
import components.AppColors
import androidx.compose.ui.text.withAnnotation
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

private const val TAG_TERMS_AND_CONDITIONS = "TAG_TERMS_AND_CONDITIONS"
private const val TAG_PRIVACY_POLICY = "TAG_PRIVACY_POLICY"
private const val ANNOTATION_TERMS_AND_CONDITIONS = "ANNOTATION_TERMS_AND_CONDITIONS"
private const val ANNOTATION_PRIVACY_POLICY = "ANNOTATION_PRIVACY_POLICY"

@OptIn(ExperimentalTextApi::class)
@Composable
fun TermsAndPrivacyText(
    modifier: Modifier = Modifier,
    termsAndConditions: String = stringResource(Res.string.label_terms_and_conditions),
    privacyPolicy: String = stringResource(Res.string.label_privacy_policy)
) {
    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = AppColors.neutral600,
                fontSize = 14.sp
            )
        ) {
            append("${stringResource(Res.string.label_terms_and_privacy)} ")
            withAnnotation(TAG_TERMS_AND_CONDITIONS, ANNOTATION_TERMS_AND_CONDITIONS) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = AppColors.black,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append(termsAndConditions)
                }
            }
            append(" ${stringResource(Res.string.label_and)} ")
            withAnnotation(TAG_PRIVACY_POLICY, ANNOTATION_PRIVACY_POLICY) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = AppColors.black,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append(privacyPolicy)
                }
            }
        }
    }

    ClickableText(modifier = modifier, text = text) {
        text.getStringAnnotations(it, it).firstOrNull()?.tag?.let { tag ->
            when (tag) {
                TAG_TERMS_AND_CONDITIONS -> {
//                    Toast.makeText(context, "Terms and conditions clicked.", Toast.LENGTH_SHORT)
//                        .show()
                }

                TAG_PRIVACY_POLICY -> {
//                    Toast.makeText(context, "Privacy Policy clocked.", Toast.LENGTH_SHORT).show()
                }

                else -> Unit
            }
        }
    }
}