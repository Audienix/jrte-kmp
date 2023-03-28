package com.jrte.androidapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jrte.androidapp.ui.theme.JRTETheme
import com.jrte.ui.composable.JRTextScreen
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO pass window as parameter to the library
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            JRTETheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    JRTextScreen()
                }
            }
//            Balloon(builder = rememberBalloonBuilder(block = {}), balloonContent = ) {
//
//            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JRTETheme {
            JRTextScreen()
        }
    }
}