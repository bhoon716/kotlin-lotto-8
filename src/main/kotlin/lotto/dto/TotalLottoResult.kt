package lotto.dto

import lotto.model.Lotto
import lotto.model.LottoPrize
import java.math.BigDecimal
import java.math.RoundingMode

data class TotalLottoResult(val lottoResultsByPrize: MutableMap<LottoPrize, Int>) {

    fun returnRate(): BigDecimal {
        val totalReward = lottoResultsByPrize.entries
            .sumOf { (prize, count) -> prize.reward * count }

        val totalAmount = lottoResultsByPrize.values
            .sumOf { it * Lotto.PRICE }
            .toDouble()

        if (totalAmount == 0.0) {
            return BigDecimal.ZERO
        }

        val returnRatePercent = totalReward / totalAmount * 100

        return BigDecimal(returnRatePercent).setScale(1, RoundingMode.HALF_UP)
    }

    companion object {

        fun initialize(): MutableMap<LottoPrize, Int> {
            return LottoPrize.entries
                .reversed()
                .associateWith { 0 }
                .toMutableMap()
        }
    }
}
