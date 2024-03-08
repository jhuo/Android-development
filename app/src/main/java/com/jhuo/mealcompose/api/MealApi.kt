package com.jhuo.mealcompose.api

import com.jhuo.mealcompose.data.model.CategoryResponse
import retrofit2.http.GET

interface MealApi {
    @GET("categories.php")
    suspend fun getCategoryList(): CategoryResponse
}
