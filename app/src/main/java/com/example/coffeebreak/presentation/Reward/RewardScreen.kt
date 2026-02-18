package com.example.coffeebreak.presentation.Reward

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.BottomNavigationBar
import com.example.coffeebreak.common.dmSans
import com.example.coffeebreak.common.poppinsMedium
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.RewardLine
import com.example.coffeebreak.ui.theme.Theme
import io.github.jan.supabase.realtime.Column

@Composable
fun RewardScreen(navController: NavController) {
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
                text = stringResource(R.string.reward),
                color = Theme.colors.topScreenText,
                fontSize = 16.sp,
                fontFamily = robotoMedium,
                fontWeight = FontWeight(500),
                modifier = Modifier
                    .padding(top = 21.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Column(
                modifier = Modifier
                    .padding(top = 31.dp)
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(R.color.confirm),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 14.dp)
                            .padding(start = 30.dp)
                            .padding(end = 28.dp)
                            .padding(bottom = 49.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(end = 7.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = stringResource(R.string.loyalty_card),
                                color = colorResource(R.color.inactive),
                                fontWeight = FontWeight(500),
                                fontFamily = dmSans,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "4 / 6",
                                color = colorResource(R.color.inactive),
                                fontWeight = FontWeight(500),
                                fontFamily = dmSans,
                                fontSize = 14.sp
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .padding(start = 4.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Icon(
                                    painter = painterResource(R.drawable.active_coffee_cup),
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                                Icon(
                                    painter = painterResource(R.drawable.active_coffee_cup),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.active_coffee_cup),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.active_coffee_cup),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.active_coffee_cup),
                                    contentDescription = null,
                                    tint = colorResource(R.color.anyCoffee),
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.active_coffee_cup),
                                    contentDescription = null,
                                    tint = colorResource(R.color.anyCoffee),
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                )
                            }
                            Text(
                                text = "16%",
                                color = colorResource(R.color.mainColor),
                                fontFamily = poppinsMedium,
                                fontSize = 25.sp,
                                fontWeight = FontWeight(500)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth()
                        .background(
                            color = colorResource(R.color.confirm),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(R.drawable.coffee_beans),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(66.dp)
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .padding(bottom = 25.dp)
                            .padding(start = 30.dp)
                            .padding(end = 20.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = stringResource(R.string.my_points),
                                color = colorResource(R.color.inactive),
                                fontFamily = dmSans,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500))
                            Text(text = "240",
                                color = colorResource(R.color.inactive),
                                fontFamily = poppinsMedium,
                                fontSize = 25.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .padding(top = 2.dp))
                        }
                        Box(modifier = Modifier
                            .size(111.dp, 28.dp)
                            .background(
                                colorResource(R.color.pointsButton).copy(alpha = 0.19f),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .clickable{
                                navController.navigate(Navigation.Redeem)
                            },
                            contentAlignment = Alignment.Center){
                            Text(text = stringResource(R.string.pay_points),
                                fontWeight = FontWeight(500),
                                fontFamily = poppinsMedium,
                                fontSize = 10.sp,
                                color = colorResource(R.color.inactive))
                        }
                    }
                }

                Text(text = stringResource(R.string.points_history),
                    color = colorResource(R.color.confirm),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = dmSans,
                    modifier = Modifier
                        .padding(top = 7.dp))
                Row(modifier = Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Американо",
                            color = colorResource(R.color.confirm),
                            fontWeight = FontWeight(500),
                            fontFamily = robotoMedium,
                            fontSize = 12.sp)
                        Text(text = "24 июня | 12:30",
                            color = Theme.colors.pointDate,
                            fontWeight = FontWeight(400),
                            fontFamily = robotoRegular,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(top = 9.dp))
                    }
                    Text(text = "+ 12 баллов",
                        color = colorResource(R.color.confirm),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = robotoMedium)
                }
                Canvas(
                    modifier = Modifier
                        .padding(top = 23.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                ){
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Латте",
                            color = colorResource(R.color.confirm),
                            fontWeight = FontWeight(500),
                            fontFamily = robotoMedium,
                            fontSize = 12.sp)
                        Text(text = "22 июня | 08:30",
                            color = Theme.colors.pointDate,
                            fontWeight = FontWeight(400),
                            fontFamily = robotoRegular,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(top = 9.dp))
                    }
                    Text(text = "+ 12 баллов",
                        color = colorResource(R.color.confirm),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = robotoMedium)
                }
                Canvas(
                    modifier = Modifier
                        .padding(top = 23.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                ){
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Раф",
                            color = colorResource(R.color.confirm),
                            fontWeight = FontWeight(500),
                            fontFamily = robotoMedium,
                            fontSize = 12.sp)
                        Text(text = "16 июня | 10:48",
                            color = Theme.colors.pointDate,
                            fontWeight = FontWeight(400),
                            fontFamily = robotoRegular,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(top = 9.dp))
                    }
                    Text(text = "+ 12 баллов",
                        color = colorResource(R.color.confirm),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = robotoMedium)
                }
                Canvas(
                    modifier = Modifier
                        .padding(top = 23.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                ){
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Флэт Уайт",
                            color = colorResource(R.color.confirm),
                            fontWeight = FontWeight(500),
                            fontFamily = robotoMedium,
                            fontSize = 12.sp)
                        Text(text = "12 мая | 11:25",
                            color = Theme.colors.pointDate,
                            fontWeight = FontWeight(400),
                            fontFamily = robotoRegular,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(top = 9.dp))
                    }
                    Text(text = "+ 12 баллов",
                        color = colorResource(R.color.confirm),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = robotoMedium)
                }
                Canvas(
                    modifier = Modifier
                        .padding(top = 23.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                ){
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .padding(bottom = 18.dp)
            .fillMaxSize(),
            contentAlignment = Alignment
                .BottomCenter){
            BottomNavigationBar(navController, Navigation.RewardScreen)
        }
    }
}