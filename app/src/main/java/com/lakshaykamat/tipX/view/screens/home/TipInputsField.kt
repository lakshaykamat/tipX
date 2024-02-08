package com.lakshaykamat.tipX.view.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.lakshaykamat.tipX.R

@Composable
fun TipInputsField(
    amount: String,
    onAmountChange: (String) -> Unit,
    tip: String,
    onTipChange: (String) -> Unit,
    isBillRoundUp:Boolean,
    setBillRoundUp:(Boolean)->Unit,
    person: String,
    onPersonChange: (String) -> Unit
) {
    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.attach_money),
                contentDescription = null
            )
        },
        label = { Text(text = "Enter Amount") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        value = amount,
        onValueChange = { onAmountChange(it) })
    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.percent),
                contentDescription = null
            )
        },
        label = { Text(text = "Enter Tip %") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        value = tip,
        onValueChange = { onTipChange(it) })
    OutlinedTextField(
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null) },
        label = { Text(text = "No. of Person") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        value = person,
        onValueChange = { onPersonChange(it) })
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Round the tip?")
        Switch(checked = isBillRoundUp, onCheckedChange = { setBillRoundUp(!isBillRoundUp) })
    }
}