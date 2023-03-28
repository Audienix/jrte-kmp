package com.jrte.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jrte.ViewModel.JRTEViewModel
import com.jrte.model.MenuOptionsData
import com.jrte.model.SubMenuMapper
import com.jrte.ui.textstyle.*
import com.jrte.ui.theme.BackgroundToolbar
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.setBackgroundColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun JRTextToolbar(
    value: RichTextValue,
    onValueChange: (RichTextValue) -> Unit,
    viewModel: JRTEViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
//        Row(
//            modifier = Modifier
//                .background(BackgroundToolbar)
//                .clip(shape = RoundedCornerShape(4.dp))
//                .shadow(elevation = 1.dp)
//                .horizontalScroll(rememberScrollState()),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//        ) {
//            IconButton(onClick = {
//                onValueChange(value.insertStyle(BoldStyle))
//            }) {
//                Icon(
//                    modifier = Modifier.size(24.dp),
//                    painter = painterResource("icon_bold.xml"),
//                    contentDescription = null
//                )
//            }
//            IconButton(onClick = {
//                onValueChange(value.insertStyle(ItalicStyle))
//            }) {
//                Icon(
//                    modifier = Modifier.size(24.dp),
//                    painter = painterResource("icon_italic.xml"),
//                    contentDescription = null
//                )
//            }
//            IconButton(onClick = {
//                onValueChange(value.insertStyle(UnderlineStyle))
//            }) {
//                Icon(
//                    modifier = Modifier.size(24.dp),
//                    painter = painterResource("icon_underline.xml"),
//                    contentDescription = null
//                )
//            }
//            IconButton(onClick = {
//                onValueChange(value.insertStyle(LineThroughStyle))
//            }) {
//                Icon(
//                    modifier = Modifier.size(24.dp),
//                    painter = painterResource("icon_linethrough.xml"),
//                    contentDescription = null
//                )
//            }
//        }
        Balloon(builder = rememberBalloonBuilder {
            setBackgroundColor(Color.White)
            setWidth(BalloonSizeSpec.WRAP)
            setHeight(BalloonSizeSpec.WRAP)
        },
        balloonContent = { SubMenuMapper.map(viewModel.currentSelectedMenuOption) }
        ) { window ->
            MainMenu(
                menuOptions = viewModel.menuOptions,
                onMenuMidChanged = {
                    viewModel.currentSelectedMenuOption = it

                    if (SubMenuMapper.hasSubLayer(it)){
                        window.showAlignTop()
                    }
                }
            )
        }
    }
}
