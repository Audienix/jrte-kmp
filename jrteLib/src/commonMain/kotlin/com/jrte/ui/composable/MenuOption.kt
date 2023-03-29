package com.jrte.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jrte.model.MenuOptionsData
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MenuOption(
    data: MenuOptionsData,
    onClick: (Int) -> Unit
) {
    IconButton(
        onClick = {
            onClick(data.menuId)
        }
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(data.iconRes),
            contentDescription = null
        )
    }
}