package com.jrte

import kotlin.coroutines.CoroutineContext

interface Platform {
    val name: String
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect fun systemLineSeparator(): String
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect val defaultDispatcher: CoroutineContext
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect val uiDispatcher: CoroutineContext