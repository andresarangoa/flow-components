package io.github.kotlin.fibonacci

import androidx.compose.runtime.Composable
import components.AppColorScheme
import io.github.kotlin.fibonacci.data.model.Constants.LIMIT_SYMBOL_CURRENCY
import platform.Foundation.NSDate
import platform.Foundation.NSUserDefaults
import platform.Foundation.timeIntervalSince1970

actual fun getCurrentMillis(): Long {
    return (NSDate().timeIntervalSince1970 * 1000).toLong()
}

actual fun getDecimalFormatter(): DecimalFormatterI {
    return object : DecimalFormatterI {
        // Using US locale settings for consistency with Android implementation
        private val thousandsSeparator = ','
        private val decimalSeparator = '.'

        override fun cleanup(input: String): String {
            // Replace any commas with an empty string to prevent issues
            val sanitizedInput = input.replace(",", "")
            // Filter out invalid characters (keep only digits and one decimal separator)
            val filteredInput = sanitizedInput.filter { it.isDigit() || it == decimalSeparator }
            val parts = filteredInput.split(decimalSeparator)
            // Ensure only one decimal separator and limit the decimal part to 2 digits
            val integerPart = parts[0].trimStart('0').ifEmpty { "0" }
            val decimalPart = if (parts.size > 1) parts[1].take(2) else ""
            // Reconstruct the cleaned input
            return if (decimalPart.isEmpty()) {
                integerPart
            } else {
                "$integerPart$decimalSeparator$decimalPart"
            }
        }

        override fun formatForVisual(input: String): String {
            // Remove the currency symbol before processing
            val currencySymbol = LIMIT_SYMBOL_CURRENCY
            val inputWithoutSymbol = input.removePrefix(currencySymbol.toString())
            val parts = inputWithoutSymbol.split(decimalSeparator)
            val intPart = parts[0]
            val fractionPart = parts.getOrNull(1)
            // Ensure there are no leading commas
            val trimmedIntPart = intPart.trimStart('0').ifEmpty { "0" }
            // Only add commas if the integer part has more than 3 digits
            val formattedIntPart = if (trimmedIntPart.length > 3) {
                trimmedIntPart.reversed().chunked(3).joinToString(separator = thousandsSeparator.toString()).reversed()
            } else {
                trimmedIntPart
            }
            // Re-attach the currency symbol after formatting
            val result = if (fractionPart == null) {
                formattedIntPart
            } else {
                "$formattedIntPart$decimalSeparator$fractionPart"
            }
            return currencySymbol + result
        }
    }
}
