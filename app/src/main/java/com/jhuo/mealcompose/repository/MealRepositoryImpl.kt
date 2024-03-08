package com.jhuo.mealcompose.repository

import com.jhuo.mealcompose.api.MealApi
import com.jhuo.mealcompose.data.model.CategoryResponse
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val api: MealApi
): MealRepository {
    override suspend fun getCategoryList(): CategoryResponse {
        return api.getCategoryList()
    }
}