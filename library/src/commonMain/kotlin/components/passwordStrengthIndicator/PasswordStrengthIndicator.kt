package components.passwordStrengthIndicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import components.AppColors
import data.model.PasswordStrength
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.label_average
import io.github.andresarangoa.library.generated.resources.label_low
import io.github.andresarangoa.library.generated.resources.label_strong
import io.github.kotlin.data.model.ConstantsValuesDp
import org.jetbrains.compose.resources.stringResource

@Composable
fun PasswordStrengthIndicator(strength: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StrengthBar(
            color = when (strength) {
                in PasswordStrength.LOW.strength until PasswordStrength.AVERAGE_MIN.strength -> {
                    AppColors.error500
                }

                in PasswordStrength.AVERAGE_MIN.strength..PasswordStrength.AVERAGE_MAX.strength -> {
                    AppColors.warning500
                }

                PasswordStrength.STRONG.strength -> {
                    AppColors.success500
                }

                else -> {
                    AppColors.neutral500
                }
            }
        )
        Spacer(modifier = Modifier.width(ConstantsValuesDp.value_dp_8))
        StrengthBar(
            color = when (strength) {
                in PasswordStrength.AVERAGE_MIN.strength..PasswordStrength.AVERAGE_MAX.strength -> {
                    AppColors.warning500
                }

                PasswordStrength.STRONG.strength -> {
                    AppColors.success500
                }

                else -> {
                    AppColors.neutral500
                }
            }
        )
        Spacer(modifier = Modifier.width(ConstantsValuesDp.value_dp_8))
        StrengthBar(
            color = when (strength) {
                PasswordStrength.STRONG.strength -> {
                    AppColors.success500
                }

                else -> {
                    AppColors.neutral500
                }
            }
        )

        Box(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = when (strength) {
                    in PasswordStrength.LOW.strength until PasswordStrength.AVERAGE_MIN.strength -> {
                        stringResource(Res.string.label_low)
                    }

                    in PasswordStrength.AVERAGE_MIN.strength..PasswordStrength.AVERAGE_MAX.strength -> {
                        stringResource(Res.string.label_average)
                    }

                    PasswordStrength.STRONG.strength -> {
                        val stringResource = stringResource(Res.string.label_strong)
                        stringResource
                    }

                    else -> {
                        ""
                    }
                },
                color = when (strength) {
                    in PasswordStrength.LOW.strength until PasswordStrength.AVERAGE_MIN.strength -> {
                        AppColors.error500
                    }

                    in PasswordStrength.AVERAGE_MIN.strength..PasswordStrength.AVERAGE_MAX.strength -> {
                        AppColors.warning500
                    }

                    PasswordStrength.STRONG.strength -> {
                        AppColors.success500
                    }

                    else -> {
                        AppColors.neutral500
                    }
                },
//                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
private fun StrengthBar(color: Color) {
    Box(
        modifier = Modifier
            .width(ConstantsValuesDp.value_dp_90)
            .height(ConstantsValuesDp.value_dp_6)
            .clip(RoundedCornerShape(ConstantsValuesDp.value_dp_10))
            .background(color)
    )
}
