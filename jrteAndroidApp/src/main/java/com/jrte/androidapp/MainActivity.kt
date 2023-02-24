package com.jrte.androidapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrte.androidapp.ui.theme.JRTETheme
import com.jrte.ui.composable.JRTEditor
import com.jrte.ui.textstyle.Style
import com.jrte.ui.composable.defaultRichTextFieldStyle
import com.jrte.ui.textstyle.RichTextValue
import com.jrte.ui.textstyle.StyleMapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            JRTETheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
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

                    Column(modifier = Modifier.fillMaxSize()) {
                        JRTEditor(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(16.dp),
                            value = value,
                            onValueChange = { value = it },
                            textFieldStyle = defaultRichTextFieldStyle().copy(
                                textColor = Color.DarkGray,
                                placeholderColor = Color.LightGray,
                                placeholder = "Write something here...",
                                textSize = 18.sp
                            ),
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
                                    painter = painterResource(id = R.drawable.icon_bold),
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = {
                                value = value.insertStyle(ItalicStyle)
                            }) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.drawable.icon_italic),
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = {
                                value = value.insertStyle(UnderlineStyle)
                            }) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.drawable.icon_underline),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JRTETheme {
            Greeting("Android")
        }
    }

    object BoldStyle : Style
    object ItalicStyle : Style
    object UnderlineStyle : Style

    class CustomStyleMapper : StyleMapper() {

        override fun fromTag(tag: String) =
            runCatching { super.fromTag(tag) }.getOrNull() ?: when (tag) {
                "${BoldStyle.javaClass.simpleName}/" -> BoldStyle
                "${ItalicStyle.javaClass.simpleName}/" -> ItalicStyle
                "${UnderlineStyle.javaClass.simpleName}/" -> UnderlineStyle
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
}