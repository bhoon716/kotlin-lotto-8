package lotto.model

import lotto.error.ErrorCode
import lotto.model.strategy.LottoIssueStrategy
import java.util.stream.IntStream

class LottoMachine(private val issueStrategy: LottoIssueStrategy) {

    fun purchase(amount: Int): PurchaseLottos {
        validate(amount)
        val count = amount / Lotto.PRICE
        val lottos = IntStream.range(0, count)
            .mapToObj { i -> issueStrategy.issue() }
            .map { numbers -> Lotto(numbers) }
            .toList()
        return PurchaseLottos(lottos)
    }

    private fun validate(amount: Int) {
        require(Lotto.PRICE <= amount && amount <= Lotto.MAXIMUM_PRICE) { ErrorCode.INVALID_PURCHASE_AMOUNT.message() }
        require(amount % Lotto.PRICE == 0) { ErrorCode.INVALID_PURCHASE_AMOUNT.message() }
    }
}
