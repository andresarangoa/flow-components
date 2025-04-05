package components.buttons.circular

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import data.model.DefaultCircularButtonState
import io.github.kotlin.components.buttons.rememberDefaultCircularButtonState
import org.jetbrains.compose.resources.painterResource

@Composable
fun DefaultCircleButton(
    modifier: Modifier = Modifier,
    theme: DefaultCircularButtonTheme = defaultCircularButtonTheme(),
    state: DefaultCircularButtonState = rememberDefaultCircularButtonState(),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(56.dp)
                .background(theme.backgroundColor, CircleShape)
                .testTag("DEFAULT_CIRCULAR_BUTTON_ID")
                .clickable(onClick = state.onButtonClick),
        ) {
            if (state.isLoading) {
//                DotPulseProgressIndicator(
//                    progressDotsColor = theme.iconColor
//                )
            } else {
                IconButton(
                    onClick = state.onButtonClick
                ) {
                    Icon(
                        modifier = theme.iconModifier,
                        painter = painterResource(theme.icon),
                        contentDescription = "",
                        tint = theme.iconColor
                    )
                }
            }
        }
        if (state.buttonTitle.isNotEmpty()) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = state.buttonTitle, style = theme.titleButtonStyle)
        }
    }
}