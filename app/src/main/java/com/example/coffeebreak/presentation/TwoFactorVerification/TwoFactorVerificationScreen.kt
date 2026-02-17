package com.example.coffeebreak.presentation.TwoFactorVerification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.ModifiedOutlinedTf
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.presentation.TwoFactorVerification.common.OutlinedData
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun TwoFactorVerificationScreen(navController: NavController, vm: TwoFactorVm = hiltViewModel()) {
    val state = vm.state.value
    val tfList = listOf(
        OutlinedData(
            state.firstNumber,
            onValueChange = {vm.onEvent(TwoFactorEvent.EnteredFirstNumber(it))}
        ),
        OutlinedData(
            state.secondNumber,
            onValueChange = {vm.onEvent(TwoFactorEvent.EnteredSecondNumber(it))}
        ),
        OutlinedData(
            state.thirdNumber,
            onValueChange = {vm.onEvent(TwoFactorEvent.EnteredThirdNumber(it))}
        ),
        OutlinedData(
            state.fourthNumber,
            onValueChange = {vm.onEvent(TwoFactorEvent.EnteredFourthNumber(it))}
        ),
    )
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 26.dp)
            ) {
                Icon(painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Theme.colors.backIcon)
            }
            Column(modifier = Modifier
                .padding(top = 46.dp)
                .padding(horizontal = 41.dp)
                .fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.check),
                    fontWeight = FontWeight(400),
                    fontFamily = robotoRegular,
                    fontSize = 22.sp,
                    color = Theme.colors.signIn
                )
                Text(
                    text = stringResource(R.string.enter_code),
                    color = Theme.colors.welcomeText,
                    fontSize = 14.sp,
                    fontFamily = robotoRegular,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(bottom = 54.dp)
                )
                Row(modifier = Modifier
                    .padding(horizontal = 17.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    tfList.forEach { item ->
                        ModifiedOutlinedTf(
                            item.value,
                            item.onValueChange
                        )
                    }
                }
                Text(text = stringResource(R.string.resend) + state.time.toString(),
                    color = Theme.colors.resend,
                    fontWeight = FontWeight(400),
                    fontFamily = robotoRegular,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 46.dp)
                        .align(Alignment.CenterHorizontally))
                IconButton(
                    onClick = {
                        navController.navigate(Navigation.ResetPassword)
                    },
                    modifier = Modifier
                        .padding(top = 62.dp)
                        .align(Alignment.End)
                        .clip(CircleShape)
                        .background(
                            color = colorResource(R.color.mainColor),
                            shape = CircleShape
                        )
                        .size((64.dp)),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(R.color.mainColor),
                        contentColor = Color.Unspecified
                    )
                ) {
                    Icon(painter = painterResource(R.drawable.arrow_next),
                        contentDescription = null,
                        tint = Theme.colors.mainBackground,
                        modifier = Modifier
                            .size(32.dp))
                }
            }
        }
    }
}