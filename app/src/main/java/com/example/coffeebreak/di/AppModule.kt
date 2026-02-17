package com.example.coffeebreak.di

import com.example.coffeebreak.data.repositoryImpl.AuthRepositoryImpl
import com.example.coffeebreak.domain.repository.AuthRepository
import com.example.coffeebreak.domain.usecase.AuthUseCase
import com.example.coffeebreak.domain.usecase.RegistrationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository{
        return AuthRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(
        authRepository: AuthRepository
    ): AuthUseCase{
        return AuthUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideRegistrationUseCase(
        authRepository: AuthRepository
    ): RegistrationUseCase{
        return RegistrationUseCase(authRepository)
    }
}