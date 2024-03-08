package com.jhuo.mealcompose.di

import com.jhuo.mealcompose.api.MealApi
import com.jhuo.mealcompose.repository.MealRepository
import com.jhuo.mealcompose.repository.MealRepositoryImpl
import com.jhuo.mealcompose.util.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesMealApi(): MealApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MealApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMealRepository(mealApi: MealApi): MealRepository {
        return MealRepositoryImpl(mealApi)
    }
}