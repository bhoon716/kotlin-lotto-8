package lotto.model

import lotto.dto.TotalLottoResult

class PurchaseLottos(private val lottos: List<Lotto>) {

    fun judgeAll(winningLotto: WinningLotto): TotalLottoResult {
        return TotalLottoResult(
            lottos
                .map { winningLotto.judge(it) }
                .map { LottoPrize.determine(it) }
                .groupingBy { it }
                .eachCount()
        )
    }
}
