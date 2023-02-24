package com.jrte

import platform.UIKit.UIDevice
import kotlin.coroutines.CoroutineContext

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect fun systemLineSeparator(): String
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect val defaultDispatcher: CoroutineContext
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect val uiDispatcher: CoroutineContext