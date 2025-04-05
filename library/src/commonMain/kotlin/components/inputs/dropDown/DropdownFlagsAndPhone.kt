package components.inputs.dropDown

import Country
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import components.FontsSize
import components.Size
import components.foundation.CustomIcon
import components.foundation.CustomIconRes
import data.model.DefaultInputState
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.country_flag
import io.github.andresarangoa.library.generated.resources.phone_number
import io.github.kotlin.components.buttons.rememberDefaultInputState
import io.github.kotlin.data.model.ConstantsValuesDp
import io.github.kotlin.data.model.ConstantsValuesDp.value_dp_30
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

object Padding {
    val small = 4.dp
    val normal = 8.dp
    val large = 16.dp
    val xLarge = 24.dp
}

@Composable
fun DropdownFlagsAndPhone(
    countries: Map<String, Country>,
    state: DefaultInputState = rememberDefaultInputState(),
    expanded: Boolean = false,
) {
    var expanded by remember { mutableStateOf(expanded) }
    var selectedCountry by remember { mutableStateOf(countries[state.defaultCountryCode]) }

    Column(modifier = Modifier.padding(start = Padding.normal).testTag("PHONE_INPUT_DROPDOWN_ID")) {
        Text(
            text = stringResource(Res.string.phone_number),
//            style = RobotoTypography.headlineSmall.copy(color = Color.Gray),
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter =
                painterResource(
                    selectedCountry?.image ?: countries["US"]?.image ?: CustomIconRes.errorFilled,
                ),
                contentDescription = stringResource(Res.string.country_flag),
            )
            Spacer(Modifier.width(ConstantsValuesDp.value_dp_10))
            Text(
                text = "+${selectedCountry?.phone ?: countries["US"]?.phone}",
//                style = RobotoTypography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
//            IconDefault(
//                iconTheme = IconTheme(icon = CustomIcon.arrowDropDown, tint = Color.Black),
//                modifier = Modifier.clickable { expanded = !expanded },
//            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            countries.forEach { (_, country) ->
                DropdownMenuItem(
                    onClick = {},
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Image(
                                painter = painterResource(country.image),
                                contentDescription = null,
                                modifier = Modifier.size(value_dp_30),
                            )
                            Spacer(modifier = Modifier.width(Size.large))
                            Text(text = country.name, fontSize = FontsSize.large)
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "+${country.phone}", fontSize = FontsSize.large)
                        }
                    })
            }
        }
    }
}