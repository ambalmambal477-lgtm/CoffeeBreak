package com.example.coffeebreak.presentation.Designer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.interRegular
import com.example.coffeebreak.common.montserratRegular
import com.example.coffeebreak.common.montserratSemiBold
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun DesignerScreen(navController: NavController, vm: DesignerVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Text(text = stringResource(R.string.choose_barista),
                modifier = Modifier
                    .padding(top = 39.dp)
                    .padding(start = 29.dp)
                    .clickable {
                        navController.navigate(Navigation.Barista)
                    })
            Text(text = stringResource(R.string.sort_coffee),
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 29.dp)
                    .clickable {
                        navController.navigate(Navigation.CoffeeCountry)
                    })
            Text(text = stringResource(R.string.additives),
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 29.dp)
                    .clickable {
                        navController.navigate(Navigation.Additives)
                    })
            Text(text = stringResource(R.string.encyclopedya),
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 29.dp)
                    .clickable {
                        vm.onEvent(DesignerEvent.ShowPanel)
                    })
            Button(
                onClick = {
                    navController.navigate(Navigation.MyOrder)
                },
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 29.dp)
            ) {
                Text(text = stringResource(R.string.next))
            }
        }
        if(state.panel) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(R.color.mainColor),
                        shape = RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )){
                    Column(modifier = Modifier
                        .padding(top = 21.dp)
                        .padding(bottom = 43.dp)
                        .padding(start = 36.dp)
                        .padding(end = 40.dp)
                        .fillMaxWidth()) {
                        Text(text = stringResource(R.string.encyclopedya),
                            color = Color.White,
                            fontWeight = FontWeight(400),
                            fontFamily = interRegular,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(text = "Бленд, состоящий из 90% арабики и\n10% робусты, считается\nклассическим для итальянского\nэспрессо. Не советуем создавать\nбленд с содержанием робусты\nболее 30%.",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = montserratRegular,
                            modifier = Modifier
                                .padding(top = 30.dp)
                        )
                        Row(modifier = Modifier
                            .padding(top = 29.dp)
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = stringResource(R.string.skip),
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontFamily = robotoMedium,
                                fontSize = 18.sp
                            )
                            Row {
                               Box(modifier = Modifier
                                   .background(color = Color.White,
                                       shape = CircleShape
                                   )
                                   .size(8.dp))
                                Box(modifier = Modifier
                                    .padding(start = 8.dp)
                                    .background(color = Color.White.copy(alpha = 0.3f),
                                        shape = CircleShape
                                    )
                                    .size(8.dp))
                                Box(modifier = Modifier
                                    .padding(start = 8.dp)
                                    .background(color = Color.White.copy(alpha = 0.3f),
                                        shape = CircleShape
                                    )
                                    .size(8.dp))
                            }
                            Text(text = stringResource(R.string.next),
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = robotoMedium)
                        }
                    }
                }
            }
        }
    }
}