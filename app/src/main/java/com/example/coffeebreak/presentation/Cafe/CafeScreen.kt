package com.example.coffeebreak.presentation.Cafe

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeebreak.Navigation
import com.example.coffeebreak.R
import com.example.coffeebreak.common.robotoRegular
import com.example.coffeebreak.ui.theme.Theme
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

@SuppressLint("MissingPermission")
@Composable
fun CafeScreen(navController: NavController, vm: CafeVM = hiltViewModel()) {
    val state = vm.state.value
    val context = LocalContext.current
    val mapView = remember { MapView(context) }
    val mapObjects = remember { mapView.map.mapObjects.addCollection() }
    var permissionGranted by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(state.isComplete) {
        if(state.isComplete){
            navController.navigate(Navigation.Startup)
        }
    }
    Scaffold(modifier = Modifier
        .fillMaxSize()){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Theme.colors.mainBackground)){
            DisposableEffect(Unit) {
                MapKitFactory.getInstance().onStart()
                mapView.onStart()

                onDispose {
                    mapView.onStop()
                    MapKitFactory.getInstance().onStop()
                }
            }

            if(!permissionGranted){
                RequestLocationPermission {
                    permissionGranted = true
                }
            }

            LaunchedEffect(permissionGranted) {
                getCurrentLocation(context){ point ->
                    vm.onEvent(CafeEvent.OnUserLocationReceived(point))
                }
            }

            LaunchedEffect(state.cafeLocations) {
                mapObjects.clear()
                state.cafeLocations.forEach { point ->
                    val placemark = mapObjects.addPlacemark(point)
                    placemark.setIcon(
                        ImageProvider.fromResource(context, R.drawable.cafe_location)
                    )
                }
            }

            LaunchedEffect(state.userLocation) {
                state.userLocation?.let {
                    val placemark = mapObjects.addPlacemark(state.userLocation)
                    placemark.setIcon(
                        ImageProvider.fromResource(context, R.drawable.user_location)
                    )

                    mapView.map.move(
                        CameraPosition(state.userLocation, 16f, 0f, 0f)
                    )
                }
            }

            AndroidView(
                factory = {mapView},
                modifier = Modifier
                    .fillMaxSize()
            )
            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(start = 26.dp)
                    .padding(top = 21.dp)
            ) {
                Icon(painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null,
                    tint = Theme.colors.backIcon)
            }
        }
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Column {
                Icon(painter = painterResource(R.drawable.target_icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(end = 30.dp)
                        .align(Alignment.End)
                        .clickable {
                            state.userLocation?.let {
                                mapView.map.move(
                                    CameraPosition(state.userLocation, 16f, 0f, 0f)
                                )
                            }
                        })
                Box(modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .background(
                        color = colorResource(R.color.mainColor),
                        shape = RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp
                        )
                    )){
                    if(state.load){
                        CircularProgressIndicator(color = Color.White)
                    }else {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.choose_cafe),
                                color = Color.White,
                                fontWeight = FontWeight(500),
                                fontFamily = robotoRegular,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(top = 27.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .padding(top = 31.dp)
                                    .fillMaxWidth()
                                    .background(
                                        Theme.colors.cafeBox,
                                        shape = RoundedCornerShape(
                                            topStart = 25.dp,
                                            topEnd = 25.dp
                                        )
                                    )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(top = 21.dp)
                                        .padding(bottom = 21.dp)
                                        .padding(horizontal = 30.dp)
                                        .fillMaxWidth()
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                colorResource(R.color.mainColor),
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                            .clickable{
                                                vm.onEvent(CafeEvent.Next)
                                            }
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(vertical = 13.dp)
                                                .padding(horizontal = 15.dp)
                                                .fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Icon(
                                                    painterResource(R.drawable.cafe_icon),
                                                    contentDescription = null,
                                                    tint = Color.Unspecified
                                                )
                                                Text(
                                                    text = state.coffeeShopList[0].address,
                                                    color = Color.White,
                                                    fontFamily = robotoRegular,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight(600),
                                                    modifier = Modifier
                                                        .padding(start = 11.dp)
                                                )
                                            }
                                            Icon(
                                                painter = painterResource(R.drawable.icon_more),
                                                contentDescription = null,
                                                tint = Color.Unspecified
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .padding(top = 7.dp)
                                            .fillMaxWidth()
                                            .background(
                                                colorResource(R.color.mainColor),
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                            .clickable{
                                                vm.onEvent(CafeEvent.Next)
                                            }
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 7.dp)
                                                .padding(vertical = 13.dp)
                                                .padding(horizontal = 15.dp)
                                                .fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Icon(
                                                    painterResource(R.drawable.cafe_icon),
                                                    contentDescription = null,
                                                    tint = Color.Unspecified
                                                )
                                                Text(
                                                    text = state.coffeeShopList[1].address,
                                                    color = Color.White,
                                                    fontFamily = robotoRegular,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight(600),
                                                    modifier = Modifier
                                                        .padding(start = 11.dp)
                                                )
                                            }
                                            Icon(
                                                painter = painterResource(R.drawable.icon_more),
                                                contentDescription = null,
                                                tint = Color.Unspecified
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .padding(top = 7.dp)
                                            .fillMaxWidth()
                                            .background(
                                                colorResource(R.color.mainColor),
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                            .clickable{
                                                vm.onEvent(CafeEvent.Next)
                                            }
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(top = 7.dp)
                                                .padding(vertical = 13.dp)
                                                .padding(horizontal = 15.dp)
                                                .fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Icon(
                                                    painterResource(R.drawable.cafe_icon),
                                                    contentDescription = null,
                                                    tint = Color.Unspecified
                                                )
                                                Text(
                                                    text = state.coffeeShopList[2].address,
                                                    color = Color.White,
                                                    fontFamily = robotoRegular,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight(600),
                                                    modifier = Modifier
                                                        .padding(start = 11.dp)
                                                )
                                            }
                                            Icon(
                                                painter = painterResource(R.drawable.icon_more),
                                                contentDescription = null,
                                                tint = Color.Unspecified
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
    }
}

@Composable
fun RequestLocationPermission(
    onGranted: () -> Unit
){
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if(isGranted){
            onGranted()
        }
    }
    LaunchedEffect(Unit) {
        permissionLauncher.launch(
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    }
}

@RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
private fun getCurrentLocation(
    context: Context,
    onLocation: (Point) -> Unit
){
    val client = LocationServices.getFusedLocationProviderClient(context)
    client.getCurrentLocation(
        Priority.PRIORITY_HIGH_ACCURACY,
        null
    ).addOnSuccessListener { location ->
        onLocation(Point(location.latitude, location.longitude))
    }
}