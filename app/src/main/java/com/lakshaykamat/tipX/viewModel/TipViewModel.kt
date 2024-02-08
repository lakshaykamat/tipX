package com.lakshaykamat.tipX.viewModel

import androidx.lifecycle.ViewModel
import com.lakshaykamat.tipX.data.Tip
import java.math.BigDecimal
import java.math.RoundingMode

class TipViewModel : ViewModel() {
    private fun formatDecimal(value: Double, decimalPlaces: Int): Double {
        val bd = BigDecimal(value)
        return bd.setScale(decimalPlaces, RoundingMode.HALF_UP).toDouble()
    }
    fun calculateTip(
        amount: Double,
        tipPercentage: Double,
        person: Int,
        decimalPlaces: Int = 2
    ): Tip {
        val tip = formatDecimal(amount * (tipPercentage / 100), decimalPlaces)
        val totalAmount = formatDecimal(amount + tip, decimalPlaces)
        val totalAmountEachPerson = formatDecimal(totalAmount / person, decimalPlaces)
        val totalTipEachPerson = formatDecimal(tip / person, decimalPlaces)

        return Tip(tip, totalAmount, person, totalAmountEachPerson, totalTipEachPerson)
    }
}