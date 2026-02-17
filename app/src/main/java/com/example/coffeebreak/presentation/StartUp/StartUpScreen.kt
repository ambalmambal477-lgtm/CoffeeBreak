package com.example.coffeebreak.presentation.StartUp

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.redressed
import kotlinx.coroutines.delay

@Composable
fun StartUpScreen(navController: NavController) {
    LaunchedEffect(key1 = null) {
        delay(1500)
        navController.navigate(Navigation.Menu)
    }
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()){
            Image(painter = painterResource(R.drawable.startup_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillHeight)
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            contentAlignment = Alignment.Center){
            Column(modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(R.drawable.coffee_cup),
                    contentDescription = null,
                    modifier = Modifier
                        .size(98.dp))
                Text(text = stringResource(R.string.coffee_break),
                    fontFamily = redressed,
                    fontWeight = FontWeight(400),
                    fontSize = 64.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 71.dp)
                )
            }
        }
    }
}