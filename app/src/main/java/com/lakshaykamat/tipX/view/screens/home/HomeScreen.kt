package com.lakshaykamat.tipX.view.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lakshaykamat.tipX.R
import com.lakshaykamat.tipX.data.Tip
import com.lakshaykamat.tipX.view.AppBar
import com.lakshaykamat.tipX.view.screens.Screen
import com.lakshaykamat.tipX.viewModel.TipViewModel


@Composable
fun HomeScreen(nav: NavController) {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var isBillRoundUp by remember { mutableStateOf(false) }
    var bill by remember { mutableStateOf<Tip?>(null) }
    var personInput by remember { mutableStateOf("") }

    fun calculateTip() {
        bill = TipViewModel().calculateTip(
            amount = amountInput.toDoubleOrNull() ?: 0.0,
            tipPercentage = tipInput.toDoubleOrNull() ?: 0.0,
            person = personInput.toIntOrNull() ?: 1
        )
    }
    Column {
        AppBar(
            title = stringResource(R.string.app_name),
            haveBackButton = false,
            onBackButtonPress = {}
        ) {
            IconButton(
                onClick = {
                    nav.navigate(Screen.InformationScreen.toString())
                }
            ) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = null)
            }
        }
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(vertical = 10.dp, horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val message = nav.previousBackStackEntry?.arguments?.getString("message") ?: ""
            Text(text = message)
            TipInputsField(
                amount = amountInput,
                onAmountChange = { amountInput = it },
                tip = tipInput,
                onTipChange = { tipInput = it },
                person = personInput,
                onPersonChange = { personInput = it },
                isBillRoundUp = isBillRoundUp,
                setBillRoundUp = { isBillRoundUp = it }
            )
            Spacer(modifier = Modifier.height(16.dp))


            Button(modifier = Modifier.fillMaxWidth(), onClick = { calculateTip() }) {
                Text(text = stringResource(R.string.calculate_tip_btn_txt))
            }
            Spacer(modifier = Modifier.height(16.dp))
            bill?.let { ShowTipResults(it) }
        }
    }
}
