package com.example.coffeebreak.di

import com.example.coffeebreak.data.repositoryImpl.AdditivesRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.AuthRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.BaristaRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.CoffeeRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.CoffeeShopRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.CoffeeTypeRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.CountryRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.OrderRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.ProfileRepositoryImpl
import com.example.coffeebreak.data.repositoryImpl.RedeemRepositoryImpl
import com.example.coffeebreak.domain.repository.AdditivesRepository
import com.example.coffeebreak.domain.repository.AuthRepository
import com.example.coffeebreak.domain.repository.BaristaRepository
import com.example.coffeebreak.domain.repository.CoffeeRepository
import com.example.coffeebreak.domain.repository.CoffeeShopRepository
import com.example.coffeebreak.domain.repository.CoffeeTypeRepository
import com.example.coffeebreak.domain.repository.CountryRepository
import com.example.coffeebreak.domain.repository.OrderRepository
import com.example.coffeebreak.domain.repository.ProfileRepository
import com.example.coffeebreak.domain.repository.RedeemRepository
import com.example.coffeebreak.domain.usecase.AuthUseCase
import com.example.coffeebreak.domain.usecase.IsEmailValidUseCase
import com.example.coffeebreak.domain.usecase.IsPasswordValidUseCase
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
    fun provideCoffeeShopRepository(): CoffeeShopRepository{
        return CoffeeShopRepositoryImpl()
    }
    @Provides
    @Singleton
    fun provideCoffeeRepository(): CoffeeRepository{
        return CoffeeRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideRedeemRepository(): RedeemRepository{
        return RedeemRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideBaristaRepository(): BaristaRepository{
        return BaristaRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCountryRepository(): CountryRepository{
        return CountryRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCoffeeTypeRepository(): CoffeeTypeRepository{
        return CoffeeTypeRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideAdditivesRepository(): AdditivesRepository{
        return AdditivesRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideOrderRepository(): OrderRepository{
        return OrderRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideProfileRepository(): ProfileRepository{
        return ProfileRepositoryImpl()
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

    @Provides
    @Singleton
    fun provideIsPasswordValidUseCase(): IsPasswordValidUseCase{
        return IsPasswordValidUseCase()
    }

    @Provides
    @Singleton
    fun provideIsEmailValidUseCase(): IsEmailValidUseCase{
        return IsEmailValidUseCase()
    }
}