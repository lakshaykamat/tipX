package com.lakshaykamat.tipX

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TipCalculationTest {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = 2.0
        val actualTip = TipCalculation.calculateTip(amount,tipPercent,1)
        assertEquals(expectedTip, actualTip.tip)
    }
    @Test
    fun calculateTip_22PercentNoRoundup() {
        val amount = 10900.00
        val tipPercent = 22.00
        val expectedTip = 2398.0
        val actualTip = TipCalculation.calculateTip(amount,tipPercent,1)
        assertEquals(expectedTip, actualTip.tip)
    }
}