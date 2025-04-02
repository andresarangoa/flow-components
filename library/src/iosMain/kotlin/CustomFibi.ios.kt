package io.github.kotlin.fibonacci

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual fun getCurrentMillis(): Long {
    return (NSDate().timeIntervalSince1970 * 1000).toLong()
}