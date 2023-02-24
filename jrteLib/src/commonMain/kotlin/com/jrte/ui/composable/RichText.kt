package com.jrte.ui.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.jrte.ui.textstyle.RichTextValue
import com.jrte.ui.textstyle.combinedTransformations
import com.jrte.ui.textstyle.UnorderedListTransformation

@Composable
fun RichText(
    value: RichTextValue,
    modifier: Modifier = Modifier,
    textStyle: RichTextStyle = defaultRichTextStyle(),
) {
    Text(
        modifier = modifier,
        text = combinedTransformations(
            styledValue = value.styledValue,
            VisualTransformation.None,
            UnorderedListTransformation(value.styleMapper)
        ).filter(value.styledValue).text,
        style = textStyle.textStyle.copy(
            color = textStyle.textColor,
        )
    )
}

@Composable
fun defaultRichTextStyle() = RichTextStyle(
    textStyle = MaterialTheme.typography.bodySmall,
    textColor = MaterialTheme.colorScheme.onSurface,
)

data class RichTextStyle(
    val textStyle: TextStyle,
    val textColor: Color,
)
