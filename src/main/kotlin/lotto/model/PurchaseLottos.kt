package lotto.model

import lotto.dto.LottoNumbers
import lotto.dto.TotalLottoResult

class PurchaseLottos(private val lottos: List<Lotto>) {

    fun judgeAll(winningLotto: WinningLotto): TotalLottoResult {
        val result = TotalLottoResult.initialize()
        lottos
            .map { winningLotto.judge(it) }
            .map { LottoPrize.determine(it) }
            .forEach {
                val count = result.getOrDefault(it, 0)
                result.put(it, count + 1)
            }
        return TotalLottoResult(result)
    }

    fun infos(): List<LottoNumbers> {
        return lottos
            .map { it.numbers() }
            .toList()
    }
}
