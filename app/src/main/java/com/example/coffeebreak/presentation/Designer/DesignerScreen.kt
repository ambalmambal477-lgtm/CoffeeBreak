package com.example.coffeebreak.presentation.Designer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun DesignerScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Text(text = stringResource(R.string.choose_barista),
                modifier = Modifier
                    .padding(top = 39.dp)
                    .padding(start = 29.dp)
                    .clickable {
                        navController.navigate(Navigation.Barista)
                    })
            Text(text = stringResource(R.string.sort_coffee),
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 29.dp)
                    .clickable {
                        navController.navigate(Navigation.CoffeeCountry)
                    })
            Text(text = stringResource(R.string.additives),
                modifier = Modifier
                    .padding(top = 21.dp)
                    .padding(start = 29.dp)
                    .clickable {
                        navController.navigate(Navigation.Additives)
                    })
        }
    }
}