package components.toolbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToolbarTopContent(
    state: DefaultToolbarStateImp = DefaultToolbarStateImp(),
    imageButton: @Composable () -> Unit = {}
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        imageButton()
        if (state.rightStringIsShowed) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { state.onSkipTap() },
                text = state.rightString,
//                style = RobotoTypography.bodySmall,
            )
        }
    }
}