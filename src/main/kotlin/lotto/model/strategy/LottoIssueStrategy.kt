package lotto.model.strategy

fun interface LottoIssueStrategy {

    fun issue(): List<Int>
}
