package com.example.coffeebreak.presentation.Additives

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.BottomNavigationBar
import com.example.coffeebreak.common.dmSans
import com.example.coffeebreak.common.robotoMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun AdditivesScreen(navController: NavController, vm: AdditivesVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Row(modifier = Modifier
                .padding(top = 21.dp)
                .padding(start = 26.dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween){
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(painter = painterResource(R.drawable.arrow_left),
                        contentDescription = null,
                        tint = Theme.colors.backIcon)
                }
                Text(text = stringResource(R.string.order_constructor),
                    color = Theme.colors.topScreenText,
                    fontWeight = FontWeight(500),
                    fontFamily = robotoMedium,
                    fontSize = 16.sp
                )
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(painter = painterResource(R.drawable.cart_icon),
                        contentDescription = null,
                        tint = Theme.colors.backIcon,
                        modifier = Modifier.size(24.dp))
                }
            }

            Text(text = stringResource(R.string.choose_country),
                color = Theme.colors.chooseBarista,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                fontFamily = robotoRegular,
                modifier = Modifier
                    .padding(top = 28.dp)
                    .padding(start = 29.dp)
            )

            if(state.load){
                CircularProgressIndicator(color = Theme.colors.feelBarista)
            } else{
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalItemSpacing = 17.dp,
                    modifier = Modifier
                        .padding(top = 21.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                ) {
                    items(state.additivesList){ item ->
                        Column(modifier = Modifier
                            .height(243.dp)
                            .clickable{
                                navController.navigate(Navigation.Designer)
                            }) {
                            AsyncImage(
                                model = item.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape((20.dp)))
                                    .size(158.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = item.name,
                                color = Color.Black,
                                fontFamily = dmSans,
                                fontSize = 17.sp,
                                fontWeight = FontWeight(400),
                                modifier = Modifier
                                    .padding(top = 7.dp)
                            )
                            Text(
                                text = item.description,
                                color = colorResource(R.color.bg),
                                fontFamily = dmSans,
                                fontSize = 10.sp,
                                fontWeight = FontWeight(400),
                                modifier = Modifier
                                    .padding(top = 7.dp)
                            )
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .padding(bottom = 18.dp)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            BottomNavigationBar(navController, Navigation.Menu)
        }
    }
}