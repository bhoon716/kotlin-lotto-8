package lotto.error

enum class ErrorCode(private val message: String) {

    INVALID_PURCHASE_AMOUNT("올바르지 않은 구입 금액입니다. 1,000원 ~ 100,000원 사이의, 1,000원으로 나누어 떨어지는 금액만 가능합니다. "),
    ;

    fun message(): String {
        return "[Error] $message"
    }
}