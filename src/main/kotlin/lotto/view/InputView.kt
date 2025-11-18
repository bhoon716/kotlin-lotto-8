package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.IntParser

class InputView {

    fun readPurchaseAmount(): Int {
        return IntParser.parse(Console.readLine())
    }

    fun readWinningNumbers(): List<Int> {
        val numbers = Console.readLine()
        return numbers
            .split(",")
            .map { number -> IntParser.parse(number) }
            .toList()
    }
}
