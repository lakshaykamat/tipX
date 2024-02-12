package com.lakshaykamat.tipX.view.screens.information

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lakshaykamat.tipX.R
import com.lakshaykamat.tipX.view.AppBar


@Composable
fun InformationScreen(nav: NavController) {
    val context = LocalContext.current
    val githubUrl = stringResource(id = R.string.author_github_link)
    val repoUrl  = stringResource(id = R.string.repo_link)

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        AppBar(
            title = stringResource(R.string.app_name),
            haveBackButton = true,
            onBackButtonPress = { nav.navigateUp() },
            actionButton = {}
        )
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = stringResource(id = R.string.about_app))
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { openLink(context = context, url = repoUrl) }) {
                Text(text = "Want to contribute to this?")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Developer Info",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.author_bio),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { openLink(context = context, url = githubUrl) }) {
                Text(text = "Github", style = MaterialTheme.typography.bodySmall)
            }
        }

    }
}

private fun openLink(context: android.content.Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}