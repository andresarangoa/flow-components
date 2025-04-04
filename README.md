# Flow Components Library Documentation

## Introduction

The Flow Components Library is a modern UI component library for Jetpack Compose in Android development. It provides a set of ready-to-use, customizable UI components designed to create consistent and beautiful user interfaces with minimal effort.

## Installation

To incorporate the Flow Components Library into your Android project, follow these steps:

### 1. Add the repository to your project's build.gradle

Add the library to your version catalog in the `gradle/libs.versions.toml` file:

```toml
[versions]
flowComponents = "0.1.0-beta01"

[libraries]
flow-components = { module = "io.github.andresarangoa:flow-components", version.ref = "flowComponents" }
```

### 2. Add the dependency to your module's build.gradle

```kotlin
dependencies {
    implementation(libs.flow.components)
}
```

## Components Overview

The Flow Components Library includes the following key components:

### Text Fields

#### OutlinedTextField

A styled text input with customizable border and states.

```kotlin
OutlinedTextField(
    hint = "Enter value",
    label = "Amount",
    state = DefaultInputStateImp(
        text = value,
        showError = !isValidValue,
        onTextChanged = { value = it },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        iconVisibility = IconVisibility.FOCUSED_OR_NOT_EMPTY,
        icon = CustomIconRes.cancel,
        onIconClick = { value = "" }
    ),
    theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow)
)
```

#### BasicTextField

A simpler text input component that serves as the base for other text fields.

```kotlin
BasicTextField(
    hint = "Enter text",
    label = "Name",
    state = rememberDefaultInputState(),
    theme = defaultTheme()
)
```

### Dropdowns

#### OutlinedDropdownField

A dropdown selector with customizable options and styling.

```kotlin
val options = listOf("Option 1", "Option 2", "Option 3")
val dropdownState = remember {
    DropDownStateObjImp(
        displayProperty = { option -> option },
        dropdownOptionList = options,
        onSelectedOption = { selectedOption = it }
    )
}

OutlinedDropdownField(
    label = "Select an option",
    hint = "Please select an option",
    inputState = DefaultInputStateImp(text = selectedOption),
    state = dropdownState,
    theme = defaultDropdownTheme(customColors = LocalCustomColorsPaletteFlow)
)
```

#### BasicDropdownField

A basic dropdown implementation that can be used as a foundation for custom dropdowns.

```kotlin
BasicDropdownField(
    hint = "Select item",
    label = "Item",
    inputState = rememberDefaultInputState(),
    state = dropdownState,
    theme = defaultDropdownTheme()
)
```

### Buttons

#### RoundedCornerFilledButton

A filled button with rounded corners.

```kotlin
RoundedCornerFilledButton(
    text = "Submit",
    customColors = LocalCustomColorsPaletteFlow
) {
    // Click action
}
```

#### RoundedCornerOutlinedButton

An outlined button with rounded corners.

```kotlin
RoundedCornerOutlinedButton(
    text = "Cancel",
    customColors = LocalCustomColorsPaletteFlow
) {
    // Click action
}
```

#### GradientButton

A button with a gradient background.

```kotlin
GradientButton(
    text = "Continue"
) {
    // Click action
}
```

#### AddAnotherItemButton

A specialized button for adding items to a list, featuring a dashed border.

```kotlin
AddAnotherItemButton(
    text = "Add Another Item",
    style = AddAnotherItemButtonStyle.defaultTheme(LocalCustomColorsPaletteFlow)
) {
    // Add item action
}
```

## Theming

The library provides comprehensive theming capabilities:

### FlowUITheme

Wrap your UI components with the FlowUITheme to apply consistent styling:

```kotlin
FlowUITheme {
    // Your UI components
}
```

### Custom Colors

Use LocalCustomColorsPaletteFlow to access the theme colors within your components:

```kotlin
Column(
    modifier = Modifier
        .background(LocalCustomColorsPaletteFlow.current.surfaceSecondary)
        .fillMaxSize()
        .padding(ConstantsValuesDp.value_dp_16)
) {
    // Components
}
```

### Component-Specific Themes

Each component type has its own theming options:

```kotlin
// For input fields
val inputTheme = defaultTheme(customColors = LocalCustomColorsPaletteFlow)

// For dropdowns
val dropdownTheme = defaultDropdownTheme(customColors = LocalCustomColorsPaletteFlow)

// For buttons
val buttonStyle = AddAnotherItemButtonStyle.defaultTheme(LocalCustomColorsPaletteFlow)
```

## Input State Management

The library uses state objects to manage component behavior:

### DefaultInputState

Controls the behavior and appearance of text fields:

```kotlin
val inputState = DefaultInputStateImp(
    text = currentValue,
    showError = hasError,
    showSuccess = isValid,
    onTextChanged = { newValue ->
        // Update your value
    },
    keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done
    ),
    iconVisibility = IconVisibility.ALWAYS,
    icon = CustomIconRes.search,
    onIconClick = {
        // Handle icon click
    },
    readOnly = false,
    enable = true
)
```

### DropDownStateObjImp

Manages dropdown behavior and options:

```kotlin
val dropdownState = DropDownStateObjImp(
    displayProperty = { option -> option.name },  // Function to display each option
    dropdownOptionList = availableOptions,        // List of options
    onSelectedOption = { selected ->              // Selection handler
        // Handle selection
    },
    selectedOption = currentSelection,            // Current selection
    showAddNew = true,                            // Show "Add New" option
    addNewText = "Add Custom Option",             // Text for "Add New"
    onAddNew = {                                  // Handler for "Add New"
        // Show dialog or navigate to create new option
    }
)
```

## Example Screens

Here are examples of how to implement screens with the Flow Components Library:

### Input Fields Screen

```kotlin
@Composable
fun ScreenInputs(component: ScreenInputsComponent) {
    var value by remember { mutableStateOf("") }
    val isValidValue by remember { mutableStateOf(true) }
    val options = remember {
        listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    }
    var selectedOption by remember { mutableStateOf("") }

    val dropdownState = remember {
        DropDownStateObjImp(
            displayProperty = { option -> option },
            dropdownOptionList = options,
            onSelectedOption = { option ->
                selectedOption = option
            }
        )
    }

    FlowUITheme {
        Column(
            modifier = Modifier.background(LocalCustomColorsPaletteFlow.current.surfaceSecondary)
                .fillMaxSize()
                .padding(top = ConstantsValuesDp.value_dp_16)
        ) {
            OutlinedTextField(
                state = DefaultInputStateImp(
                    text = value,
                    showError = !isValidValue,
                    onTextChanged = {
                        value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    iconVisibility = IconVisibility.FOCUSED_OR_NOT_EMPTY,
                    icon = CustomIconRes.cancel,
                    onIconClick = { value = "" }
                ),
                theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow),
                hint = "test",
                label = "test"
            )

            OutlinedTextField(
                state = DefaultInputStateImp(
                    text = value,
                    showError = isValidValue,
                    onTextChanged = {
                        value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    iconVisibility = IconVisibility.FOCUSED_OR_NOT_EMPTY,
                    icon = CustomIconRes.cancel,
                    onIconClick = { value = "" }
                ),
                theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow),
                hint = "test",
                label = "test"
            )

            OutlinedTextField(
                state = DefaultInputStateImp(
                    text = value,
                    showSuccess = isValidValue,
                    onTextChanged = {
                        value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    iconVisibility = IconVisibility.FOCUSED_OR_NOT_EMPTY,
                    icon = CustomIconRes.cancel,
                    onIconClick = { value = "" }
                ),
                theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow),
                hint = "test",
                label = "test"
            )

            OutlinedDropdownField(
                label = "Select an option",
                hint = "Please select an option",
                inputState = DefaultInputStateImp(
                    text = selectedOption
                ),
                state = dropdownState,
                theme = defaultDropdownTheme(customColors = LocalCustomColorsPaletteFlow)
            )
        }
    }
}
```

### Buttons Screen

```kotlin
@Composable
fun ScreenButtons(component: ScreenButtonComponent) {
    FlowUITheme {
        Column(
            modifier = Modifier.background(LocalCustomColorsPaletteFlow.current.surfaceSecondary)
                .fillMaxSize()
                .padding(ConstantsValuesDp.value_dp_16)
        ) {
            AddAnotherItemButton(
                style = AddAnotherItemButtonStyle.defaultTheme(LocalCustomColorsPaletteFlow)
            ) {}
            Spacer(modifier = Modifier.height(ConstantsValuesDp.value_dp_16))
            RoundedCornerFilledButton(
                text = "Test",
                customColors = LocalCustomColorsPaletteFlow,
            ){
                // Click action
            }
            Spacer(modifier = Modifier.height(ConstantsValuesDp.value_dp_16))
            RoundedCornerOutlinedButton(
                text = "Test",
                customColors = LocalCustomColorsPaletteFlow,
            ){
                // Click action
            }
            Spacer(modifier = Modifier.height(ConstantsValuesDp.value_dp_16))
            GradientButton(
                text = "Test",
            ){
                // Click action
            }
        }
    }
}
```

## Complete Example: User Profile Form

Here's a complete example of a form with multiple components:

```kotlin
@Composable
fun UserProfileForm() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    val countries = listOf("United States", "Canada", "Mexico", "Other")

    val countryDropdownState = remember {
        DropDownStateObjImp(
            displayProperty = { it },
            dropdownOptionList = countries,
            onSelectedOption = { country = it }
        )
    }

    FlowUITheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(LocalCustomColorsPaletteFlow.current.surfaceSecondary)
        ) {
            OutlinedTextField(
                hint = "Enter your name",
                label = "Full Name",
                state = DefaultInputStateImp(
                    text = name,
                    onTextChanged = { name = it }
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                hint = "Enter your email",
                label = "Email Address",
                state = DefaultInputStateImp(
                    text = email,
                    onTextChanged = { email = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedDropdownField(
                hint = "Select your country",
                label = "Country",
                state = countryDropdownState
            )

            Spacer(modifier = Modifier.height(24.dp))

            RoundedCornerFilledButton(
                text = "Save Profile",
                customColors = LocalCustomColorsPaletteFlow
            ) {
                // Save profile data
            }
        }
    }
}
```

## Advanced Customization

### Custom Input Field Styling

The library components offer extensive customization through modifiers and themes:

```kotlin
OutlinedTextField(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
    hint = "Custom Field",
    state = inputState,
    theme = DefaultInputTheme(
        textStyle = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            color = Color.DarkGray
        ),
        tint = Color.Blue,
        modifier = Modifier.fillMaxWidth(),
        hintTextStyle = TextStyle(
            color = Color.Gray,
            fontSize = 12.sp
        )
    )
)
```

### Custom Button Styling

Customize button appearance with style objects:

```kotlin
val customButtonStyle = AddAnotherItemButtonStyle(
    borderColor = Color.Blue,
    contentColor = Color.Blue,
    backgroundColor = Color.White,
    borderWidth = 1.dp,
    dashWidth = 8.dp,
    dashGap = 4.dp,
    shape = RoundedCornerShape(8.dp),
    height = 48.dp,
    padding = PaddingValues(vertical = 8.dp),
    defaultElevation = 0.dp,
    pressedElevation = 2.dp,
    iconSize = 18.dp,
    spacerWidth = 8.dp
)

AddAnotherItemButton(
    text = "Custom Styled Button",
    style = customButtonStyle
) {
    // Click action
}
```

## Constants and Utility Values

The library provides predefined constants for consistent spacing and styling:

```kotlin
// Commonly used dimension values
ConstantsValuesDp.value_dp_5   // 5.dp
ConstantsValuesDp.value_dp_8   // 8.dp
ConstantsValuesDp.value_dp_16  // 16.dp

// Use these in your layouts for consistency
Spacer(modifier = Modifier.height(ConstantsValuesDp.value_dp_16))
```

## Integration with Existing Projects

The Flow Components Library is designed to work alongside your existing Jetpack Compose UI components. You can mix and match standard Compose components with Flow components:

```kotlin
Column(
    modifier = Modifier.padding(16.dp)
) {
    // Standard Compose component
    Text(
        text = "Standard Text Component",
        style = MaterialTheme.typography.h6
    )
    
    Spacer(modifier = Modifier.height(16.dp))
    
    // Flow component
    OutlinedTextField(
        hint = "Flow Component",
        label = "Input Field",
        state = rememberDefaultInputState()
    )
    
    // More mixed components...
}
```

---

