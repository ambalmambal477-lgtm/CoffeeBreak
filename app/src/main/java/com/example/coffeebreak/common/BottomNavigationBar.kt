package com.example.coffeebreak.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun BottomNavigationBar(
    navController: NavController,
    currentScreen: Navigation
) {
    Box(modifier = Modifier
        .padding(horizontal = 25.dp)
        .fillMaxWidth()
        .height(64.dp)
        .background(Theme.colors.bottomBarBack,
            shape = RoundedCornerShape(20.dp)
        ),
        contentAlignment = Alignment.Center){
        Row(modifier = Modifier
            .padding(horizontal = 56.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(
                onClick = {
                    if(currentScreen != Navigation.Menu){
                        navController.navigate(Navigation.Menu)
                    }
                }
            ) {
                Icon(painter = painterResource(R.drawable.shop_icon),
                    contentDescription = null,
                    tint = if(currentScreen == Navigation.Menu){
                        Theme.colors.activeBottomIcon
                    } else{
                        colorResource(R.color.inactive)
                    })
            }
            IconButton(
                onClick = {
                    if(currentScreen != Navigation.RewardScreen){
                        navController.navigate(Navigation.RewardScreen)
                    }
                }
            ) {
                Icon(painter = painterResource(R.drawable.gift_icon),
                    contentDescription = null,
                    tint = if(currentScreen == Navigation.RewardScreen){
                        Theme.colors.activeBottomIcon
                    } else{
                        colorResource(R.color.inactive)
                    })
            }
            IconButton(
                onClick = {
                    if(currentScreen != Navigation.MyOrderHistory){
                        navController.navigate(Navigation.MyOrderHistory)
                    }
                }
            ) {
                Icon(painter = painterResource(R.drawable.chek_icon),
                    contentDescription = null,
                    tint = if(currentScreen == Navigation.MyOrderHistory){
                        Theme.colors.activeBottomIcon
                    } else{
                        colorResource(R.color.inactive)
                    })
            }
        }
    }
}