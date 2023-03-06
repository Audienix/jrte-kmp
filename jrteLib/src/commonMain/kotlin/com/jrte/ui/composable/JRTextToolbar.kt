package com.jrte.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.jrte.ui.textstyle.*
import com.jrte.ui.theme.BackgroundToolbar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun JRTextToolbar() {
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
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .background(BackgroundToolbar)
                .clip(shape = RoundedCornerShape(4.dp))
                .shadow(elevation = 1.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
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
            IconButton(onClick = {
                value = value.insertStyle(LineThroughStyle)
            }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource("icon_linethrough.xml"),
                    contentDescription = null
                )
            }
        }
    }
}
