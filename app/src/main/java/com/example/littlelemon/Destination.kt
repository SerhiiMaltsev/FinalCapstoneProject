package com.example.littlelemon

interface Destinations {
    val route: String
}

object OnBoardingDestination : Destinations {
    override val route = "OnBoarding"
}

object HomeDestination : Destinations {
    override val route = "Home"
}

object ProfileDestination : Destinations {
    override val route = "Profile"
}