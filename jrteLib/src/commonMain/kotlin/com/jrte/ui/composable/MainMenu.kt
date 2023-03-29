package com.jrte.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jrte.model.MenuOptionsData
import com.jrte.ui.theme.BackgroundToolbar

@Composable
fun MainMenu(
    menuOptions: List<MenuOptionsData>,
    onMenuSelectionChanged: (Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(align = Alignment.CenterHorizontally),
        shape = shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundToolbar)
    ) {
        Row {
            menuOptions.forEach {
                MenuOption(it, onMenuSelectionChanged)
            }
        }
    }
}