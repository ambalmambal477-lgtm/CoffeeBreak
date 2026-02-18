package com.example.coffeebreak.presentation.Barista

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
import androidx.compose.ui.draw.clip
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
fun BaristaScreen(navController: NavController, vm: BaristaVM = hiltViewModel()) {
    val state = vm.state.value
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
                Text(text = stringResource(R.string.order_constructor),
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

            Text(text = stringResource(R.string.choose_barista),
                color = Theme.colors.chooseBarista,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                fontFamily = robotoRegular,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .padding(start = 29.dp)
            )

            if(state.load){
                CircularProgressIndicator(color = Theme.colors.feelBarista)
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 17.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                ) {
                    items(state.baristaList){ item ->
                        Box(modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth()
                            .background(color  = Color.White,
                                shape = RoundedCornerShape(22.dp)
                            )
                            .clickable{
                                navController.navigate(Navigation.Designer)
                            }){
                            Row(modifier = Modifier
                                .padding(vertical = 10.dp)
                                .padding(start = 8.dp)
                                .padding(end = 34.dp)
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        model = item.image,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(16.dp))
                                            .size(62.dp),
                                        contentScale = ContentScale.Crop
                                    )
                                    Column(modifier = Modifier
                                        .padding(start = 17.dp)) {
                                        Text(text = item.name,
                                            color = Theme.colors.topScreenText,
                                            fontWeight = FontWeight(400),
                                            fontFamily = robotoRegular,
                                            fontSize = 14.sp)
                                        Text(text = item.status,
                                            color = colorResource(R.color.baristaStatus),
                                            fontWeight = FontWeight(400),
                                            fontFamily = poppinsMedium,
                                            fontSize = 12.sp,
                                            modifier = Modifier
                                                .padding(top = 12.dp))
                                    }
                                }
                                Box(modifier = Modifier
                                    .background(color = if(item.status == "Топ-бариста"){
                                        colorResource(R.color.mainColor)
                                    } else{
                                        colorResource(R.color.red)
                                    },
                                        shape = CircleShape
                                    )
                                    .size(15.dp))
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
            BottomNavigationBar(navController, Navigation.Menu)
        }
    }
}