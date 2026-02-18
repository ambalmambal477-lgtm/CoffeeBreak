package com.example.coffeebreak.presentation.Redeem

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.coffeebreak.R
import com.example.coffeebreak.common.poppinsMedium
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun RedeemScreen(navController: NavController, vm: RedeemVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Box(modifier = Modifier
                .padding(top = 21.dp)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center){
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .padding(start = 26.dp)
                        .align(Alignment.TopStart)
                ) {
                    Icon(painterResource(R.drawable.arrow_left),
                        contentDescription = null,
                        tint = Theme.colors.backIcon)
                }
                Text(text = stringResource(R.string.pay_with_points),
                    color = Theme.colors.topScreenText,
                    fontFamily = robotoMedium,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
            if (state.load){
                CircularProgressIndicator(color = Theme.colors.feelBarista)
            } else{
                LazyColumn(modifier = Modifier
                    .padding(top = 40.dp)
                    .padding(start = 22.dp)
                    .padding(end = 27.dp)
                    .fillMaxWidth()) {
                    items(state.redeemList){ item ->
                        Row(modifier = Modifier
                            .padding(bottom = 37.dp)
                            .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Row(verticalAlignment = Alignment.CenterVertically){
                                AsyncImage(
                                    model = item.image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(80.dp, 60.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Column(modifier = Modifier
                                    .padding(start = 16.dp)) {
                                    Text(text = item.name,
                                        color = colorResource(R.color.confirm),
                                        fontWeight = FontWeight(400),
                                        fontFamily = robotoRegular,
                                        fontSize = 14.sp
                                    )
                                    Text(text = stringResource(R.string.date_to) + item.date,
                                        color = Theme.colors.dateTo,
                                        fontWeight = FontWeight(500),
                                        fontFamily = poppinsMedium,
                                        fontSize = 10.sp,
                                        modifier = Modifier
                                            .padding(top = 10.dp)
                                    )
                                }
                            }
                            Box(modifier = Modifier
                                .background(
                                    colorResource(R.color.confirm),
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .size(76.dp, 32.dp)
                                .clickable {

                                },
                                contentAlignment = Alignment.Center){
                                Text(text = item.points.toString() + stringResource(R.string.points),
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = poppinsMedium)
                            }
                        }
                    }
                }
            }
        }
    }
}