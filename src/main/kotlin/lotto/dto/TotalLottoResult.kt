package lotto.dto

import lotto.model.LottoPrize
import java.math.BigDecimal
import java.math.RoundingMode

data class TotalLottoResult(val lottoResultsByPrize: Map<LottoPrize, Int>) {

    fun returnRate(): Double {
        val totalReward = lottoResultsByPrize.entries
            .sumOf { (prize, count) -> prize.reward * count }

        val totalAmount = lottoResultsByPrize.values
            .sumOf { it * 1_000.0 }

        if (totalAmount == 0.0) {
            return 0.0
        }

        val returnRatePercent = totalReward / totalAmount * 100

        return BigDecimal(returnRatePercent).setScale(1, RoundingMode.HALF_UP).toDouble()
    }
}
