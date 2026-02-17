package com.example.coffeebreak.presentation.Registartion

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun RegistrationScreen(navController: NavController, vm: RegistrationVM = hiltViewModel()) {
    val state = vm.state.value
    LaunchedEffect(state.isComplete) {
        if(state.isComplete){
           navController.navigate(Navigation.Cafe)
        }
    }
    val tfList = listOf(
        TfData(
            leadingIcon = R.drawable.profile_icon,
            placeholder = stringResource(R.string.user_name),
            value = state.name,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredName(it))},
            trailingIcon = false,
            visual = false,
            visualChange = {},
            padding = 0
        ),
        TfData(
            leadingIcon = R.drawable.phone_icon,
            placeholder = stringResource(R.string.mobile_phone_number),
            value = state.number,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredNumber(it))},
            trailingIcon = false,
            visual = false,
            visualChange = {},
            padding = 36
        ),
        TfData(
            leadingIcon = R.drawable.email_icon,
            placeholder = stringResource(R.string.email_address),
            value = state.email,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredEmail(it))},
            trailingIcon = false,
            visual = false,
            visualChange = {},
            padding = 36
        ),
        TfData(
            leadingIcon = R.drawable.lock_icon,
            placeholder = stringResource(R.string.password),
            value = state.password,
            onValueChange = {vm.onEvent(RegistrationEvent.EnteredPassword(it))},
            trailingIcon = true,
            visual = state.visual,
            visualChange = {vm.onEvent(RegistrationEvent.ChangeVisual)},
            padding = 36
        )
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
                Text(text = stringResource(R.string.sign_up),
                    fontWeight = FontWeight(400),
                    fontFamily = robotoRegular,
                    fontSize = 22.sp,
                    color = Theme.colors.signIn
                )
                Text(text = stringResource(R.string.createaccounthere),
                    color = Theme.colors.welcomeText,
                    fontSize = 14.sp,
                    fontFamily = robotoRegular,
                    fontWeight = FontWeight(400),
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
                Row(modifier = Modifier
                    .padding(top = 22.dp),
                    verticalAlignment = Alignment.Top) {
                    Checkbox(
                        checked = state.checked,
                        onCheckedChange = {
                            vm.onEvent(RegistrationEvent.Checked)
                        },
                        modifier = Modifier
                            .border(
                                1.dp, color = colorResource(R.color.placeholder),
                                shape = RectangleShape
                            )
                            .background(Color.Transparent)
                            .size(17.dp),
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = colorResource(R.color.placeholder),
                            checkedColor = Color.Transparent,
                            uncheckedColor = Color.Transparent
                        )
                    )
                    Text(text = stringResource(R.string.iconfirm),
                        color = colorResource(R.color.confirm),
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 8.dp))
                }
                Button(
                    onClick = {
                        vm.onEvent(RegistrationEvent.Registration)
                    },
                    modifier = Modifier
                        .padding(top = 31.dp)
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
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomStart){
            Row(modifier = Modifier
                .padding(start = 41.dp)
                .padding(bottom = 82.dp)) {
                Text(text = stringResource(R.string.already_registered),
                    color = colorResource(R.color.anyCoffee),
                    fontSize = 14.sp,
                    fontFamily = robotoRegular,
                    fontWeight = FontWeight(400))
                Text(text = stringResource(R.string.sign_in_reg),
                    color = Theme.colors.signUpAuth,
                    fontSize = 14.sp,
                    fontFamily = robotoRegular,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .clickable{
                            navController.navigate(Navigation.Auth)
                        })
            }
        }
    }
}