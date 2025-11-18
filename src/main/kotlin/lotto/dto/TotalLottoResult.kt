package lotto.dto

import lotto.model.LottoPrize

data class TotalLottoResult(val lottoResultsByPrize: Map<LottoPrize, Int>)
