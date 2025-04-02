import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import org.app.example.navigation.ScreenStartEvent

class ScreenInputsComponent(
    componentContext: ComponentContext,
    private val onNavigateToScreenLogin: (String) -> Unit,
    private val onNavigateToScreenRegister: () -> Unit
): ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: ScreenStartEvent) {
        when(event) {
            ScreenStartEvent.ClickButton-> onNavigateToScreenLogin(text.value)
            is ScreenStartEvent.UpdateText -> {
                _text.value = event.text
            }

        }
    }
}