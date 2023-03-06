package com.jrte.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.jrte.ui.textstyle.StyleMapper
import com.jrte.ui.textstyle.combinedTransformations
import com.jrte.ui.textstyle.UnorderedListTransformation

private const val EMPTY_STRING = ""

@Composable
internal fun JRTextField(
    value: TextFieldValue,
    styledValue: AnnotatedString,
    styleMapper: StyleMapper,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    textFieldStyle: JRTextFieldStyle = defaultJRTextFieldStyle(),
) {
    Box(modifier = modifier) {
        if (value.text.isEmpty()) {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = textFieldStyle.placeholder,
                style = textFieldStyle.textStyle.copy(
                    color = textFieldStyle.placeholderColor
                ),
                fontSize = textFieldStyle.textSize
            )
        }
        CompositionLocalProvider(
            LocalTextToolbar provides EmptyContextMenuToolbar
        ) {
            BasicTextField(
                modifier = Modifier.fillMaxSize(),
                value = value,
                onValueChange = onValueChange,
                visualTransformation = combinedTransformations(
                    styledValue = styledValue,
                    VisualTransformation.None,
                    UnorderedListTransformation(styleMapper)
                ),
                textStyle = textFieldStyle.textStyle.copy(
                    color = textFieldStyle.textColor,
                    fontSize = textFieldStyle.textSize,
                ),
                cursorBrush = SolidColor(textFieldStyle.cursorColor),
            )
        }
    }
}

@Composable
fun defaultJRTextFieldStyle() = JRTextFieldStyle(
    placeholder = EMPTY_STRING,
    textStyle = MaterialTheme.typography.bodySmall,
    textColor = MaterialTheme.colorScheme.onSurface,
    placeholderColor = MaterialTheme.colorScheme.secondary,
    cursorColor = MaterialTheme.colorScheme.secondary,
    textSize = 18.sp
)

data class JRTextFieldStyle(
    val placeholder: String,
    val textStyle: TextStyle,
    val textColor: Color,
    val placeholderColor: Color,
    val cursorColor: Color,
    val textSize: TextUnit,
)
