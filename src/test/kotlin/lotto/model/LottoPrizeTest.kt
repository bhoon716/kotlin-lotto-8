package lotto.model

import lotto.dto.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoPrizeTest {

    companion object {
        @JvmStatic
        fun matchedCountAndBonusAndPrize(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, false, LottoPrize.FIRST),   // 6개 맞춤
                Arguments.of(5, true, LottoPrize.SECOND),   // 5개 + 보너스
                Arguments.of(5, false, LottoPrize.THIRD),   // 5개
                Arguments.of(4, true, LottoPrize.FOURTH),   // 4개 + 보너스
                Arguments.of(4, false, LottoPrize.FOURTH),  // 4개
                Arguments.of(3, true, LottoPrize.FIFTH),    // 3개 + 보너스
                Arguments.of(3, false, LottoPrize.FIFTH),   // 3개
                Arguments.of(2, true, LottoPrize.NONE),     // 2개 + 보너스
                Arguments.of(2, false, LottoPrize.NONE),    // 2개
                Arguments.of(1, true, LottoPrize.NONE),     // 1개 + 보너스
                Arguments.of(1, false, LottoPrize.NONE),    // 1개
                Arguments.of(0, true, LottoPrize.NONE),     // 0개 + 보너스
                Arguments.of(0, false, LottoPrize.NONE)     // 0개
            )
        }
    }

    @DisplayName("로또 당첨 순위 계산 테스트")
    @ParameterizedTest
    @MethodSource("matchedCountAndBonusAndPrize")
    fun prizeDetermineTest(matchedCount:Int, bonusMatch: Boolean, expected: LottoPrize) {
        // given
        val lottoResult = LottoResult(matchedCount, bonusMatch)

        // when
        val lottoPrize = LottoPrize.determine(lottoResult)

        // then
        assertThat(lottoPrize).isEqualTo(expected)
    }
}