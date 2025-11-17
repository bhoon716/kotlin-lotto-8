package lotto.model

import lotto.model.strategy.LottoIssueStrategy
import java.util.stream.IntStream

class LottoMachine(private val issueStrategy: LottoIssueStrategy) {

    fun purchase(money: Int): PurchaseLottos {
        val amount = money / 1000
        val lottos = IntStream.range(0, amount)
            .mapToObj { i -> issueStrategy.issue() }
            .map { numbers -> Lotto(numbers) }
            .toList()
        return PurchaseLottos(lottos)
    }
}