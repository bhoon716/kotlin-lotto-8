package lotto.model

import lotto.dto.LottoResult

enum class LottoPrize(
    private val requiredMatchCount: Int,
    val reward: Int
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun determine(result: LottoResult): LottoPrize {
            if (result.countMatchedNumbers == FIRST.requiredMatchCount) {
                return FIRST
            }
            if (result.countMatchedNumbers == SECOND.requiredMatchCount && result.matchedBonus) {
                return SECOND
            }
            if (result.countMatchedNumbers == THIRD.requiredMatchCount) {
                return THIRD
            }
            if (result.countMatchedNumbers == FOURTH.requiredMatchCount) {
                return FOURTH
            }
            if (result.countMatchedNumbers == FIFTH.requiredMatchCount) {
                return FIFTH
            }
            return NONE
        }
    }
}
