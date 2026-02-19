package com.example.coffeebreak.presentation.Menu

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.BottomNavigationBar
import com.example.coffeebreak.common.dmSans
import com.example.coffeebreak.common.poppinsMedium
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme

@Composable
fun MenuScreen(navController: NavController, vm: MenuVM = hiltViewModel()) {
    val state = vm.state.value
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            Row(modifier = Modifier
                .padding(top = 27.dp)
                .padding(start = 26.dp)
                .padding(end = 33.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                Column{
                    Text(text = stringResource(R.string.welcome_menu),
                        color = colorResource(R.color.placeholder),
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp
                    )
                    Text(text = "Алексей",
                        color = colorResource(R.color.nameMenu),
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = robotoRegular)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(R.drawable.cart_icon),
                        contentDescription = null,
                        tint = Theme.colors.menuIcons,
                        modifier = Modifier
                            .clickable{
                                navController.navigate(Navigation.MyOrderCurrent)
                            })
                    Icon(painter = painterResource(R.drawable.menu_profile),
                        contentDescription = null,
                        tint = Theme.colors.menuIcons,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .clickable {
                                navController.navigate(Navigation.Profile)
                            })
                }
            }
            Box(modifier = Modifier
                .padding(top = 7.dp)
                .fillMaxSize()
                .background(color = Theme.colors.menuBox,
                    shape = RoundedCornerShape(topStart = 25.dp,
                        topEnd = 25.dp))){
                Column(modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()) {
                    Text(text = stringResource(R.string.choose_coffee),
                        color = colorResource(R.color.chooseCoffee),
                        fontFamily = robotoRegular,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp)
                    if (state.load){
                        CircularProgressIndicator(color = Theme.colors.feelBarista)
                    } else {
                        LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalItemSpacing = 17.dp,
                            modifier = Modifier
                                .padding(top = 29.dp)
                                .fillMaxWidth()
                        ) {
                            items(state.coffeeList){ item ->
                                Box(modifier = Modifier
                                    .height(164.dp)
                                    .background(Color.White,
                                        shape = RoundedCornerShape(15.dp)
                                    )
                                    .clickable{
                                        navController.navigate(Navigation.OrderOptions)
                                    }){
                                    Column(modifier = Modifier
                                        .padding(top = 20.dp)
                                        .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally) {
                                        AsyncImage(
                                            model = item.image,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .height(85.dp),
                                            contentScale = ContentScale.FillHeight
                                        )
                                        Text(text = item.name,
                                            color = colorResource(R.color.menuText),
                                            fontWeight = FontWeight(500),
                                            fontSize = 14.sp,
                                            fontFamily = dmSans,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier
                                                .padding(top = 12.dp)
                                        )
                                        Box(Modifier
                                            .padding(top = 2.dp)
                                            .padding(end = 7.dp)
                                            .padding(bottom = 7.dp)
                                            .fillMaxWidth(),
                                            contentAlignment = Alignment.TopEnd){
                                            Text(text = item.price.toString() + "₽",
                                                color = colorResource(R.color.menuText),
                                                fontWeight = FontWeight(400),
                                                fontFamily = poppinsMedium,
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .padding(bottom = 22.dp)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            BottomNavigationBar(navController, Navigation.Menu)
        }
    }
}