package com.example.coffeebreak.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.coffeebreak.R

@Composable
fun ErrorAlertDialog(
    error: String,
    onErrorChange: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            onErrorChange()
        },
        title = {
            Text(text = stringResource(R.string.error_alert))
        },
        text = {
            Text(text = error)
        },
        confirmButton = {
            Button(
                onClick = {
                    onErrorChange()
                }
            ) {
                Text(text = "OK")
            }
        }
    )
}