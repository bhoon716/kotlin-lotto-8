package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.model.PurchaseLottos
import lotto.model.WinningLotto
import lotto.model.strategy.LottoRandomIssueStrategy
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val purchaseLottos = purchaseLottos()

        val winningLotto = setupWinningLotto()

        judgeLottos(purchaseLottos, winningLotto)
    }

    private fun purchaseLottos(): PurchaseLottos {
        val lottoMachine = LottoMachine(LottoRandomIssueStrategy())

        val purchaseAmount = readPurchaseAmount()

        val purchaseLottos = lottoMachine.purchase(purchaseAmount)

        outputView.printPurchaseLottos(purchaseLottos)
        return purchaseLottos
    }

    private fun readPurchaseAmount(): Int {
        outputView.setupPurchaseAmount()
        val purchaseAmount = inputView.readPurchaseAmount()
        return purchaseAmount
    }

    private fun setupWinningLotto(): WinningLotto {
        val winningNumbers = setupWinningNumbers()

        val bonusNumber = setupBonusNumber()

        return WinningLotto(Lotto(winningNumbers), bonusNumber)
    }

    private fun setupBonusNumber(): Int {
        outputView.printEnterBonusNumber()
        val bonusNumber = inputView.readBonusNumber()
        return bonusNumber
    }

    private fun setupWinningNumbers(): List<Int> {
        outputView.printEnterWinningNumbers()
        val winningNumbers = inputView.readWinningNumbers()
        return winningNumbers
    }

    private fun judgeLottos(purchaseLottos: PurchaseLottos, winningLotto: WinningLotto) {
        val totalLottoResult = purchaseLottos.judgeAll(winningLotto)
        outputView.printTotalResult(totalLottoResult)
    }
}
