package com.faezolfp.ubersnaptodoapp.core.di

import com.faezolfp.ubersnaptodoapp.core.data.ImplRepository
import com.faezolfp.ubersnaptodoapp.core.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providesRepository(implRepository: ImplRepository): Repository
}