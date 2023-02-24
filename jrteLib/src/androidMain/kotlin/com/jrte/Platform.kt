package com.jrte

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun systemLineSeparator(): String = System.lineSeparator()
actual val defaultDispatcher: CoroutineContext = Dispatchers.Default
actual val uiDispatcher: CoroutineContext = Dispatchers.Main