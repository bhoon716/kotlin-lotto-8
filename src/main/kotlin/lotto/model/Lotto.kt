package lotto.model

import lotto.dto.LottoNumbers
import lotto.error.ErrorCode

class Lotto(private val numbers: List<Int>) {

    init {
        validateNumberCount(numbers)
        validateUniqueNumbers(numbers)
    }

    private fun validateNumberCount(numbers: List<Int>) {
        require(numbers.size == NUMBER_COUNT) { ErrorCode.INVALID_NUMBER_COUNT.message() }
    }

    private fun validateUniqueNumbers(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) { ErrorCode.DUPLICATED_LOTTO_NUMBER.message() }
    }

    fun countMatchedNumbers(other: Lotto): Int {
        return numbers.count(other::contains)
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun numbers(): LottoNumbers {
        return LottoNumbers(numbers.sorted().toList())
    }

    companion object {
        const val NUMBER_COUNT = 6
    }
}
