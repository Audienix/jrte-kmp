package com.jrte.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrte.ViewModel.JRTEViewModel
import com.jrte.ui.textstyle.CustomStyleMapper
import com.jrte.ui.textstyle.RichTextValue

@Composable
fun JRTextScreen(
    modifier: Modifier = Modifier
){
    val viewModel = remember { JRTEViewModel() }
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
    val onValueChange: (RichTextValue) -> Unit = { value = it }
    Column(modifier = modifier.fillMaxSize()) {
        JRTextEditor(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            textFieldStyle = defaultJRTextFieldStyle().copy(
                textColor = Color.Black,
                placeholderColor = Color.LightGray,
                placeholder = "Write something here...",
                textSize = 18.sp
            ),
        )
    }
    JRTextToolbar(
        value = value,
        onValueChange = onValueChange,
        viewModel = viewModel
    )
}