package com.example.coffeebreak.presentation.ResetPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.example.coffeebreak.common.ErrorAlertDialog
import com.example.coffeebreak.common.ModifiedTextField
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun ResetPasswordScreen(navController: NavController, vm: ResetPasswordVM = hiltViewModel()) {
    val state = vm.state.value
    if(state.error){
        ErrorAlertDialog(error = stringResource(R.string.error_alert)) {
            vm.onEvent(ResetPasswordEvent.ShowError)
        }
    }
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
                    text = stringResource(R.string.reset_password),
                    fontWeight = FontWeight(400),
                    fontFamily = robotoRegular,
                    fontSize = 22.sp,
                    color = Theme.colors.signIn
                )
                Text(
                    text = stringResource(R.string.enter_new_password),
                    color = Theme.colors.welcomeText,
                    fontSize = 14.sp,
                    fontFamily = robotoRegular,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(bottom = 46.dp)
                )
                ModifiedTextField(
                    leadingIcon = R.drawable.lock_icon,
                    placeholder = stringResource(R.string.password),
                    value = state.password,
                    onValueChange = { vm.onEvent(ResetPasswordEvent.EnteredPassword(it))},
                    trailingIcon = false,
                    visual = false,
                    visualChange = {},
                    padding = 0
                )
                IconButton(
                    onClick = {
                        vm.onEvent(ResetPasswordEvent.PasswordValid)
                        if(state.passwordValid) {
                            navController.navigate(Navigation.Menu)
                        } else{
                            vm.onEvent(ResetPasswordEvent.ShowError)
                        }
                    },
                    modifier = Modifier
                        .padding(top = 165.dp)
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