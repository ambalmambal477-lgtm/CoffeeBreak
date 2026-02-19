package com.example.coffeebreak.presentation.MyOrderHistory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.BottomNavigationBar
import com.example.coffeebreak.common.poppinsMedium
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun MyOrderHistoryScreen(navController: NavController, vm: MyOrderHistoryVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Theme.colors.mainBackground)
        ) {
            Text(
                text = stringResource(R.string.order_history),
                color = colorResource(R.color.totalSum),
                fontFamily = robotoMedium,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 21.dp)
                    .align(Alignment.CenterHorizontally)
            )
            if (state.load) {
                CircularProgressIndicator(color = Theme.colors.feelBarista)
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .padding(start = 25.dp)
                        .padding(end = 14.dp)
                        .fillMaxWidth()
                ) {
                    items(state.orderList) { item ->
                        Row(
                            modifier = Modifier
                                .padding(bottom = 41.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    model = item.image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(48.dp, 44.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Column(
                                    modifier = Modifier
                                        .padding(start = 18.dp)
                                ) {
                                    Text(
                                        text = item.name,
                                        color = colorResource(R.color.confirm),
                                        fontSize = 14.sp,
                                        fontFamily = robotoRegular,
                                        fontWeight = FontWeight(400)
                                    )
                                    Row(verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .padding(top = 9.dp)) {
                                        Icon(painter = painterResource(R.drawable.location_profile),
                                            contentDescription = null,
                                            tint = colorResource(R.color.confirm).copy(alpha = 0.8f),
                                            modifier = Modifier
                                                .size(14.dp))
                                        Text(text = item.address,
                                            color = colorResource(R.color.confirm),
                                            fontWeight = FontWeight(500),
                                            fontFamily = poppinsMedium,
                                            fontSize = 10.sp,
                                            modifier = Modifier
                                                .padding(start = 4.dp))
                                    }
                                    Text(
                                        text = item.date,
                                        color = colorResource(R.color.confirm).copy(alpha = 0.22f),
                                        fontWeight = FontWeight(500),
                                        fontSize = 10.sp,
                                        fontFamily = poppinsMedium,
                                        modifier = Modifier
                                            .padding(top = 7.dp)
                                    )
                                }
                            }
                            Column(modifier = Modifier
                                .align(Alignment.Top)) {
                                Text(
                                    text = item.price.toString() + " ₽",
                                    color = colorResource(R.color.confirm),
                                    fontWeight = FontWeight(500),
                                    fontFamily = robotoMedium,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(top = 1.dp)
                                )
                                Box(modifier = Modifier
                                    .padding(top = 12.dp)
                                    .background(
                                        color = colorResource(R.color.confirm),
                                        shape = RoundedCornerShape(50.dp)
                                    )
                                    .size(76.dp, 32.dp),
                                    contentAlignment = Alignment.Center){
                                    Text(text = stringResource(R.string.orderr),
                                        color = Color.White,
                                        fontFamily = poppinsMedium,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight(500))
                                }
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .padding(bottom = 18.dp)
            .fillMaxSize(),
             contentAlignment = Alignment.BottomCenter){
            BottomNavigationBar(navController, Navigation.MyOrderHistory)
        }
    }
}