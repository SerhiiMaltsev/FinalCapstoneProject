package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.core.content.edit

@Composable
fun Profile(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(USER_PROFILE, Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString(FIRST_NAME, "N/A")
    val lastName = sharedPreferences.getString(LAST_NAME, "N/A")
    val email = sharedPreferences.getString(EMAIL, "N/A")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.littlelemonlogo),
            contentDescription = "Profile Logo",
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Profile information",
            style = typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "First Name: $firstName",
            modifier = Modifier.padding(top = 8.dp),
            style = typography.bodyMedium
        )
        Text(
            text = "Last Name: $lastName",
            modifier = Modifier.padding(top = 8.dp),
            style = typography.bodyMedium
        )
        Text(
            text = "Email: $email",
            modifier = Modifier.padding(top = 8.dp),
            style = typography.bodyMedium
        )

        Button(
            onClick = {
                sharedPreferences.edit { clear() }

                navController.navigate(OnBoardingDestination.route) {
                    popUpTo(OnBoardingDestination.route) { inclusive = true }
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Log Out")
        }
    }
}