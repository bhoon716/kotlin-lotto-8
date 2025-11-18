package lotto.controller

import lotto.model.LottoMachine
import lotto.model.strategy.LottoRandomIssueStrategy
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        outputView.printEnterPurchaseAmount()
        val purchaseAmount = inputView.readPurchaseAmount()

        val lottoMachine = LottoMachine(LottoRandomIssueStrategy())

        val purchaseLottos = lottoMachine.purchase(purchaseAmount)
        outputView.printPurchaseLottos(purchaseLottos)

        outputView.printEnterWinningNumbers()
        inputView.readWinningNumbers()
    }
}
