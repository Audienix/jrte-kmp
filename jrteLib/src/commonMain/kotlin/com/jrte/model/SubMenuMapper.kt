package com.jrte.model

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.jrte.model.MenuOptionsData.Companion.BIUS_ID
import com.jrte.model.MenuOptionsData.Companion.BKG_PAINTER_ID

class SubMenuMapper {

    companion object {
        @Composable
        fun map(menuId: Int){
            when(menuId){
                BKG_PAINTER_ID -> {}
                BIUS_ID -> {
                    BIUS_SubMenu()
                }
            }
        }
        fun hasSubLayer(menuId: Int)=
            when(menuId){
                BKG_PAINTER_ID, BIUS_ID -> true
                else -> false
            }
    }
}

@Composable
fun BIUS_SubMenu(){
    Text("Hello")
}