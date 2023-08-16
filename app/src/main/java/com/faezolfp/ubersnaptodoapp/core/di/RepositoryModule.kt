package com.faezolfp.ubersnaptodoapp.core.di

import com.faezolfp.ubersnaptodoapp.core.data.ImplRepository
import com.faezolfp.ubersnaptodoapp.core.domain.repository.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class])
@Singleton
abstract class RepositoryModule {
    @Binds
    abstract fun providesRepository(implRepository: ImplRepository): Repository
}