package io.github.kotlin.components.toolbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import components.buttons.ImageButton
import components.foundations.RobotoTypography
import components.toolbar.DefaultToolbarStateImp
import components.toolbar.ToolbarTopContent
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.ic_arrow_back
import io.github.kotlin.components.buttons.rememberDefaultToolbarState
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun BackButtonAndTitleToolbar(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: DrawableResource = Res.drawable.ic_arrow_back,
    tint: Color = Color.Gray,
    state: DefaultToolbarStateImp = rememberDefaultToolbarState(),
    textStyle: TextStyle = RobotoTypography().titleLarge.copy(
        fontWeight = FontWeight.Bold,
        color = Color.Gray
    ),
    onBackPressed: () -> Unit
) {
    if (state.isColumn) {
        Box(
            modifier = modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                if (state.isArrowShowed) {
                    ToolbarTopContent(
                        state = state,
                        imageButton = {
                            ImageButton(
                                drawableRes = icon,
                                contentDescription = "",//R.string.label_log_in,
                                onClick = onBackPressed,
                                tint = tint,
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(horizontal = 8.dp),
                            )
                        }
                    )
                } else {
                    Spacer(modifier = Modifier.height(40.dp))
                }
                text?.let {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                            ),
                        text = it,
                        style = textStyle
                    )
                }
            }
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ToolbarTopContent(
                state = state,
                imageButton = {
                    ImageButton(
                        drawableRes = icon,
                        contentDescription = "",//R.string.label_log_in,
                        onClick = onBackPressed,
                        tint = tint,
                        modifier = Modifier.size(25.dp)
                    )
                }
            )
            Box(modifier = Modifier.fillMaxWidth()) {
                text?.let {
                    Text(
                        text = text,
                        textAlign = TextAlign.Center,
                        style = textStyle,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}
