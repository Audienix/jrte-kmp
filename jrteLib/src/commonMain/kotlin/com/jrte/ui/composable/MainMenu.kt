package com.jrte.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jrte.model.MenuOptionsData

@Composable
fun MainMenu(
    menuOptions: List<MenuOptionsData>,
    onMenuMidChanged: (Int) -> Unit,
){
    Card(
        modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
        elevation = 10.dp
        ) {
        Row {
            menuOptions.forEach {
                MenuOption(it, onMenuMidChanged)
            }
        }
    }
}