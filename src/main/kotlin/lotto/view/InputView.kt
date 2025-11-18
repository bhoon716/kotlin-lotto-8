package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.IntParser

class InputView {

    fun readPurchaseAmount(): Int {
        return IntParser.parse(Console.readLine())
    }
}