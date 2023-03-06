package com.jrte.androidapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jrte.androidapp.ui.theme.JRTETheme
import com.jrte.ui.composable.JRTextEditor
import com.jrte.ui.composable.JRTextToolbar
import com.jrte.ui.composable.defaultJRTextFieldStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO pass window as parameter to the library
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            JRTETheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        JRTextEditor(
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
                    JRTextToolbar()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JRTETheme {
            JRTextEditor()
            JRTextToolbar()
        }
    }
}