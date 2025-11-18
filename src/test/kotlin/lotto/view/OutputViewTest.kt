package lotto.view

import lotto.model.Lotto
import lotto.model.PurchaseLottos
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OutputViewTest {

    @Test
    fun name() {
        val l1 = Lotto(listOf(1,2,3,4,5,6))
        val l2 = Lotto(listOf(1,2,3,4,5,7))
        val l3 = Lotto(listOf(32,2,3,4,5,8))
        OutputView().printPurchaseLottos(PurchaseLottos(listOf(l1, l2, l3)))
    }
}