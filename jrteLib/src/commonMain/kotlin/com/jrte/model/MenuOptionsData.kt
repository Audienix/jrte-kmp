package com.jrte.model

sealed class MenuOptionsData(
    val menuId: Int,
    val iconRes: String
) {
    object BackgroundPainter : MenuOptionsData(BKG_PAINTER_ID, "icon_bkg_color.xml")
    object TextColorPicker : MenuOptionsData(TEXT_COLOR_PICKER_ID, "icon_text_color.xml")
    object FontSizePicker : MenuOptionsData(FONT_SIZE_PICKER_ID, "icon_font_size.xml")
    object ParagraphFormatter : MenuOptionsData(PARAGRAPH_FORMATTER_ID, "icon_format_paragraph.xml")
    object BIUS : MenuOptionsData(BIUS_ID, "icon_bold.xml")
    object Undo : MenuOptionsData(UNDO_ID, "icon_undo.xml")
    object Redo : MenuOptionsData(REDO_ID, "icon_redo.xml")

    companion object {

        const val NOT_SELECTED_ID = -1
        const val BKG_PAINTER_ID = 0
        const val TEXT_COLOR_PICKER_ID = 1
        const val FONT_SIZE_PICKER_ID = 2
        const val PARAGRAPH_FORMATTER_ID = 3
        const val BIUS_ID = 4
        const val UNDO_ID = 5
        const val REDO_ID = 6

        fun getMenuOptions(
            ids: List<Int> = listOf(
                BKG_PAINTER_ID,
                TEXT_COLOR_PICKER_ID,
                FONT_SIZE_PICKER_ID,
                PARAGRAPH_FORMATTER_ID,
                BIUS_ID,
                UNDO_ID,
                REDO_ID
            )
        ) = listOf(
            BackgroundPainter, TextColorPicker, FontSizePicker, ParagraphFormatter, BIUS, Undo, Redo
        ).filter { menuOptions ->
            ids.contains(menuOptions.menuId)
        }
    }
}

