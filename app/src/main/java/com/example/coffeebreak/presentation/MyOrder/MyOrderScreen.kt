package com.example.coffeebreak.presentation.MyOrder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.Navigation
import coil3.compose.AsyncImage
import com.example.coffeebreak.R
import com.example.coffeebreak.common.dmSans
import com.example.coffeebreak.common.montserratRegular
import com.example.coffeebreak.common.montserratSemiBold
import com.example.coffeebreak.common.poppinsMedium
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme
import io.github.jan.supabase.realtime.Column

@Composable
fun MyOrderScreen(navController: NavController,vm: MyOrderVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            IconButton(
                onClick = {
                    navController.navigate(com.example.coffeebreak.Navigation.Menu)
                },
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 26.dp)
            ) {
                Icon(painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Color.Black)
            }
            Text(text = stringResource(R.string.my_order),
                color = Color.Black,
                fontFamily = robotoMedium,
                fontWeight = FontWeight(500),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(start = 29.dp)
            )
            if(state.load){
                CircularProgressIndicator(color = Theme.colors.feelBarista)
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 27.dp)
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                ) {
                    items(state.orderList) { item ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(15.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(vertical = 18.dp)
                                    .padding(start = 15.dp)
                                    .padding(end = 7.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        model = item.image,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(
                                                72.dp,
                                                57.dp
                                            ),
                                        contentScale = ContentScale.Fit
                                    )
                                    Column(
                                        modifier = Modifier
                                            .padding(start = 15.dp)
                                    ) {
                                        Text(
                                            text = item.name,
                                            color = Color.Black,
                                            fontFamily = robotoMedium,
                                            fontWeight = FontWeight(500),
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = item.description,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight(400),
                                            fontFamily = robotoRegular,
                                            color = colorResource(R.color.gray),
                                            modifier = Modifier
                                                .padding(top = 8.dp)
                                        )
                                        Text(
                                            text = "x " + item.count.toString(),
                                            color = Color.Black.copy(alpha = 0.57f),
                                            fontWeight = FontWeight(500),
                                            fontFamily = robotoMedium,
                                            fontSize = 12.sp,
                                            modifier = Modifier
                                                .padding(top = 5.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = item.price.toString() + " ₽",
                                    color = Color.Black,
                                    fontFamily = montserratSemiBold,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(600),
                                    modifier = Modifier
                                        .align(Alignment.Top)
                                        .padding(top = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .padding(bottom = 33.dp)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Row(modifier = Modifier
                .padding(start = 33.dp)
                .padding(end = 28.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
                ) {
                Column {
                    Text(text = stringResource(R.string.total_sum),
                        color = colorResource(R.color.totalSum).copy(alpha = 0.22f),
                        fontWeight = FontWeight(500),
                        fontSize = 12.sp,
                        fontFamily = robotoMedium)
                    Text(text = state.totalSum.toString() + " ₽",
                        color = colorResource(R.color.totalSum),
                        fontWeight = FontWeight(500),
                        fontFamily = poppinsMedium,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .padding(start = 30.dp)
                    )
                }
                Box(modifier = Modifier
                    .background(
                        color = colorResource(R.color.confirm),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .size(162.dp, 52.dp)
                    .clickable {
                        vm.onEvent(MyOrderEvent.ShowPayPanel)
                    },
                    contentAlignment = Alignment.Center){
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(R.drawable.cart_icon),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp))
                        Text(text = stringResource(R.string.next),
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = robotoMedium,
                            fontWeight = FontWeight(600),
                            modifier = Modifier
                                .padding(start = 25.dp))
                    }
                }
            }
        }
        if(state.payPanel)
        {
            Box(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f)),
                contentAlignment = Alignment.BottomCenter){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(
                            topEnd = 35.dp,
                            topStart = 35.dp
                        )
                    )){
                    Column(modifier = Modifier
                        .padding(top = 35.dp)
                        .padding(start = 33.dp)
                        .padding(end = 28.dp)
                        .padding(bottom = 165.dp)
                        .fillMaxWidth()) {
                        Text(text = stringResource(R.string.order_pay),
                            color = colorResource(R.color.totalSum),
                            fontWeight = FontWeight(400),
                            fontFamily = dmSans,
                            fontSize = 20.sp
                        )
                        Row(modifier = Modifier
                            .padding(top= 79.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .size(47.dp),
                                contentAlignment = Alignment.Center){
                                Icon(painterResource(R.drawable.cart_icon),
                                    contentDescription = null,
                                    tint = colorResource(R.color.totalSum),
                                    modifier = Modifier
                                        .size(20.dp))
                            }
                            Column(modifier = Modifier
                                .padding(start = 24.dp)) {
                                Text(text = state.name + "\n",
                                    fontWeight = FontWeight(500),
                                    fontFamily = robotoMedium,
                                    fontSize = 12.sp,
                                    color = colorResource(R.color.totalSum))
                                Text(text = stringResource(R.string.coffee_break_cafe),
                                    color = colorResource(R.color.totalSum),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular
                                )
                                Text(text = state.address,
                                    color = colorResource(R.color.totalSum),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = montserratRegular
                                )
                            }
                        }
                        Row(modifier = Modifier
                            .padding(top = 45.dp)
                            .padding(start = 21.dp)
                            .padding(end = 15.dp)
                            .padding(vertical = 17.dp)
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .border(
                                            1.dp, color = colorResource(R.color.totalSum),
                                            shape = CircleShape
                                        )
                                        .size(20.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                color = colorResource(R.color.totalSum),
                                                shape = CircleShape
                                            )
                                            .size(10.dp)
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(start = 18.dp)
                                ) {
                                    Text(text = stringResource(R.string.pay_online),
                                        color = colorResource(R.color.totalSum),
                                        fontWeight = FontWeight(500),
                                        fontFamily = dmSans,
                                        fontSize = 14.sp)
                                    Text(text = stringResource(R.string.sbp),
                                        color = colorResource(R.color.totalSum).copy(alpha = 0.22f),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight(500),
                                        fontFamily = poppinsMedium,
                                        modifier = Modifier
                                            .padding(top = 7.dp))
                                }
                            }
                            Image(painter = painterResource(R.drawable.sbp),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(92.dp, 46.dp),
                                contentScale = ContentScale.Fit)
                        }

                        Row(modifier = Modifier
                            .padding(top = 19.dp)
                            .padding(start = 21.dp)
                            .padding(end = 15.dp)
                            .padding(vertical = 17.dp)
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .border(
                                            1.dp, color = colorResource(R.color.totalSum),
                                            shape = CircleShape
                                        )
                                        .size(20.dp)
                                )
                                Column(
                                    modifier = Modifier
                                        .padding(start = 18.dp)
                                ) {
                                    Text(text = stringResource(R.string.bank_card),
                                        color = colorResource(R.color.totalSum),
                                        fontWeight = FontWeight(500),
                                        fontFamily = dmSans,
                                        fontSize = 14.sp)
                                    Text(text = "2540 xxxx xxxx 2648",
                                        color = colorResource(R.color.totalSum).copy(alpha = 0.22f),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight(500),
                                        fontFamily = poppinsMedium,
                                        modifier = Modifier
                                            .padding(top = 7.dp))
                                }
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(R.drawable.mir),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(47.dp, 14.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Image(
                                    painter = painterResource(R.drawable.union),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(start = 7.dp)
                                        .size(42.dp, 26.dp),
                                    contentScale = ContentScale.Fit
                                )
                            }
                        }
                    }
                }
                Box(modifier = Modifier
                    .padding(bottom = 33.dp)
                    .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter){
                    Row(modifier = Modifier
                        .padding(start = 33.dp)
                        .padding(end = 28.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column {
                            Text(text = stringResource(R.string.total_amount),
                                color = colorResource(R.color.totalSum).copy(alpha = 0.22f),
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                fontFamily = robotoMedium)
                            Text(text = state.totalSum.toString() + " ₽",
                                color = colorResource(R.color.totalSum),
                                fontWeight = FontWeight(500),
                                fontFamily = poppinsMedium,
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .padding(start = 30.dp)
                            )
                        }
                        Box(modifier = Modifier
                            .background(
                                color = colorResource(R.color.confirm),
                                shape = RoundedCornerShape(30.dp)
                            )
                            .size(162.dp, 52.dp)
                            .clickable {
                                navController.navigate(com.example.coffeebreak.Navigation.OrderConfirmed(name = state.name,
                                    address = state.address))
                            },
                            contentAlignment = Alignment.Center){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(painter = painterResource(R.drawable.card_icon),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(24.dp))
                                Text(text = stringResource(R.string.pay_now),
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontFamily = robotoMedium,
                                    fontWeight = FontWeight(600),
                                    modifier = Modifier
                                        .padding(start = 18.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}