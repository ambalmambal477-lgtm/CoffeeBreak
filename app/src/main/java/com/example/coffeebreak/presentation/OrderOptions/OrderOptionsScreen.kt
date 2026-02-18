package com.example.coffeebreak.presentation.OrderOptions

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.dmSans
import com.example.coffeebreak.common.montserratSemiBold
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.RewardLine
import com.example.coffeebreak.ui.theme.Theme
import io.github.jan.supabase.realtime.Column

@Composable
fun OrderOptionsScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Row(modifier = Modifier
                .padding(top = 21.dp)
                .padding(start = 26.dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween){
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(painter = painterResource(R.drawable.arrow_left),
                        contentDescription = null,
                        tint = Theme.colors.backIcon)
                }
                Text(text = stringResource(R.string.order),
                    color = Theme.colors.topScreenText,
                    fontWeight = FontWeight(500),
                    fontFamily = robotoMedium,
                    fontSize = 16.sp
                )
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(painter = painterResource(R.drawable.cart_icon),
                        contentDescription = null,
                        tint = Theme.colors.backIcon,
                        modifier = Modifier.size(24.dp))
                }
            }
            Column(modifier = Modifier
                .padding(top = 19.dp)
                .padding(horizontal = 25.dp)
                .fillMaxWidth()) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Theme.colors.orderOptionBox,
                        shape = RoundedCornerShape(12.dp)
                    ),
                    contentAlignment = Alignment.Center){
                    AsyncImage(
                        model = "https://ofxftxoekryasmmesvmk.supabase.co/storage/v1/object/public/coffee/capuccino.png",
                        contentDescription = null,
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .height(121.dp),
                        contentScale = ContentScale.FillHeight
                    )
                }
                Row(modifier = Modifier
                    .padding(top = 17.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = stringResource(R.string.capuccino),
                        color = Theme.colors.orderOptionText,
                        fontFamily = dmSans,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp
                    )
                    Box(modifier = Modifier
                        .border(width = 1.dp, color = colorResource(R.color.inactive),
                            shape = RoundedCornerShape(50.dp)),
                        contentAlignment = Alignment.Center){
                        Row(modifier = Modifier
                            .padding(vertical = 5.dp)
                            .padding(horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "-",
                                color = Theme.colors.orderOptionText,
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500))
                            Text(text = "1",
                                color = Theme.colors.orderOptionText,
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .padding(start = 16.dp))
                            Text(text = "+",
                                color = Theme.colors.orderOptionText,
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(500),
                                modifier = Modifier
                                    .padding(start = 16.dp))
                        }
                    }
                }
                Canvas(modifier = Modifier
                    .padding(top = 13.dp)
                    .fillMaxWidth()
                    .height(1.dp)) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 17.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = stringResource(R.string.ristretto),
                        color = Theme.colors.orderOptionText,
                        fontFamily = dmSans,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp
                    )
                    Row {
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.dp, color = Theme.colors.activeBorder,
                                    shape = RoundedCornerShape(50.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(R.string.one),
                                color = Theme.colors.orderOptionText,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(horizontal = 25.dp)
                                    .padding(vertical = 5.dp))
                        }
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .border(
                                    width = 1.dp, color = colorResource(R.color.inactive),
                                    shape = RoundedCornerShape(50.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(R.string.two),
                                color = Theme.colors.orderOptionText,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(horizontal = 25.dp)
                                    .padding(vertical = 5.dp))
                        }
                    }
                }
                Canvas(modifier = Modifier
                    .padding(top = 13.dp)
                    .fillMaxWidth()
                    .height(1.dp)) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 17.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = stringResource(R.string.on_sit),
                        color = Theme.colors.orderOptionText,
                        fontFamily = dmSans,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(R.drawable.cup_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                        Icon(painter = painterResource(R.drawable.plactick_glass),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(start = 31.dp))
                    }
                }
                Canvas(modifier = Modifier
                    .padding(top = 13.dp)
                    .fillMaxWidth()
                    .height(1.dp)) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 17.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = stringResource(R.string.volume),
                        color = Theme.colors.orderOptionText,
                        fontFamily = dmSans,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(R.drawable.volume_icon),
                                contentDescription = null,
                                tint = colorResource(R.color.inactive),
                                modifier = Modifier
                                    .size(17.dp, 22.dp)
                            )
                            Text(
                                text = "250",
                                color = colorResource(R.color.inactive),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }
                        Column(modifier = Modifier
                            .padding(start = 22.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(painter = painterResource(R.drawable.volume_icon),
                                contentDescription = null,
                                tint = Theme.colors.activeBorder,
                                modifier = Modifier
                                    .size(24.dp, 31.dp))
                            Text(text = "350",
                                color = Theme.colors.activeBorder,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                modifier = Modifier
                                    .padding(top = 8.dp))
                        }
                        Column(modifier = Modifier
                            .padding(start = 22.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(painter = painterResource(R.drawable.volume_icon),
                                contentDescription = null,
                                tint = colorResource(R.color.inactive),
                                modifier = Modifier
                                    .size(29.dp, 38.dp))
                            Text(text = "450",
                                color = colorResource(R.color.inactive),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                modifier = Modifier
                                    .padding(top = 8.dp))
                        }
                    }
                }
                Canvas(modifier = Modifier
                    .padding(top = 13.dp)
                    .fillMaxWidth()
                    .height(1.dp)) {
                    drawLine(
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        color = RewardLine
                    )
                }

                Row(modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Приготовить к\nопределенному времени\nсегодня?",
                        color = Theme.colors.orderOptionText,
                        fontFamily = dmSans,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500))
                    Column(horizontalAlignment = Alignment.End) {
                        Switch(
                            checked = true,
                            onCheckedChange = {

                            },
                            modifier = Modifier
                                .size(51.dp, 31.dp),
                            colors = SwitchDefaults.colors(
                                checkedTrackColor = colorResource(R.color.mainColor),
                                checkedBorderColor = colorResource(R.color.mainColor),
                                checkedThumbColor = Color.White,
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = colorResource(R.color.anyCoffee),
                                uncheckedBorderColor = colorResource(R.color.anyCoffee)
                            )
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .size(86.dp, 36.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "18 : 10",
                                color = Theme.colors.blackWhite,
                                fontFamily = dmSans,
                                fontWeight = FontWeight(400),
                                fontSize = 22.sp
                            )
                        }
                    }
                }

                Box(modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = colorResource(R.color.secondColor),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable{
                        navController.navigate(Navigation.Designer)
                    },
                    contentAlignment = Alignment.Center){
                    Row(modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(R.drawable.filter_icon),
                                contentDescription = null,
                                tint = Color.White
                            )
                            Text(
                                text = stringResource(R.string.coffee_constructor),
                                color = Color.White,
                                fontSize = 14.sp,
                                fontFamily = robotoRegular,
                                fontWeight = FontWeight(400),
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )
                        }
                        Icon(painter = painterResource(R.drawable.icon_more),
                            contentDescription = null,
                            tint = Color.White)
                    }
                }

                Row(modifier = Modifier
                    .padding(top = 28.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    Text(text = stringResource(R.string.total_sum),
                        color = Theme.colors.orderOptionText,
                        fontWeight = FontWeight(500),
                        fontFamily = robotoMedium,
                        fontSize = 16.sp)
                    Text(text = "250₽",
                        color = Theme.colors.orderOptionText,
                        fontWeight = FontWeight(600),
                        fontFamily = montserratSemiBold,
                        fontSize = 16.sp)
                }

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = colorResource(R.color.confirm),
                            shape = RoundedCornerShape(30.dp)),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Unspecified,
                        containerColor = colorResource(R.color.confirm)
                    )
                ) {
                    Text(text = stringResource(R.string.next),
                        color = Color.White,
                        fontFamily = robotoMedium,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600))
                }
            }
        }
    }
}