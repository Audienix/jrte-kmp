package com.jrte.model

sealed class MenuOptionsData(
    val mid: Int,
    val iconRes: String
){
    object Painter: MenuOptionsData(PAINTER_ID, "icon_painter.xml")
    object ColorPicker: MenuOptionsData(COLOR_PICKER_ID, "icon_painter.xml" )
    object TextLevel: MenuOptionsData(TEXT_LEVEL_ID,"icon_linethrough.xml" ) //TODO give appropriate name
    object ParagraphFormatter: MenuOptionsData(PARAGRAPH_FORMATTER_ID, "icon_linethrough.xml")
    object BIUS: MenuOptionsData(BIUS_ID,"icon_bold.xml")
    object Undo: MenuOptionsData(UNDO_ID, "icon_linethrough.xml")
    object Redo: MenuOptionsData(REDO_ID, "icon_linethrough.xml")

    companion object {

        const val NOT_SELECTED_ID = -1
        const val PAINTER_ID = 0
        const val COLOR_PICKER_ID = 1
        const val TEXT_LEVEL_ID = 2
        const val PARAGRAPH_FORMATTER_ID = 3
        const val BIUS_ID = 4
        const val UNDO_ID = 5
        const val REDO_ID = 6

        fun getMenuOptions(ids: List<Int> = listOf(
            PAINTER_ID, COLOR_PICKER_ID, TEXT_LEVEL_ID, PAINTER_ID, BIUS_ID, UNDO_ID, REDO_ID)) = listOf(
            Painter, ColorPicker, TextLevel, ParagraphFormatter, BIUS, Undo, Redo
        ).filter {
            ids.contains(it.mid) }
    }
}

