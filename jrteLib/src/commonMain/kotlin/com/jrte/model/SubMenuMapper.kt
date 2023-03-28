package com.jrte.model

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jrte.model.MenuOptionsData.Companion.BIUS_ID
import com.jrte.model.MenuOptionsData.Companion.PAINTER_ID

class SubMenuMapper {

    companion object {
        @Composable
        fun map(mid: Int){
            when(mid){
                PAINTER_ID -> {}
                BIUS_ID -> {
                    Bius_subMenu()
                }
            }
        }
        fun hasSubLayer(mid: Int)=
            when(mid){
                PAINTER_ID, BIUS_ID -> true
                else -> false
            }
    }
}

@Composable
fun Bius_subMenu(){
    Text("Hello")
}