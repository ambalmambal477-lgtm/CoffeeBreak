package com.example.coffeebreak.presentation.Profile

import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeebreak.R
import com.example.coffeebreak.common.poppinsMedium
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun ProfileScreen(navController: NavController, vm: ProfileVM = hiltViewModel()) {
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
                Text(text = stringResource(R.string.profile),
                    color = Theme.colors.topScreenText,
                    fontFamily = robotoMedium,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(modifier = Modifier
                .padding(top = 29.dp)
                .padding(horizontal = 33.dp)
                .fillMaxWidth()) {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier
                            .background(
                                Theme.colors.profileIconsBack,
                                shape = CircleShape
                            )
                            .size(42.dp),
                            contentAlignment = Alignment.Center){
                            Icon(painter = painterResource(R.drawable.profile_icon),
                                contentDescription = null,
                                tint = Theme.colors.profileIcons,
                                modifier = Modifier
                                    .size(20.dp))
                        }
                        Column(modifier = Modifier
                            .padding(start = 16.dp)) {
                            Text(text = stringResource(R.string.name),
                                color = Theme.colors.titleProfileText,
                                fontWeight = FontWeight(500),
                                fontFamily = poppinsMedium,
                                fontSize = 10.sp
                            )
                            Text(text = "Алексей",
                                color = Theme.colors.infoProfileText,
                                fontWeight = FontWeight(600),
                                fontFamily = robotoRegular,
                                fontSize = 14.sp
                            )
                        }
                    }
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(painter = painterResource(R.drawable.edit_icon),
                            contentDescription = null,
                            tint = Theme.colors.activeBottomIcon)
                    }
                }

                Row(modifier = Modifier
                    .padding(top = 26.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier
                            .background(
                                Theme.colors.profileIconsBack,
                                shape = CircleShape
                            )
                            .size(42.dp),
                            contentAlignment = Alignment.Center){
                            Icon(painter = painterResource(R.drawable.phone),
                                contentDescription = null,
                                tint = Theme.colors.profileIcons)
                        }
                        Column(modifier = Modifier
                            .padding(start = 16.dp)) {
                            Text(text = stringResource(R.string.phone_number),
                                color = Theme.colors.titleProfileText,
                                fontWeight = FontWeight(500),
                                fontFamily = poppinsMedium,
                                fontSize = 10.sp
                            )
                            Text(text = "+7 812 324 6345",
                                color = Theme.colors.infoProfileText,
                                fontWeight = FontWeight(600),
                                fontFamily = robotoRegular,
                                fontSize = 14.sp
                            )
                        }
                    }
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(painter = painterResource(R.drawable.edit_icon),
                            contentDescription = null,
                            tint = Theme.colors.activeBottomIcon)
                    }
                }

                Row(modifier = Modifier
                    .padding(top = 26.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier
                            .background(
                                Theme.colors.profileIconsBack,
                                shape = CircleShape
                            )
                            .size(42.dp),
                            contentAlignment = Alignment.Center){
                            Icon(painter = painterResource(R.drawable.message_icon),
                                contentDescription = null,
                                tint = Theme.colors.profileIcons)
                        }
                        Column(modifier = Modifier
                            .padding(start = 16.dp)) {
                            Text(text = stringResource(R.string.email),
                                color = Theme.colors.titleProfileText,
                                fontWeight = FontWeight(500),
                                fontFamily = poppinsMedium,
                                fontSize = 10.sp
                            )
                            Text(text = "apolsdiapoui@gmail.com",
                                color = Theme.colors.infoProfileText,
                                fontWeight = FontWeight(600),
                                fontFamily = robotoRegular,
                                fontSize = 14.sp
                            )
                        }
                    }
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(painter = painterResource(R.drawable.edit_icon),
                            contentDescription = null,
                            tint = Theme.colors.activeBottomIcon)
                    }
                }

                Row(modifier = Modifier
                    .padding(top = 26.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier
                            .background(
                                Theme.colors.profileIconsBack,
                                shape = CircleShape
                            )
                            .size(42.dp),
                            contentAlignment = Alignment.Center){
                            Icon(painter = painterResource(R.drawable.location_profile),
                                contentDescription = null,
                                tint = Theme.colors.profileIcons)
                        }
                        Column(modifier = Modifier
                            .padding(start = 16.dp)) {
                            Text(text = stringResource(R.string.magic_coffee),
                                color = Theme.colors.titleProfileText,
                                fontWeight = FontWeight(500),
                                fontFamily = poppinsMedium,
                                fontSize = 10.sp
                            )
                            Text(text = "г. Оренбург, ул. Чкалова 32",
                                color = Theme.colors.infoProfileText,
                                fontWeight = FontWeight(600),
                                fontFamily = robotoRegular,
                                fontSize = 14.sp
                            )
                        }
                    }
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(painter = painterResource(R.drawable.edit_icon),
                            contentDescription = null,
                            tint = Theme.colors.activeBottomIcon)
                    }
                }

                Row(modifier = Modifier
                    .padding(top = 26.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier
                            .background(
                                Theme.colors.profileIconsBack,
                                shape = CircleShape
                            )
                            .size(42.dp),
                            contentAlignment = Alignment.Center){
                            Icon(painter = painterResource(R.drawable.qr),
                                contentDescription = null,
                                tint = Theme.colors.profileIcons)
                        }
                        Column(modifier = Modifier
                            .padding(start = 16.dp)) {
                            Text(text = stringResource(R.string.qr),
                                color = Theme.colors.titleProfileText,
                                fontWeight = FontWeight(500),
                                fontFamily = poppinsMedium,
                                fontSize = 10.sp
                            )
                            Text(text = stringResource(R.string.for_order),
                                color = Theme.colors.infoProfileText,
                                fontWeight = FontWeight(600),
                                fontFamily = robotoRegular,
                                fontSize = 14.sp
                            )
                        }
                    }
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(painter = painterResource(R.drawable.more_icon),
                            contentDescription = null,
                            tint = Theme.colors.activeBottomIcon)
                    }
                }
            }
        }

        if(state.qr){
            Box(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Theme.colors.mainBackground)){
                Column(modifier = Modifier
                    .fillMaxSize()) {
                    Box(modifier = Modifier
                        .padding(top = 21.dp)
                        .fillMaxWidth(),
                        contentAlignment = Alignment.Center){
                        IconButton(
                            onClick = {
                                vm.onEvent(ProfileEvent.ShowQR)
                            },
                            modifier = Modifier
                                .padding(start = 26.dp)
                                .align(Alignment.TopStart)
                        ) {
                            Icon(painterResource(R.drawable.arrow_left),
                                contentDescription = null,
                                tint = Theme.colors.backIcon)
                        }
                        Text(text = stringResource(R.string.profile),
                            color = Theme.colors.topScreenText,
                            fontFamily = robotoMedium,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}