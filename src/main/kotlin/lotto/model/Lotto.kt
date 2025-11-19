package lotto.model

import lotto.dto.LottoNumbers
import lotto.error.ErrorCode

class Lotto(private val numbers: List<Int>) {

    init {
        validateNumberCount(numbers)
        validateUniqueNumbers(numbers)
        validateNumberInRange(numbers)
    }

    private fun validateNumberCount(numbers: List<Int>) {
        require(numbers.size == NUMBER_COUNT) { ErrorCode.INVALID_NUMBER_COUNT.message() }
    }

    private fun validateUniqueNumbers(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) { ErrorCode.DUPLICATED_LOTTO_NUMBER.message() }
    }

    private fun validateNumberInRange(numbers: List<Int>) {
        require(
            numbers.stream()
                .allMatch { MINIMUM_NUMBER <= it && it <= MAXIMUM_NUMBER }) { ErrorCode.OUT_OF_RANGE_NUMBER.message() }
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

    companion object RULE {
        const val PRICE = 1_000
        const val MAXIMUM_PRICE = 100_000
        const val NUMBER_COUNT = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
    }
}
