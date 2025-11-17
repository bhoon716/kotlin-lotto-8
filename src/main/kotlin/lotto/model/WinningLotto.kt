package lotto.model

import lotto.dto.LottoResult

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: Int) {

    fun judge(lotto: Lotto): LottoResult {
        val countMatchedNumbers = lotto.countMatchedNumbers(winningLotto)
        val isMatchedBonus = lotto.contains(bonusNumber)
        return LottoResult(countMatchedNumbers, isMatchedBonus)
    }
}
