package com.jrte.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.jrte.ui.textstyle.RichTextValue
import com.jrte.ui.textstyle.Style
import com.jrte.ui.textstyle.StyleMapper
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun JRTToolbar() {
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
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                value = value.insertStyle(BoldStyle)
            }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource("icon_bold.xml"),
                    contentDescription = null
                )
            }
            IconButton(onClick = {
                value = value.insertStyle(ItalicStyle)
            }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource("icon_italic.xml"),
                    contentDescription = null
                )
            }
            IconButton(onClick = {
                value = value.insertStyle(UnderlineStyle)
            }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource("icon_underline.xml"),
                    contentDescription = null
                )
            }
        }
    }
}
object BoldStyle : Style
object ItalicStyle : Style
object UnderlineStyle : Style

class CustomStyleMapper : StyleMapper() {

    override fun fromTag(tag: String) =
        runCatching { super.fromTag(tag) }.getOrNull() ?: when (tag) {
            "${BoldStyle::class.simpleName}/" -> BoldStyle
            "${ItalicStyle::class.simpleName}/" -> ItalicStyle
            "${UnderlineStyle::class.simpleName}/" -> UnderlineStyle
            else -> throw IllegalArgumentException()
        }

    @ExperimentalUnitApi
    override fun toSpanStyle(style: Style) = super.toSpanStyle(style) ?: when (style) {
        is BoldStyle -> SpanStyle(
            fontWeight = FontWeight.Bold,
        )
        is ItalicStyle -> SpanStyle(
            fontStyle = FontStyle.Italic,
        )
        is UnderlineStyle -> SpanStyle(
            textDecoration = TextDecoration.Underline,
        )
        else -> null
    }
}