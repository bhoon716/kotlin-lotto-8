package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @DisplayName("로또에 특정 번호 포함되어있는지 확인 테스트")
    @Test
    fun lottoContainsNumberTest() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val number1 = 1
        val number2 = 7

        // when
        val result1 = lotto.contains(number1)
        val result2 = lotto.contains(number2)

        // then
        assertThat(result1).isTrue
        assertThat(result2).isFalse
    }
}