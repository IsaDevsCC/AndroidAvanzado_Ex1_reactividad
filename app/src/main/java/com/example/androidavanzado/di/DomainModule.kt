package com.example.androidavanzado.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 *  DOMAIN PROVEE LAS DEPENDENCIAS QUE SE NECESITAN (PASO1)
 * */
/*@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesGetHeroListUseCase() : GetHeroListUseCase {
        return GetHeroListUseCase()
    }
}*/