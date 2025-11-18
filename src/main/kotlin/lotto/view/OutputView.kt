package lotto.view

import lotto.dto.LottoNumbers
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
}
