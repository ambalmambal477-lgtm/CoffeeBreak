package com.example.coffeebreak.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeebreak.R
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun ModifiedTextField(
    leadingIcon: Int,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    trailingIcon: Boolean,
    visual: Boolean,
    visualChange: () -> Unit,
    padding: Int
) {
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        leadingIcon = {
            Row {
                Icon(painterResource(leadingIcon),
                    contentDescription = null,
                    tint = Theme.colors.tfIcon)
                Box(modifier = Modifier
                    .padding(start = 9.dp)
                    .background(colorResource(R.color.tfColor))
                    .size(width = 1.dp, height = 25.dp)
                )
            }
        },
        trailingIcon = {
            if(trailingIcon){
                IconButton(
                    onClick = {
                        visualChange()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.eye_icon),
                        contentDescription = null,
                        tint = Theme.colors.eyeColor
                    )
                }
            }
        },
        colors = TextFieldDefaults.colors(
            disabledTextColor = Theme.colors.feelBarista,
            disabledIndicatorColor = colorResource(R.color.tfColor),
            focusedIndicatorColor = colorResource(R.color.tfColor),
            focusedTextColor = Theme.colors.feelBarista,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedTextColor = Theme.colors.feelBarista
        ),
        modifier = Modifier
            .padding(top = padding.dp)
            .fillMaxWidth(),
        placeholder = {
            Text(text = placeholder,
                fontWeight = FontWeight(500),
                fontFamily = robotoRegular,
                fontSize = 12.sp,
                color = colorResource(R.color.placeholder))
        },
        visualTransformation = if(visual){
            PasswordVisualTransformation()
        } else{
            VisualTransformation.None
        }
    )
}