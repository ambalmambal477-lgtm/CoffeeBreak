package com.example.coffeebreak.presentation.OrderIsConfirmed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme
import io.github.jan.supabase.realtime.Column

@Composable
fun OrderIsConfirmedScreen(navController: NavController, name: String, address: String) {
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            IconButton(
                onClick = {
                    navController.navigate(Navigation.Menu)
                },
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 26.dp)
            ) {
                Icon(painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Theme.colors.backIcon)
            }
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center){
                Column(modifier = Modifier
                    .padding(horizontal = 35.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painterResource(R.drawable.take_away),
                        contentDescription = null,
                        tint = colorResource(R.color.totalSum),
                        modifier = Modifier
                            .size(150.dp,160.dp)
                    )
                    Text(text = stringResource(R.string.ordered),
                        color = Color.Black,
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight(400),
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 32.dp)
                    )
                    Text(text = name + stringResource(R.string.n_002) + "\n",
                        color = colorResource(R.color.anyCoffee),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        fontFamily = robotoRegular,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 22.dp))
                    Text(text = stringResource(R.string.order_prepare_today) + "\n" + address + "\n",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = robotoRegular,
                        textAlign = TextAlign.Center)
                    Text(text = stringResource(R.string.show_qr),
                        color = colorResource(R.color.anyCoffee),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        fontFamily = robotoRegular,
                        textAlign = TextAlign.Center)
                }
            }
        }
    }
}