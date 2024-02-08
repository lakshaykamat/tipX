package com.lakshaykamat.tipX.view.screens.information

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.lakshaykamat.tipX.R
import com.lakshaykamat.tipX.view.AppBar


@Composable
fun InformationScreen(nav: NavController) {
    Column {
        AppBar(
            title = stringResource(R.string.app_name),
            haveBackButton = true,
            onBackButtonPress = { nav.navigateUp() }
        ) {
        }
        Text("Screen 2")
        val message = nav.previousBackStackEntry?.arguments?.getString("message") ?: ""
        Text(text = message)
    }
}