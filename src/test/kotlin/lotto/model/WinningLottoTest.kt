package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTest {

    @DisplayName("우승 로또 비교 테스트")
    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6:6:false",      // 6개, 보너스 x
            "1,2,3,4,5,45:5:true",      // 5개, 보너스 O
            "1,2,3,4,5,7:5:false",      // 5개, 보너스 x
            "1,2,3,4,7,45:4:true",      // 4개, 보너스 O
            "1,2,3,4,7,8:4:false",      // 4개, 보너스 x
            "1,2,3,7,8,45:3:true",      // 3개, 보너스 O
            "1,2,3,7,8,9:3:false",      // 3개, 보너스 x
            "1,2,7,8,9,45:2:true",      // 2개, 보너스 O
            "1,2,7,8,9,10:2:false",     // 2개, 보너스 x
            "1,7,8,9,10,45:1:true",     // 1개, 보너스 O
            "1,7,8,9,10,11:1:false",    // 1개, 보너스 x
            "7,8,9,10,11,12:0:false"    // 0개, 보너스 x
        ],
        delimiter = ':'
    )
    fun winningLottoJudgeTest(numbers: String, expectedMatchedCount: Int, expectedMatchedBonus: Boolean) {
        // given
        val myNumbers = numbers.split(",")
            .map { number -> number.toInt() }
            .toList()
        val myLotto = Lotto(myNumbers)
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 45)

        // when
        val result = winningLotto.judge(myLotto)

        // then
        assertThat(result.countMatchedNumbers).isEqualTo(expectedMatchedCount)
        assertThat(result.matchedBonus).isEqualTo(expectedMatchedBonus)
    }

}