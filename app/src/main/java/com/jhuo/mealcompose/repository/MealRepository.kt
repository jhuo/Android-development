package com.jhuo.mealcompose.repository

import com.jhuo.mealcompose.data.model.CategoryResponse

interface MealRepository {
    suspend fun getCategoryList(): CategoryResponse
}