package lotto.model

import lotto.error.ErrorCode
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @DisplayName("로또 번호의 개수가 6자리가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = [
        "1,2,3,4,5",        // 5 자리
        "1,2,3,4,5,6,7"     // 7 자리
    ])
    fun invalidLottoNumberCountTest(numbers: String) {
        // given
        val numbers = numbers.split(",")
            .map { it.toInt() }
            .toList()

        // when & then
        assertThatThrownBy { Lotto(numbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorCode.INVALID_NUMBER_COUNT.message())
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    fun duplicatedNumberLottoTest() {
        // given
        val numbers = listOf(1, 1, 2, 3, 4, 5)

        // when & then
        assertThatThrownBy { Lotto(numbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorCode.DUPLICATED_LOTTO_NUMBER.message())
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

    @DisplayName("로또끼리 비교해서 같은 번호가 몇 개인지 반환해주는 메서드 테스트")
    @ParameterizedTest
    @CsvSource(
        value = [
            "10,11,12,13,14,15:6",      // 6개 일치
            "11,12,13,14,15,16:5",      // 5개 일치
            "12,13,14,15,16,17:4",      // 4개 일치
            "13,14,15,16,17,18:3",      // 3개 일치
            "14,15,16,17,18,19:2",      // 2개 일치
            "15,16,17,18,19,20:1",      // 1개 일치
            "16,17,18,19,20,21:0"       // 0개 일치
        ], delimiter = ':'
    )
    fun countMatchedNumbersTest(numbers: String, expected: Int) {
        // given
        val lottoNumbers = numbers.split(",")
            .map(String::toInt)
            .toList()
        val lotto1 = Lotto(lottoNumbers)
        val lotto2 = Lotto(listOf(10, 11, 12, 13, 14, 15))

        // when
        val equalNumberCount: Int = lotto1.countMatchedNumbers(lotto2)

        // then
        Assertions.assertThat(equalNumberCount).isEqualTo(expected)
    }
}
