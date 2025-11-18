package lotto.error

enum class ErrorCode(private val message: String) {

    INT_FORMAT_ERROR("정수를 입력하지 않았습니다. 정수를 입력해주세요"),
    INVALID_PURCHASE_AMOUNT("올바르지 않은 구입 금액입니다. 1,000원 ~ 100,000원 사이의, 1,000원으로 나누어 떨어지는 금액만 가능합니다. "),
    DUPLICATED_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다. 보너스 번호는 당첨번호와 중복되지 않는 1 ~ 45의 정수만 가능합니다."),
    INVALID_BONUS_NUMBER("올바르지 않은 보너스 번호입니다. 보너스 번호는 당첨번호와 중복되지 않는 1 ~ 45의 정수만 가능합니다.")
    ;

    fun message(): String {
        return "[Error] $message"
    }
}
