package lotto.util

import lotto.error.ErrorCode

object IntParser {

    fun parse(input: String): Int {
        try {
            return input.toInt()
        } catch (_: NumberFormatException) {
            throw NumberFormatException(ErrorCode.INT_FORMAT_ERROR.message())
        }
    }
}
