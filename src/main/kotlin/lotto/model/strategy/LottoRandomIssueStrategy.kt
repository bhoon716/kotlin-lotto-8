package lotto.model.strategy

import camp.nextstep.edu.missionutils.Randoms

class LottoRandomIssueStrategy: LottoIssueStrategy {

    override fun issue(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}