package lotto.model.strategy

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoRandomIssueStrategy: LottoIssueStrategy {

    override fun issue(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.NUMBER_COUNT)
    }
}
