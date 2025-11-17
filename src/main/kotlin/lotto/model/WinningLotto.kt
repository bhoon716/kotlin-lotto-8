package lotto.model

import lotto.dto.LottoResult
import lotto.error.ErrorCode

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: Int) {

    init {
        validate(bonusNumber);
        validate(winningLotto, bonusNumber)
    }

    private fun validate(bonusNumber: Int) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER.message())
        }
    }

    private fun validate(winningLotto: Lotto, bonusNumber: Int) {
        if (winningLotto.contains(bonusNumber)) {
            throw IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.message())
        }
    }

    fun judge(lotto: Lotto): LottoResult {
        val countMatchedNumbers = lotto.countMatchedNumbers(winningLotto)
        val isMatchedBonus = lotto.contains(bonusNumber)
        return LottoResult(countMatchedNumbers, isMatchedBonus)
    }
}
