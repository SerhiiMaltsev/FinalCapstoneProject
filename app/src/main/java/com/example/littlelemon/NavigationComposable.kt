package com.example.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavigationComposable(navController: NavHostController, database: AppDatabase) {
    val isUserData = isUserDataInSharedPreferences()

    NavHost(
        navController = navController,
        startDestination = if (isUserData) OnBoardingDestination.route else HomeDestination.route
    ) {
        composable(OnBoardingDestination.route) {
            OnBoarding(navController = navController)
        }
        composable(HomeDestination.route) {
            Home(navController = navController, database)
        }
        composable(ProfileDestination.route) {
            Profile(navController = navController)
        }
    }
}

@Composable
fun isUserDataInSharedPreferences(): Boolean {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(USER_PROFILE, Context.MODE_PRIVATE)
    val email = sharedPreferences.getString(EMAIL, "") ?: ""
    return email.isNotBlank()
}