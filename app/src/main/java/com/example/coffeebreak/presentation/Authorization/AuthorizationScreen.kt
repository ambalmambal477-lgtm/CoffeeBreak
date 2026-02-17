package com.example.coffeebreak.presentation.Authorization

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.coffeebreak.common.ModifiedTextField
import com.example.coffeebreak.common.TfData
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.data.supabase.Connect.supabase
import com.example.coffeebreak.ui.theme.Theme
import io.github.jan.supabase.compose.auth.composable.GoogleDialogType
import io.github.jan.supabase.compose.auth.composable.NativeSignInResult
import io.github.jan.supabase.compose.auth.composable.rememberSignInWithGoogle
import io.github.jan.supabase.compose.auth.composeAuth

@Composable
fun AuthorizationScreen(navController: NavController, vm: AuthorizationVM = hiltViewModel()) {
    val state = vm.state.value
    LaunchedEffect(state.isComplete) {
        if(state.isComplete){
            navController.navigate(Navigation.Startup)
        }
    }
    val action = supabase.composeAuth.rememberSignInWithGoogle(
        type = GoogleDialogType.BOTTOM_SHEET,
        onResult = { result ->
            when(result){
                NativeSignInResult.ClosedByUser -> {
                    Log.e("google", "close")
                }
                is NativeSignInResult.Error -> {
                    Log.e("google", result.message)
                }
                is NativeSignInResult.NetworkError -> {
                    Log.e("google", "network error")
                }
                NativeSignInResult.Success -> {
                    Log.e("google", "success")
                }
            }
        }
    )
    val tfList = listOf(
        TfData(
            leadingIcon = R.drawable.email_icon,
            placeholder = stringResource(R.string.email_address),
            value = state.email,
            onValueChange = {vm.onEvent(AuthorizationEvent.EnteredEmail(it))},
            trailingIcon = false,
            visual = false,
            visualChange = {},
            padding = 0
        ),
        TfData(
            leadingIcon = R.drawable.lock_icon,
            placeholder = stringResource(R.string.password),
            value = state.password,
            onValueChange = {vm.onEvent(AuthorizationEvent.EnteredPassword(it))},
            trailingIcon = true,
            visual = state.visual,
            visualChange = {vm.onEvent(AuthorizationEvent.VisualTranform)},
            padding = 36
        )
    )
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Column(modifier = Modifier
                .padding(top = 91.dp)
                .padding(horizontal = 41.dp)
                .fillMaxWidth()) {
                Text(text = stringResource(R.string.sign_in),
                    fontWeight = FontWeight(400),
                    fontFamily = robotoRegular,
                    fontSize = 22.sp,
                    color = Theme.colors.signIn
                )
                Text(text = stringResource(R.string.welcome),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = robotoRegular,
                    color = Theme.colors.welcomeText,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(bottom = 57.dp))
                tfList.forEach { item ->
                    ModifiedTextField(
                        item.leadingIcon,
                        item.placeholder,
                        item.value,
                        item.onValueChange,
                        item.trailingIcon,
                        item.visual,
                        item.visualChange,
                        item.padding
                    )
                }
                Text(text = stringResource(R.string.forgot_password),
                    color = Theme.colors.forgotPassword,
                    modifier = Modifier
                        .padding(top = 27.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable{
                            navController.navigate(Navigation.ForgotPassword)
                        },
                    fontFamily = robotoRegular,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp)

            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Column(modifier = Modifier
                .padding(bottom = 82.dp)
                .padding(start = 41.dp)
                .padding(end = 47.dp)
                .fillMaxWidth()){
                Button(
                    onClick = {
                        vm.onEvent(AuthorizationEvent.Auth)
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                        .clip(CircleShape)
                        .background(
                            color = colorResource(R.color.mainColor),
                            shape = CircleShape
                        )
                        .size((64.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.mainColor),
                        contentColor = Color.Unspecified
                    )
                ) {
                    Icon(painter = painterResource(R.drawable.arrow_right),
                        contentDescription = null,
                        tint = Theme.colors.mainBackground)
                }
                Text(text = stringResource(R.string.sign_in_with),
                    color = Theme.colors.signInWith,
                    modifier = Modifier
                        .padding(top = 19.dp)
                        .align(Alignment.CenterHorizontally),
                    fontFamily = robotoRegular,
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp)
                Row(modifier = Modifier
                    .padding(top = 14.dp)
                    .align(Alignment.CenterHorizontally)) {
                    Icon(painter = painterResource(R.drawable.yandex),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp))
                    Icon(painter = painterResource(R.drawable.google),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clip(CircleShape)
                            .size(40.dp)
                            .clickable {
                                action.startFlow()
                            })
                    Icon(painter = painterResource(R.drawable.vk),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clip(CircleShape)
                            .size(40.dp)
                    )
                }
                Row(modifier = Modifier
                    .padding(top = 36.dp)
                    .align(Alignment.Start)) {
                    Text(text = stringResource(R.string.first_time),
                        color = colorResource(R.color.anyCoffee),
                        fontSize = 14.sp,
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight(400))
                    Text(text = stringResource(R.string.sign_up_auth),
                        color = Theme.colors.signUpAuth,
                        fontSize = 14.sp,
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight(400),
                        modifier = Modifier
                            .clickable{
                                navController.navigate(Navigation.Registration)
                            })
                }
            }
        }
    }
}