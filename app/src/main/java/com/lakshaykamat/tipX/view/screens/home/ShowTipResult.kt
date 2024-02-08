package com.lakshaykamat.tipX.view.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lakshaykamat.tipX.R
import com.lakshaykamat.tipX.data.Tip

@Composable
fun ShowTipResults(bill: Tip) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        //Total Amount
        Text(
            text = stringResource(
                id = R.string.amount_to_pay,
                bill.totalAmount.toString()
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(
                id = R.string.total_tip,
                bill.tip.toString()
            ),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        if (bill.person!! > 1) {
            Text(
                text =
                stringResource(
                    R.string.tip_each_person,
                    bill.totalTipEachPerson.toString()
                )
            )
            Text(
                text =
                stringResource(
                    R.string.amount_each_person,
                    bill.totalAmountEachPerson.toString()
                )
            )
        }
    }
}