package com.example.coffeebreak.data.supabase

import com.example.coffeebreak.BuildConfig
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.googleNativeLogin
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest


//объект для подключения к supabase
object Connect {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://ofxftxoekryasmmesvmk.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9meGZ0eG9la3J5YXNtbWVzdm1rIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzEyOTgxOTUsImV4cCI6MjA4Njg3NDE5NX0.kempwRqH1EYv3R_-EN3CfMlA0ypuUoUiD0785a4Jadc"
    ){
        install(Auth)
        install(Postgrest)
        install(ComposeAuth){
            googleNativeLogin(BuildConfig.GOOGLE_ID)
        }
    }
}