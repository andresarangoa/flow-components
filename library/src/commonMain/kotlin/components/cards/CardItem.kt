package components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.buttons.circular.DefaultCircleButton
import components.buttons.circular.DefaultCircularButtonImp
import components.buttons.circular.defaultCircularButtonTheme
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.icon_cancel
import io.github.kotlin.data.model.ConstantsValuesDp.value_dp_12
import io.github.kotlin.data.model.ConstantsValuesDp.value_dp_4
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun CardItem(
    icon: DrawableResource = Res.drawable.icon_cancel,
    backgroundIconColor: Color = Color.Red,
    text: String = "",
    onClick: () -> Unit = {},
    description: String = "",
    showArrow: Boolean = true,
    bgColor: Color,
    textColor: Color
) {
      Card(
          modifier = Modifier
              .fillMaxWidth()
              .clickable { /* Handle click event if needed */ },
          shape = RoundedCornerShape(value_dp_12),
          elevation = CardDefaults.cardElevation(defaultElevation = value_dp_4),
          colors = CardDefaults.cardColors(containerColor = bgColor)
      ) {
          Box(
              modifier = Modifier
                  .fillMaxWidth()
                  .background(bgColor)
          ) {
              Column {
                  Row(
                      modifier = Modifier
                          .fillMaxWidth()
                          .clickable {
                              onClick()
                          }
                          .padding(16.dp),
                      verticalAlignment = Alignment.CenterVertically
                  ) {
                      DefaultCircleButton(
                          modifier = Modifier.size(35.dp),
                          theme = defaultCircularButtonTheme(
                              backgroundColor = backgroundIconColor,
                              icon = icon,
                              iconModifier = Modifier.size(15.dp)
                          ),
                          state = DefaultCircularButtonImp(
                              onButtonClick = {}
                          )
                      )
                      Spacer(modifier = Modifier.width(16.dp))
                      Column {
                          Text(
                              text = text,
                              color =  textColor,
                              style = TextStyle(
                                  fontWeight = FontWeight.Bold,
                                  fontSize = 15.sp
                              )
                          )
                          if(description.isNotBlank() ){
                              Text(
                                  text = description,
                                  color = textColor,
                                  style = TextStyle(
                                      fontWeight = FontWeight.Normal,
                                      fontSize = 13.sp
                                  )
                              )
                          }
                      }
                      if(showArrow){
                          Spacer(modifier = Modifier.weight(1f))
                          Icon(
                              imageVector = Icons.Filled.ArrowBackIosNew,
                              contentDescription = "",
                              modifier = Modifier.size(30.dp),
                              tint = Color.Gray
                          )
                      }
                  }
              }
          }

  }
}