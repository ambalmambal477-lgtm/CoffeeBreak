package com.example.coffeebreak.presentation.Welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.dmSans
import com.example.coffeebreak.common.poppinsMedium
import com.example.coffeebreak.common.redressed
import com.example.coffeebreak.ui.theme.Theme
import io.github.jan.supabase.realtime.Column
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController) {
    LaunchedEffect(key1 = null) {
        delay(1500)
        navController.navigate(Navigation.Auth)
    }
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Box(modifier = Modifier
                .padding(top = 62.dp)
                .fillMaxWidth()
                .background(color = colorResource(R.color.mainColor))){
                Column(modifier = Modifier
                    .padding(top = 63.dp)
                    .padding(bottom = 46.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(R.drawable.coffee_cup),
                        contentDescription = null,
                        modifier = Modifier.size(98.dp))
                    Text(
                        text = stringResource(R.string.coffee_break),
                        color = Color.White,
                        fontSize = 64.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = redressed,
                        modifier = Modifier
                            .padding(top = 54.dp)
                    )
                }
            }
            Column(modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(R.string.feel_barista),
                    color = Theme.colors.feelBarista,
                    fontWeight = FontWeight(500),
                    fontSize = 25.sp,
                    fontFamily = poppinsMedium,
                    textAlign = TextAlign.Center
                )
                Text(text = stringResource(R.string.any_coffee),
                    color = colorResource(R.color.anyCoffee),
                    fontSize = 17.sp,
                    fontFamily = dmSans,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }
        }
    }
}