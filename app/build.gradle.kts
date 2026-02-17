import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "2.0.21"
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.coffeebreak"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.coffeebreak"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "GOOGLE_ID",
            "\"${getLocalProperty("GOOGLE_ID")}\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    //lifecycle
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.compose.ui.geometry)

    //coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    //qr
    implementation(libs.core)

    //hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.navigation.testing)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation)

    androidTestImplementation (libs.hilt.android.testing)
    androidTestImplementation (libs.androidx.core)
    androidTestImplementation (libs.androidx.runner)
    androidTestImplementation (libs.androidx.junit)
    androidTestImplementation (libs.androidx.ui.test.junit4)


    //ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)

    //supabase
    implementation(platform(libs.bom))
    implementation(libs.postgrest.kt)
    implementation(libs.auth.kt)
    implementation(libs.realtime.kt)
    implementation(libs.storage.kt)
    implementation(libs.compose.auth)

    //navigation
    implementation (libs.androidx.navigation.compose)

    //карта
    implementation(libs.maps.mobile)

    //google
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)

    //tensorflow lite
    implementation(libs.tensorflow.lite)
    implementation(libs.tensorflow.lite.task.vision)
    implementation (libs.tensorflow.lite.support)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

private fun getLocalProperty(key: String): String{
    val properties = Properties()
    val localPropertiesFile = project.rootProject.file("local.properties")
    return if(localPropertiesFile.exists()){
        localPropertiesFile.inputStream().use { properties.load(it) }
        properties.getProperty(key, "")
    } else{
        ""
    }
}