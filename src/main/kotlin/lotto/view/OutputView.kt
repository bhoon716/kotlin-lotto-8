package lotto.view

class OutputView {

    fun printEnterPurchaseAmount() {
        println("구입금액을 입력해주세요.")
    }

    fun printPurchaseAmount(count: Int) {
        println("${count}개를 구매했습니다.")
    }
}