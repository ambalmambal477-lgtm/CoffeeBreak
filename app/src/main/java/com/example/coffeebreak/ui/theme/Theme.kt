package com.example.coffeebreak.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

data class ThemeColors(
    val mainBackground: Color = Color.White,
    val feelBarista: Color = Color(0xFF181D2D),
    val signIn: Color = Color(0xFF14AC46),
    val welcomeText: Color= Color(0xFF324A59),
    val tfIcon: Color = Color(0xFF147F37),
    val eyeColor: Color = Color.Black,
    val forgotPassword : Color = Color(0xFF147F37),
    val signInWith: Color = Color.Black,
    val signUpAuth: Color = Color(0xFF14AC46),
    val backIcon: Color = Color.Black
)

private val LocalTheme = staticCompositionLocalOf {
    ThemeColors()
}

@Composable
fun AppTheme(
    isSystemDark: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
){
    val themeColors = if(isSystemDark){
        ThemeColors(
            mainBackground = Color(0xFF1D1D1D),
            feelBarista = Color.White,
            signIn = Color(0xFF4F7993),
            welcomeText = Color(0xFFA1A1A1),
            tfIcon = Color(0xFF4F7993),
            eyeColor = Color(0xFFA8A8A8),
            forgotPassword = Color(0xFF324A59),
            signInWith = Color.White,
            signUpAuth = Color(0xFF4F7993),
            backIcon = Color(0xFF4F7993)
        )
    } else{
        ThemeColors(
            mainBackground = Color.White,
            feelBarista = Color(0xFF181D2D),
            signIn = Color(0xFF14AC46),
            welcomeText = Color(0xFF324A59),
            tfIcon = Color(0xFF147F37),
            eyeColor = Color.Black,
            forgotPassword = Color(0xFF147F37),
            signInWith = Color.Black,
            signUpAuth = Color(0xFF14AC46),
            backIcon = Color.Black
        )
    }

    CompositionLocalProvider(
        LocalTheme provides themeColors,
        content = content
    )
}

object Theme{
    val colors: ThemeColors
        @Composable get() = LocalTheme.current
}

@Composable
fun CoffeeBreakTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}