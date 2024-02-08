package com.lakshaykamat.tipX.data

data class Tip(
    val tip:Double,
    val totalAmount:Double,
    val person:Int?,
    val totalAmountEachPerson:Double?,
    val totalTipEachPerson:Double?
)
