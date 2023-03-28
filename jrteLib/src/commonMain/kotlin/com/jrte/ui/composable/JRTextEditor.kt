package com.jrte.ui.composable

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.jrte.ui.textstyle.RichTextValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JRTextEditor(
    value: RichTextValue,
    onValueChange: (RichTextValue) -> Unit,
    modifier: Modifier = Modifier,
    textFieldStyle: JRTextFieldStyle = defaultJRTextFieldStyle()
) {
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
                onValueChange(newValue)
            }
        },
        textFieldStyle = textFieldStyle,
    )
}