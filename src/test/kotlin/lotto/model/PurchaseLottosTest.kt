package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PurchaseLottosTest {

    @DisplayName("구매한 로또 전부 당첨 확인 테스트")
    @Test
    fun judgeAllTest() {
        // given
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 45)
        val first = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val second = Lotto(listOf(1, 2, 3, 4, 5, 45))
        val none = Lotto(listOf(10, 11, 12, 13, 14, 15))
        val purchaseLottos = PurchaseLottos(listOf(first, second, none))

        // when
        val totalResult = purchaseLottos.judgeAll(winningLotto)

        // then
        val lottoResultsByPrize = totalResult.lottoResultsByPrize
        assertThat(lottoResultsByPrize[LottoPrize.FIRST]).isEqualTo(1)
        assertThat(lottoResultsByPrize[LottoPrize.SECOND]).isEqualTo(1)
        assertThat(lottoResultsByPrize[LottoPrize.NONE]).isEqualTo(1)
    }
}
