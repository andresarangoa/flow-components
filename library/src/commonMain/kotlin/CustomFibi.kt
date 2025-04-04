package io.github.kotlin.fibonacci

import androidx.compose.runtime.Composable
import components.AppColorScheme

fun generateFibi() = sequence {
    var a = firstElement
    yield(a)
    var b = secondElement
    yield(b)
    while (true) {
        val c = a + b
        yield(c)
        a = b
        b = c
    }
}

expect fun getCurrentMillis(): Long

interface DecimalFormatterI {
    fun cleanup(input: String): String
    fun formatForVisual(input: String): String
}

expect fun getDecimalFormatter(): DecimalFormatterI

expect val firstElement: Int
expect val secondElement: Int
