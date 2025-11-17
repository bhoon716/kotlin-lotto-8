package lotto.model

import lotto.error.ErrorCode
import lotto.model.strategy.LottoIssueStrategy
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    @DisplayName("로또 구매 성공 테스트")
    @Test
    fun lottoPurchaseTest() {
        // given
        val money = 10000
        val fixedIssueStrategy = LottoIssueStrategy { listOf(1, 2, 3, 4, 5, 6) }
        val lottoMachine = LottoMachine(fixedIssueStrategy)

        // when & then
        assertThatCode { lottoMachine.purchase(money) }.doesNotThrowAnyException()
    }

    @DisplayName("로또 구매 실패 - 잘못된 구입 금액")
    @ParameterizedTest
    @ValueSource(
        ints = [
            -1,         // 음수
            0,          // 0원
            110_000,    // 10만원 초과
            1500        // 잔돈 발생
        ]
    )
    fun invalidPurchaseAmountTest(money: Int) {
        // given
        val fixedIssueStrategy = LottoIssueStrategy { listOf(1, 2, 3, 4, 5, 6) }
        val lottoMachine = LottoMachine(fixedIssueStrategy)

        // when & then
        assertThatThrownBy { lottoMachine.purchase(money) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorCode.INVALID_PURCHASE_AMOUNT.message())
    }
}