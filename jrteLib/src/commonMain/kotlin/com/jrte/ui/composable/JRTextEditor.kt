package com.jrte.ui.composable

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.jrte.ui.textstyle.CustomStyleMapper
import com.jrte.ui.textstyle.RichTextValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JRTextEditor(
    modifier: Modifier = Modifier,
    textFieldStyle: JRTextFieldStyle = defaultJRTextFieldStyle()
) {
    var value by remember {
        mutableStateOf(
            RichTextValue.fromString(
                // Optional parameter; leave it blank if you want to use provided styles
                // But if you want to customize the user experience you're free to do that
                // by providing a custom StyleMapper
                styleMapper = CustomStyleMapper()
            )
        )
    }
    TopAppBar(
        title = {
            Text(text = "Rich Text Editor")
        }
    )
    JRTextField(
        modifier = modifier,
        value = value.value,
        styledValue = value.styledValue,
        styleMapper = value.styleMapper,
        onValueChange = {
            val newValue = value.copy()
            if (newValue.updatedValueAndStyles(it)) {
                value = newValue
            }
        },
        textFieldStyle = textFieldStyle,
    )
}