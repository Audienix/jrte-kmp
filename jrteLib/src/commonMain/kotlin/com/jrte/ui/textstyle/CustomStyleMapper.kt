package com.jrte.ui.textstyle

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.ExperimentalUnitApi

object BoldStyle : Style
object ItalicStyle : Style
object UnderlineStyle : Style
object LineThroughStyle : Style

class CustomStyleMapper : StyleMapper() {

    override fun fromTag(tag: String) =
        runCatching { super.fromTag(tag) }.getOrNull() ?: when (tag) {
            "${BoldStyle::class.simpleName}/" -> BoldStyle
            "${ItalicStyle::class.simpleName}/" -> ItalicStyle
            "${UnderlineStyle::class.simpleName}/" -> UnderlineStyle
            "${LineThroughStyle::class.simpleName}/" -> LineThroughStyle
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
        is LineThroughStyle -> SpanStyle(
            textDecoration = TextDecoration.LineThrough
        )
        else -> null
    }
}