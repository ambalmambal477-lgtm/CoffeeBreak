package com.example.coffeebreak.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun ModifiedOutlinedTf(
    value: String,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Theme.colors.outlinedTf,
                shape = RoundedCornerShape(10.dp)
            )
            .size(48.dp, 61.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Theme.colors.feelBarista,
            unfocusedTextColor = Theme.colors.feelBarista,
            focusedContainerColor = Theme.colors.outlinedTf,
            unfocusedContainerColor = Theme.colors.outlinedTf,
            focusedBorderColor = Theme.colors.outlinedTf,
            unfocusedBorderColor = Theme.colors.outlinedTf
        ),
        singleLine = true
    )
}