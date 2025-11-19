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
            .split(WINNING_NUMBER_DELIMITER)
            .map { number -> IntParser.parse(number) }
            .toList()
    }

    fun readBonusNumber(): Int {
        return IntParser.parse(Console.readLine())
    }

    private companion object {
        const val WINNING_NUMBER_DELIMITER = ","
    }
}
