package com.faezolfp.ubersnaptodoapp.di

import com.faezolfp.ubersnaptodoapp.core.domain.usecase.ImplUseCase
import com.faezolfp.ubersnaptodoapp.core.domain.usecase.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun pprovideUseCase(implUseCase: ImplUseCase): UseCase
}