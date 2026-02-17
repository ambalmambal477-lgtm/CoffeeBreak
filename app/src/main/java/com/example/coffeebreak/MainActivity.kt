package com.example.coffeebreak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeebreak.presentation.Authorization.AuthorizationScreen
import com.example.coffeebreak.presentation.Cafe.CafeScreen
import com.example.coffeebreak.presentation.ForgotPassword.ForgotPasswordScreen
import com.example.coffeebreak.presentation.Menu.MenuScreen
import com.example.coffeebreak.presentation.Registartion.RegistrationScreen
import com.example.coffeebreak.presentation.ResetPassword.ResetPasswordScreen
import com.example.coffeebreak.presentation.StartUp.StartUpScreen
import com.example.coffeebreak.presentation.TwoFactorVerification.TwoFactorVerificationScreen
import com.example.coffeebreak.presentation.Welcome.WelcomeScreen
import com.example.coffeebreak.ui.theme.AppTheme
import com.example.coffeebreak.ui.theme.CoffeeBreakTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Navigation.Welcome){
                    composable<Navigation.Welcome> {
                        WelcomeScreen(navController = navController)
                    }
                    composable<Navigation.Auth> {
                        AuthorizationScreen(navController)
                    }
                    composable<Navigation.Startup> {
                        StartUpScreen(navController)
                    }
                    composable<Navigation.Registration> {
                        RegistrationScreen(navController)
                    }
                    composable<Navigation.Cafe> {
                        CafeScreen(navController)
                    }
                    composable<Navigation.Menu> {
                        MenuScreen(navController)
                    }
                    composable<Navigation.ForgotPassword> {
                        ForgotPasswordScreen(navController)
                    }
                    composable<Navigation.TwoFactor> {
                        TwoFactorVerificationScreen(navController)
                    }
                    composable<Navigation.ResetPassword> {
                        ResetPasswordScreen(navController)
                    }
                }
            }
        }
    }
}