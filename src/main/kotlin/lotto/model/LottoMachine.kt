package lotto.model

import lotto.error.ErrorCode
import lotto.model.strategy.LottoIssueStrategy
import java.util.stream.IntStream

class LottoMachine(private val issueStrategy: LottoIssueStrategy) {

    fun purchase(amount: Int): PurchaseLottos {
        validate(amount)
        val count = amount / 1_000
        val lottos = IntStream.range(0, count)
            .mapToObj { i -> issueStrategy.issue() }
            .map { numbers -> Lotto(numbers) }
            .toList()
        return PurchaseLottos(lottos)
    }

    private fun validate(amount: Int) {
        if(amount < 1_000 || amount > 100_000) {
            throw IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.message())
        }
        if(amount % 1_000 != 0) {
            throw IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.message())
        }
    }
}
