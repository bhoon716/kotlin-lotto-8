package lotto.dto

import lotto.model.LottoPrize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TotalLottoResultTest {

    @DisplayName("당첨 수익률 계산 테스트")
    @Test
    fun calculateReturnRateTest() {
        // given
        val results = mutableMapOf<LottoPrize, Int>()
        results.put(LottoPrize.FIRST, 0)
        results.put(LottoPrize.SECOND, 0)
        results.put(LottoPrize.THIRD, 0)
        results.put(LottoPrize.FOURTH, 0)
        results.put(LottoPrize.FIFTH, 1)
        results.put(LottoPrize.NONE, 6)
        val totalLottoResult = TotalLottoResult(results) // 8개 구매: 1개 5등, 나머지 미당첨

        // when
        val returnRate = totalLottoResult.returnRate()

        // then
        assertThat(returnRate).isEqualTo(71.4)
    }
}
