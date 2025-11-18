package lotto.view

import lotto.dto.LottoNumbers
import lotto.dto.TotalLottoResult
import lotto.model.LottoPrize
import lotto.model.PurchaseLottos

class OutputView {

    fun printEnterPurchaseAmount() {
        println("구입금액을 입력해주세요.")
    }

    fun printPurchaseLottos(purchaseLottos: PurchaseLottos) {
        val lottoNumbers = purchaseLottos.infos()
        printPurchaseCount(lottoNumbers.size)
        printLottoNumbers(lottoNumbers)
    }

    private fun printPurchaseCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    private fun printLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoNumbers.forEach{lotto -> println(lotto.numbers)}
    }

    fun printEnterWinningNumbers() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun printEnterBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printTotalResult(totalLottoResult: TotalLottoResult) {
        println("당첨 통계")
        println("---")
        totalLottoResult.lottoResultsByPrize
            .filterNot { (prize, _) -> prize == LottoPrize.NONE }
            .forEach { (prize, count) -> printResult(prize, count) }
        printReturnRate(totalLottoResult)
    }

    private fun printResult(prize: LottoPrize, count: Int) {
        val stringBuilder = StringBuilder()
        stringBuilder.append(prize.requiredMatchCount)
            .append("개 일치")
        if (prize.bonusRequired) {
            stringBuilder.append(", 보너스 볼 일치")
        }
        stringBuilder.append("(${prize.reward})")
            .append(" - ")
            .append(count)
            .append("개")
        println(stringBuilder)
    }

    private fun printReturnRate(totalLottoResult: TotalLottoResult) {
        println("총 수익률은 ${totalLottoResult.returnRate()}%입니다.")
    }
}
