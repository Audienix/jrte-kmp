package com.jrte.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.jrte.model.MenuOptionsData

class JRTEViewModel {

    var menuOptions: List<MenuOptionsData> = MenuOptionsData.getMenuOptions()

    var currentSelectedMenuOption by mutableStateOf(MenuOptionsData.NOT_SELECTED_ID)

}